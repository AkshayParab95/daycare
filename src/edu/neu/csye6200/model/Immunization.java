package edu.neu.csye6200.model;

import java.time.LocalDate;
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
	private LocalDate immunizationDate;
	private int immunizationRuleId;
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
	public Immunization(int studentId, int immunizationId, String immunizationName, int duration, LocalDate immunizationDate, int immunizationRuleId) {
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
	public int getId() {
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
	public LocalDate getImmunizationDate() {
		return immunizationDate;
	}
	/**
	 * @param immunizationDate
	 */
	public void setImmunizationDate(LocalDate immunizationDate) {
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
	public int getImmunizationRuleId() {
		return immunizationRuleId;
	}
	public void setImmunizationRuleId(int immunizationRuleId) {
		this.immunizationRuleId = immunizationRuleId;
	}
	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return "Immunization [getImmunizationId()=" + getImmunizationId() + ", getId()=" + getId()
				+ ", getImmunizationDate()=" + getImmunizationDate() + ", getImmunizationName()="
				+ getImmunizationName() + ", getDuration()=" + getDuration() + ", getImmunizationRuleId()="
				+ getImmunizationRuleId() + "]";
	}
	
	
}



