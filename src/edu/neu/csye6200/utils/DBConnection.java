package edu.neu.csye6200.utils;

import java.sql.*;

/**
 * Initialize connection with MYSQL
 * Using singleton class to return database connection
 * 
 * @author Akshay Parab
 *
 */
public class DBConnection {
	private static DBConnection instance;
	private Connection connection;
	private DBConnection() throws SQLException {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/daycare?" +
					"user=mysql&password=password");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	};
	
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Get Instance
	 * @return database connection instance
	 */
	public static synchronized DBConnection getInstance() throws SQLException {
		if(instance == null)
			instance = new DBConnection();
		else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}
}
