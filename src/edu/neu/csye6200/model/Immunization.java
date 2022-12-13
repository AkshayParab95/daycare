package edu.neu.csye6200.model;

import java.util.Date;


/**
 * Immunization Object Class.
 * @author Shivam Thabe
 *
 */
public class Immunization {

	private int studentId;
	private int immuId;
	private String immuName;
	private int duration;
	private Date immuDate;
	public Immunization() {}
	/**
	 * @param immuId
	 * @param immuName
	 * @param duration
	 */
	public Immunization(int immuId, String immuName, int duration) {
		super();
		this.immuId = immuId;
		this.immuName = immuName;
		this.duration = duration;
	}
	//This constructor is only used for initializing
	/**
	 * @param studentId
	 * @param immuId
	 * @param immuName
	 * @param duration
	 * @param immuDate
	 */
	public Immunization(int studentId, int immuId, String immuName, int duration, Date immuDate) {
		super();
		this.immuId = immuId;
		this.studentId = studentId;
		this.immuName = immuName;
		this.duration = duration;
		this.immuDate = immuDate;
	}
	/**
	 * @return immuId
	 */
	public int getImmuId() {
		return immuId;
	}
	/**
	 * @param immuId
	 */
	public void setImmuId(int immuId) {
		this.immuId = immuId;
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
	 * @return immuDate
	 */
	public Date getImmuDate() {
		return immuDate;
	}
	/**
	 * @param immuDate
	 */
	public void setImmuDate(Date immuDate) {
		this.immuDate = immuDate;
	}
	/**
	 * @return immuName
	 */
	public String getImmuName() {
		return immuName;
	}
	/**
	 * @param immuName
	 */
	public void setImmuName(String immuName) {
		this.immuName = immuName;
	}
	/**
	 * @return duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return studentId + "," + immuId + "," + immuName + "," + duration + "\n";
	}
	
}



