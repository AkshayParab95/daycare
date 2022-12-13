package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;
import edu.neu.csye6200.utils.*;

public class RatioRules {

	private Integer maxGroupsPerClassroom;
    private Integer maxStudentsPerTeacher;
    private Integer minAge;
    private Integer maxAge;
    
	public Integer getMaxGroupsPerClassroom() {
		return maxGroupsPerClassroom;
	}
	public void setMaxGroupsPerClassroom(Integer maxGroupsPerClassroom) {
		this.maxGroupsPerClassroom = maxGroupsPerClassroom;
	}
	public Integer getMaxStudentsPerTeacher() {
		return maxStudentsPerTeacher;
	}
	public void setMaxStudentsPerTeacher(Integer maxStudentsPerTeacher) {
		this.maxStudentsPerTeacher = maxStudentsPerTeacher;
	}
	public Integer getMinAge() {
		return minAge;
	}
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}
	public Integer getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
    
	/**
	 * Load from CSV and write to DB
	 * @param filename
	 */
	public void loadFromCSV(String filename) {
		String file = filename != null ? filename : "ratiorules.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			setMinAge(Integer.parseInt(stringArray[0]));
			setMaxAge(Integer.parseInt(stringArray[1]));
			setMaxStudentsPerTeacher(Integer.parseInt(stringArray[2]));
			setMaxGroupsPerClassroom(Integer.parseInt(stringArray[3]));
			SqlConnector.executeUpdate("INSERT INTO ratiorules VALUES (" + getMaxAge() + "," + getMinAge() + "," + getMaxGroupsPerClassroom() + "," + getMaxStudentsPerTeacher() + ");");
			
		}
		
	}
    
}
