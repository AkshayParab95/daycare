package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author Shivam Thabe
 * Abstract Person class
 */
public abstract class Person {

	public String firstName;
	public String lastName;
	public LocalDate registerTime;
	
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
	public LocalDate getRegisterTime() {
		return registerTime;
	}
	/**
	 * @param registerTime
	 */
	public void setRegisterTime(LocalDate registerTime) {
		this.registerTime = registerTime;
	}
	
}
