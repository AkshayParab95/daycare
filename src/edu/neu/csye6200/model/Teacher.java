package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author Akshay Parab
 * Teacher Class inherited from Person Class
 */
public class Teacher extends Person {

	private int classRoomId;
	private String review;
	
	public Teacher() {
		super();
	}
	/**
	 * @param teacherId
	 * @param firstName
	 * @param lastName
	 * @param registerTime
	 * @param review
	 */
	public Teacher(int id, String firstName, String lastName, LocalDate registerTime, int classRoomId, String review) {
		super(id, firstName, lastName, registerTime);
		this.classRoomId = classRoomId;
		this.review = review;
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
		return id + "," + firstName + "," + lastName + "\n";
	}
	
	public String getReview() {
		return this.review;
	}
}
