package edu.neu.csye6200.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.RandomNumberUtil;
import edu.neu.csye6200.utils.SqlConnector;

/**
 * @author Shivam Thabe
 * Teacher Class inherited from Person Class
 */
public class Teacher extends Person implements Comparable<Teacher> {

	private int teacherId;
	public Teacher() {};
	
	/**
	 * @param teacherId
	 * @param firstName
	 * @param lastName
	 */
	public Teacher(int teacherId, String firstName, String lastName) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @param teacherId
	 * @param firstName
	 * @param lastName
	 * @param registerTime
	 */
	public Teacher(int teacherId, String firstName, String lastName, LocalDate registerTime) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
	}
	
	/**
	 * @return teacherId
	 */
	public int getTeacherId() {
		return teacherId;
	}
	
	/**
	 * @param teacherId
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return teacherId + "," + firstName + "," + lastName + "\n";
	}
	
	/**
	 * Compare teacher IDs
	 */
	@Override
	public int compareTo(Teacher teacher) {
		return Integer.valueOf(teacherId).compareTo(teacher.teacherId);
	}
	
	/**
	 * Load teachers from CSV and write to DB
	 * @author Kaushik Gnanasekar
	 * @param filename
	 */
	public void loadFromCSV(String filename) {
		String file = filename != null ? filename : "teachers.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			int teacherId = RandomNumberUtil.generate(10000, 99999);
			setTeacherId(teacherId);
			setFirstName(stringArray[0]);
			setLastName(stringArray[1]);

			LocalDate registerDate = LocalDate.parse(stringArray[2]);
			setRegisterTime(registerDate);
			// Write to DB
			SqlConnector.executeUpdate("INSERT INTO teachers VALUES (" + 
					getTeacherId() + "," + "'" + getFirstName() + "'" + "," + "'" + getLastName() +  "'" +  "," + 
					"'" + getRegisterTime() + "'" + ");");
		}
	}
	
	/**
	 * Get all teachers from DB
	 * @author Kaushik Gnanasekar
	 * @return Vector<Teacher>
	 */
	public List<Teacher> getAllTeachers() {
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
