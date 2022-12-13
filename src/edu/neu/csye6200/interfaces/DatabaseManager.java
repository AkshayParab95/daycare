package edu.neu.csye6200.interfaces;

import java.util.List;

/**
 * Database Manager
 * @author Kaushik Gnanasekar
 *
 * @param <T>
 */
public interface DatabaseManager<T> {
	// Load into DB from CSV
	public void loadFromCSV(String filename);
	// Fetch data using primary key
	public List<T> fetchDataFromDB(String id);
	// Fetch all data
	public List<T> fetchAllFromDB();
}


