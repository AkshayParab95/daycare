package edu.neu.csye6200.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.neu.csye6200.interfaces.DatabaseManager;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.RandomNumberUtil;
import edu.neu.csye6200.utils.SqlConnector;

/**
 * Student Data Controller
 * 
 * @author Kaushik Gnanasekar
 */
public class StudentDataController implements DatabaseManager<Student> {

	@Override
	public void loadFromCSV(String filename) {
		Student studentObj = new Student();
		String file = filename != null ? filename : "students.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			int studentId = RandomNumberUtil.generate(10000, 99999);
			studentObj.setStudentId(studentId);
			studentObj.setFirstName(stringArray[0]);
			studentObj.setLastName(stringArray[1]);
			studentObj.setAge(Integer.parseInt(stringArray[2]));

			LocalDate registerDate = LocalDate.parse(stringArray[3]);
			studentObj.setRegisterTime(registerDate);
			studentObj.setFatherName(stringArray[4]);
			studentObj.setMotherName(stringArray[5]);
			// Write to DB
			SqlConnector.executeUpdate("INSERT INTO students VALUES (" +
					studentObj.getStudentId() + "," + "'" + studentObj.getFirstName() + "'" + "," + "'"
					+ studentObj.getLastName() + "'" + "," + studentObj.getAge() + "," +
					"'" + studentObj.getRegisterTime() + "'" + "," + "'" + studentObj.getFatherName() + "'" + "," + "'"
					+ studentObj.getMotherName() + "'" + ");");
		}
	}

	@Override
	public Student fetchDataFromDB(String id) {
		Student student = null;
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM students WHERE id=" + id + ";");
		try {
			while (result.next()) {
				LocalDate registerDate = LocalDate.parse(result.getString("register_time"));
				student = new Student(result.getInt("id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getInt("age"),
						registerDate,
						result.getString("father_name"),
						result.getString("mother_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> fetchAllFromDB() {
		List<Student> studentRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM students;");
		try {
			while (result.next()) {
				LocalDate registerDate = LocalDate.parse(result.getString("register_time"));
				studentRoster.add(new Student(result.getInt("id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getInt("age"),
						registerDate,
						result.getString("father_name"),
						result.getString("mother_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentRoster.forEach(System.out::println);
		return studentRoster;
	}

}
