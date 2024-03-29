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
			teacherObj.setFirstName(stringArray[0]);
			teacherObj.setLastName(stringArray[1]);

			LocalDate registerDate = LocalDate.parse(stringArray[2]);
			teacherObj.setRegisterTime(registerDate);
			// Write to DB
			SqlConnector.executeUpdate("INSERT INTO teachers (first_name, last_name, classroom_id, register_time) VALUES (" + "'" + teacherObj.getFirstName() + "'" + "," + "'" + teacherObj.getLastName() +  "'" +  ", NULL," + 
					"'" + teacherObj.getRegisterTime() + "'" + ");");
		}
		
	}

	@Override
	public Teacher fetchDataFromDB(String id) {
		Teacher teacher = null;
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM teachers WHERE id=" + id + ";");
		try {
			while (result.next()) {
				LocalDate registerDate = LocalDate.parse(result.getString("register_time"));
				teacher = new Teacher(result.getInt("id"), 
						result.getString("first_name"),
						result.getString("last_name"),
						registerDate,
						result.getInt("classroom_id"),
						result.getString("review")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public List<Teacher> fetchAllFromDB() {
		List<Teacher> teacherRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM teachers;");
		try {
			while (result.next()) {
				LocalDate registerDate = LocalDate.parse(result.getString("register_time"));
				teacherRoster.add(new Teacher(result.getInt("id"), 
						result.getString("first_name"),
						result.getString("last_name"),
						registerDate,
						result.getInt("classroom_id"),
						result.getString("review")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherRoster.forEach(System.out::println);
		return teacherRoster;
	}
	
	public static void createTeacherFromUI(String firstName, String lastName) {
		Teacher teacherObj = new Teacher();

		teacherObj.setFirstName(firstName);
		teacherObj.setLastName(lastName);
		
		   //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDate registerDate = LocalDate.now();  
		   //System.out.println(dtf.format(now));  
		
		
		teacherObj.setRegisterTime(registerDate);
		//System.out.println("INSERT INTO teachers VALUES (" + 
		//		teacherObj.getId() + "," + "'" + teacherObj.getFirstName() + "'" + "," + "'" + teacherObj.getLastName() +  "'" +  "," + 
		//		"'" + teacherObj.getRegisterTime() + "'" + ");");
		// Write to DB
		SqlConnector.executeUpdate("INSERT INTO teachers (first_name, last_name, classroom_id, register_time) VALUES (" + "'" + teacherObj.getFirstName() + "'" + "," + "'" + teacherObj.getLastName() +  "'" +  ", NULL," + 
				"'" + teacherObj.getRegisterTime() + "'" + ");");		
		
	}
	
	public static void addTeacherReview(String id, String review) {
		SqlConnector.executeUpdate( "UPDATE teachers SET review =" + "'" + review + "'" +" WHERE id=" + id + ";");	
	}

}
