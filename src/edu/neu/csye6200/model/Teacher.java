package edu.neu.csye6200.model;
import java.time.LocalDate;

/**
 * @author Shivam Thabe
 * Teacher Class inherited from Person Class
 */
public class Teacher extends Person implements Comparable<Teacher> {

	private int teacherId;
	private boolean isIdle = true;
	private int stateLevel;
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
	 * @param stateLevel
	 */
	public Teacher(int teacherId, String firstName, String lastName, LocalDate registerTime, int stateLevel) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
		this.stateLevel = stateLevel;
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
	 * @return isIdle
	 */
	public boolean isIdle() {
		return isIdle;
	}
	
	/**
	 * @param isIdle
	 */
	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}
	
	/**
	 * @return stateLevel
	 */
	public int getStateLevel() {
		return stateLevel;
	}
	
	/**
	 * @param stateLevel
	 */
	public void setStateLevel(int stateLevel) {
		this.stateLevel = stateLevel;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return teacherId + "," + isIdle + "," + stateLevel + "," + firstName + "," + lastName + "\n";
	}
	
	/**
	 * Compare teacher IDs
	 */
	@Override
	public int compareTo(Teacher teacher) {
		return Integer.valueOf(teacherId).compareTo(teacher.teacherId);
	}

}
