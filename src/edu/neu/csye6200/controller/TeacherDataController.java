package edu.neu.csye6200.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.neu.csye6200.interfaces.DatabaseManager;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.RandomNumberUtil;
import edu.neu.csye6200.utils.SqlConnector;

/**
 * Teacher Data Controller
 * @author Kaushik Gnanasekar
 *
 */
public class TeacherDataController implements DatabaseManager<Teacher> {

	@Override
	public void loadFromCSV(String filename) {
		Teacher teacherObj = new Teacher();
		String file = filename != null ? filename : "teachers.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			int teacherId = RandomNumberUtil.generate(10000, 99999);
			teacherObj.setTeacherId(teacherId);
			teacherObj.setFirstName(stringArray[0]);
			teacherObj.setLastName(stringArray[1]);

			LocalDate registerDate = LocalDate.parse(stringArray[2]);
			teacherObj.setRegisterTime(registerDate);
			// Write to DB
			SqlConnector.executeUpdate("INSERT INTO teachers VALUES (" + 
					teacherObj.getTeacherId() + "," + "'" + teacherObj.getFirstName() + "'" + "," + "'" + teacherObj.getLastName() +  "'" +  "," + 
					"'" + teacherObj.getRegisterTime() + "'" + ");");
		}
		
	}

	@Override
	public List<Teacher> fetchDataFromDB(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> fetchAllFromDB() {
		List<Teacher> teacherRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM teachers;");
		try {
			while (result.next()) {
				LocalDate registerDate = LocalDate.parse(result.getString("register_time"));
				teacherRoster.add(new Teacher(result.getInt("teacher_id"), 
						result.getString("first_name"),
						result.getString("last_name"),
						registerDate
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherRoster.forEach(System.out::println);
		return teacherRoster;
	}

}
