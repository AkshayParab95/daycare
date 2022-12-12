package edu.neu.csye6200.model;

import java.util.Date;

/**
 * @author Shivam Thabe
 * Abstract Person class
 */
public abstract class Person {

	public String firstName;
	public String lastName;
	public Date registerTime;
	
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * @param registerTime
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
}
