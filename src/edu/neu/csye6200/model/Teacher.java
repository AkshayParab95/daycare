package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author Shivam Thabe
 * Teacher Class inherited from Person Class
 */
public class Teacher extends Person implements Comparable<Teacher> {

	private int teacherId;
	private int classRoomId;

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
	public Teacher(int teacherId, String firstName, String lastName, LocalDate registerTime, int classRoomId) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
		this.classRoomId = classRoomId;
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
	 * @param classRoomId
	 */
	public int getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(int classRoomId) {
		this.classRoomId = classRoomId;
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
}
