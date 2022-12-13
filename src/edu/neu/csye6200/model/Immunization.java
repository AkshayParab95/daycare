package edu.neu.csye6200.model;

import java.util.Date;


/**
 * Immunization Object Class.
 * @author Shivam Thabe
 *
 */
public class Immunization {

	private int studentId;
	private int immunizationId;
	private String immunizationName;
	private int duration;
	private Date immunizationDate;
	public Immunization() {}
	/**
	 * @param immunizationId
	 * @param immunizationName
	 * @param duration
	 */
	public Immunization(int immunizationId, String immunizationName, int duration) {
		super();
		this.immunizationId = immunizationId;
		this.immunizationName = immunizationName;
		this.duration = duration;
	}
	//This constructor is only used for initializing
	/**
	 * @param studentId
	 * @param immunizationId
	 * @param immunizationName
	 * @param duration
	 * @param immunizationDate
	 */
	public Immunization(int studentId, int immunizationId, String immunizationName, int duration, Date immunizationDate) {
		super();
		this.immunizationId = immunizationId;
		this.studentId = studentId;
		this.immunizationName = immunizationName;
		this.duration = duration;
		this.immunizationDate = immunizationDate;
	}
	/**
	 * @return immunizationId
	 */
	public int getImmunizationId() {
		return immunizationId;
	}
	/**
	 * @param immunizationId
	 */
	public void setImmunizationId(int immunizationId) {
		this.immunizationId = immunizationId;
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
	 * @return immunizationDate
	 */
	public Date getImmunizationDate() {
		return immunizationDate;
	}
	/**
	 * @param immunizationDate
	 */
	public void setImmunizationDate(Date immunizationDate) {
		this.immunizationDate = immunizationDate;
	}
	/**
	 * @return immunizationName
	 */
	public String getImmunizationName() {
		return immunizationName;
	}
	/**
	 * @param immunizationName
	 */
	public void setImmunizationName(String immunizationName) {
		this.immunizationName = immunizationName;
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
		return studentId + "," + immunizationId + "," + immunizationName + "," + duration + "\n";
	}
	
}



