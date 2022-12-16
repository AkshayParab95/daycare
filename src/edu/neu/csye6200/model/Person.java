package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author Akshay Parab Abstract Person class
 */
public abstract class Person {

	public int id;
	public String firstName;
	public String lastName;
	public LocalDate registerTime;

	public Person(int id, String firstName, String lastName, LocalDate registerTime) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
