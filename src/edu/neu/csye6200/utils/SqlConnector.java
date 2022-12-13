package edu.neu.csye6200.utils;

import java.sql.*;

/**
 * Initialize connection with MYSQL
 * Return single instance
 * 
 * @author Kaushik Gnansekar
 *
 */
public class SqlConnector {

	private Connection initConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/daycare?" +
					"user=mysql&password=password");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return connection;
	}

	
	/**
	 * Get Instance
	 * @return connection instance
	 */
	private static Connection getInstance() {
		SqlConnector obj = new SqlConnector();
		return obj.initConnection();
	}

	/**
	 * Executes SQL query
	 * @param query
	 * @return data from DB
	 */
	public static ResultSet executeQuery(String query) {
		Connection dbInstance = SqlConnector.getInstance();
		ResultSet resultSet = null;
		try {
			Statement statement = dbInstance.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Executes SQL update
	 * @param query
	 */
	public static void executeUpdate(String query) {
		Connection dbInstance = SqlConnector.getInstance();
		try {
			Statement statement = dbInstance.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
