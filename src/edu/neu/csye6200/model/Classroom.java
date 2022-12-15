package edu.neu.csye6200.model;

import java.sql.*;
import java.util.*;
import edu.neu.csye6200.utils.SqlConnector;
import edu.neu.csye6200.utils.RandomNumberUtil;

public class Classroom {
	private int id;
	private int currentCapacity;
	private int totalCapacity;
	private int teacherId;
	private int maxAge;
	
	public Classroom(int id, int currentCapacity, int totalCapacity, int teacherId, int maxAge) {
		this.id = id;
		this.currentCapacity = currentCapacity;
		this.totalCapacity = totalCapacity;
		this.teacherId = teacherId;
		this.maxAge = maxAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public void assign(int studentId, int studentAge) throws Exception {
		ResultSet ratioRuleResult = SqlConnector.executeQuery("SELECT * FROM ratiorules WHERE max_age >= "+studentAge+" AND min_age <= "+studentAge+";");
		RatioRules ratioRule = new RatioRules();
		try {
			ratioRule.setMaxGroupsPerClassroom(ratioRuleResult.getInt("max_groups_classroom"));
			ratioRule.setMaxStudentsPerTeacher(ratioRuleResult.getInt("max_students_teacher"));
			ratioRule.setMaxAge(ratioRuleResult.getInt("max_age"));
			ratioRule.setMinAge(ratioRuleResult.getInt("min_age"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet classRoomResult = SqlConnector.executeQuery("SELECT * FROM classrooms WHERE max_age = "+ratioRule.getMaxAge()+";");
		List<Classroom> classRooms = new Vector<>();
		try {
			while (classRoomResult.next()) {
				classRooms.add(new Classroom(classRoomResult.getInt("id"), 
						classRoomResult.getInt("current_capacity"),
						classRoomResult.getInt("total_capacity"),
						classRoomResult.getInt("teacher_id"),
						classRoomResult.getInt("max_age")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int studentAssigned = 0;
		for(Classroom c: classRooms) {
				if(studentAssigned == 0 && (c.getCurrentCapacity() < c.getTotalCapacity())) {
					SqlConnector.executeUpdate("UPDATE students SET classRoom_id = "+c.getId()+" WHERE id = "+studentId+";");
					SqlConnector.executeUpdate("UPDATE classrooms SET current_capacity = "+(c.getCurrentCapacity()+1)+"WHERE id="+c.getId()+";");
					studentAssigned = 1;
				}
		}
		if(studentAssigned == 0) {
			if(ratioRule.getMaxGroupsPerClassroom() > classRooms.size()) {
				int classRoomId = RandomNumberUtil.generate(0, 999999999);
				ResultSet teacherResult = SqlConnector.executeQuery("SELECT * FROM teachers WHERE classAssigned = 0 LIMIT 1;");
				try {
					SqlConnector.executeUpdate("INSERT INTO classrooms (id, current_capacity, total_capacity, teacher_id, max_age) VALUES ("+classRoomId+","+1+","+ratioRule.getMaxStudentsPerTeacher()+","+teacherResult.getInt("id")+","+ratioRule.getMaxAge()+");");
					SqlConnector.executeUpdate("UPDATE teachers SET class_assigned = 1 WHERE id = "+teacherResult.getInt("id")+";");
					SqlConnector.executeUpdate("UPDATE students SET classroom_id = "+classRoomId+" WHERE id = "+studentId+";");
				} catch (SQLException e) {	
					e.printStackTrace();
				}
			}
			else {
				throw new Exception("Failure detected during student assignment!");
			}
		}
	}
	
}
