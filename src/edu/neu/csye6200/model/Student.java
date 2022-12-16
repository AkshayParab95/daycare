package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author Shivam Thabe
 * Student Class inherited from Person Class
 */
public class Student extends Person {

	private int age;
	private String fatherName;
	private String motherName;
	private int classRoomId;

	public Student() {
		super();
	}
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
	public Student(int id, String firstName, String lastName, int age, LocalDate registerTime, String fatherName, String motherName, int classRoomId) {
		super(id, firstName, lastName, registerTime);
		this.age = age;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.classRoomId = classRoomId;
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
	 * @param classroomId
	 */
	public int getClassRoomId() {
		return classRoomId;
	}
	public void setClassRoomId(int classRoomId) {
		this.classRoomId = classRoomId;
	}
}
