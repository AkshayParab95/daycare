package edu.neu.csye6200.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.RandomNumberUtil;
import edu.neu.csye6200.utils.SqlConnector;


/**
 * @author Shivam Thabe
 * Student Class inherited from Person Class
 */
public class Student extends Person {

	private int studentId;
	private int age;
	private String fatherName;
	private String motherName;


	public Student() {}
	//This constructor should only be used for initialization
	/**
	 * @param studentId
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param registerTime
	 * @param fatherName
	 * @param motherName
	 */
	public Student(int studentId, String firstName, String lastName, int age, LocalDate registerTime, String fatherName, String motherName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.registerTime = registerTime;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	//This is the basic constructor when creating a Student Object
	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return motherName
	 */
	public String getMotherName() {
		return motherName;
	}
	/**
	 * @param motherName
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		System.out.println(registerTime.toString());
		return studentId + "," + age + "," + fatherName + "," + motherName + "," + firstName + "," + lastName+ "\n";
	}
	
	/**
	 * Load students from CSV and write to DB
	 * @author Kaushik Gnanasekar
	 * @param filename
	 */
	public void loadFromCSV(String filename) {
		String file = filename != null ? filename : "students.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			int studentId = RandomNumberUtil.generate(10000, 99999);
			setStudentId(studentId);
			setFirstName(stringArray[0]);
			setLastName(stringArray[1]);
			setAge(Integer.parseInt(stringArray[2]));
			
			LocalDate registerDate = LocalDate.parse(stringArray[3]);
			setRegisterTime(registerDate);
			setFatherName(stringArray[4]);
			setMotherName(stringArray[5]);
			// Write to DB
			SqlConnector.executeUpdate("INSERT INTO students VALUES (" + 
					getStudentId() + "," + "'" + getFirstName() + "'" + "," + "'" + getLastName() +  "'" + "," + getAge() + "," + 
					"'" + getRegisterTime() + "'" + "," + "'" + getFatherName() + "'" + "," + "'" + getMotherName() + "'" + ");");
		}
	}
}
