package edu.neu.csye6200.model;

import java.sql.*;
import java.util.*;
import edu.neu.csye6200.utils.SqlConnector;

public class Classroom {
	private int id;
	private int currentCapacity;
	private int totalCapacity;
	private int teacherId;
	private int maxAge;
	
	public Classroom(int id, int teacherId ) {
		this.id = id;
		this.teacherId = teacherId;
	}
	
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

	public static void assign(int studentId, int studentAge) throws Exception {
		ResultSet ratioRuleResult = SqlConnector.executeQuery("SELECT * FROM ratiorules WHERE max_age >= "+studentAge+" AND min_age <= "+studentAge+" LIMIT 1;");
		if (!ratioRuleResult.isBeforeFirst()) {
			throw new SQLException("No ratiorule found for student with id " + studentId + " and age " + studentAge);
		}
		RatioRules ratioRule = new RatioRules();
		try {
			while (ratioRuleResult.next()) {
				ratioRule.setMaxGroups(ratioRuleResult.getInt("max_groups"));
				ratioRule.setGroupSize(ratioRuleResult.getInt("group_size"));
				ratioRule.setMaxAge(ratioRuleResult.getInt("max_age"));
				ratioRule.setMinAge(ratioRuleResult.getInt("min_age"));
			}
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
		long classRoomId = -1;
		if(classRooms.size() != 0 ) {
			for(Classroom c: classRooms) {
				if(studentAssigned == 0 && (c.getCurrentCapacity() < c.getTotalCapacity())) {
					classRoomId = c.getId();
					SqlConnector.executeUpdate("UPDATE students SET classroom_id = "+classRoomId+" WHERE id = "+studentId+";");
					String query = "UPDATE classrooms SET current_capacity = "+(c.getCurrentCapacity()+1)+" WHERE id = "+c.getId()+";";
					SqlConnector.executeUpdate(query);
					studentAssigned = 1;
				}
		}
		}
		if(studentAssigned == 0) {
			if(ratioRule.getMaxGroups() > classRooms.size()) {
				ResultSet teacherResult = SqlConnector.executeQuery("SELECT * FROM teachers WHERE classroom_id IS NULL LIMIT 1;");
				if (!teacherResult.isBeforeFirst()) {
					throw new SQLException("No teacher available at the moment");
				}
				while (teacherResult.next()) {
					Teacher teacher = new Teacher();
					try {
						teacher.setTeacherId(teacherResult.getInt("id"));
						classRoomId = SqlConnector.executeInsert("INSERT INTO classrooms (current_capacity, total_capacity, teacher_id, max_age) VALUES ("+1+","+ratioRule.getGroupSize()+","+teacher.getTeacherId()+","+ratioRule.getMaxAge()+");");
						SqlConnector.executeUpdate("UPDATE teachers SET classroom_id = "+classRoomId+" WHERE id = "+teacher.getTeacherId()+";");
						SqlConnector.executeUpdate("UPDATE students SET classroom_id = "+classRoomId+" WHERE id = "+studentId+";");
						studentAssigned = 1;
					} catch (SQLException e) {	
						e.printStackTrace();
					}
				}
			}
			else {
				throw new Exception("Failure detected during student assignment");
			}
		}
		if (studentAssigned == 1 && classRoomId != -1) {
			System.out.println("Student with id: "+studentId+" has been assigned to classroom: "+classRoomId);
		}
	}
}
