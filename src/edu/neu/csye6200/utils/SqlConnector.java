package edu.neu.csye6200.utils;

import java.sql.*;

/**
 * Initialize connection with mysql
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

	private static Connection getInstance() {
		SqlConnector obj = new SqlConnector();
		return obj.initConnection();
	}

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

}
