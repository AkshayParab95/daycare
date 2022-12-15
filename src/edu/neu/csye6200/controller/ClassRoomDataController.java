package edu.neu.csye6200.controller;

import java.util.List;

import edu.neu.csye6200.interfaces.DatabaseManager;
import edu.neu.csye6200.model.Teacher;

/**
 * @author shivamthabe
 *
 */
public class ClassRoomDataController implements DatabaseManager<Teacher> {

	@Override
	public void loadFromCSV(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher fetchDataFromDB(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> fetchAllFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
