package edu.neu.csye6200.utils;

import java.sql.Connection;

/**
 * Defining functions to execute sql queries using DBConnection Class 
 * @author Akshay Parab
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {
	
	/**
	 * Executes SQL Query
	 * @param query
	 */
	public static ResultSet executeQuery(String query) {
		ResultSet resultSet = null;
		try {
			Connection dbInstance = DBConnection.getInstance().getConnection();
			Statement statement = dbInstance.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Executes SQL Insert
	 * @param query
	 * returns id of inserted row
	 */
	public static long executeInsert(String query) {
		long id = 0;
		try {
			Connection dbInstance = DBConnection.getInstance().getConnection();
			Statement statement = dbInstance.createStatement();
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
			else {
				throw new SQLException("Insert query failed, no id obtained");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * Executes SQL Update
	 * @param query
	 */
	public static void executeUpdate(String query) {
		try {
			Connection dbInstance = DBConnection.getInstance().getConnection();
			Statement statement = dbInstance.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
