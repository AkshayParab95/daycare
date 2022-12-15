package edu.neu.csye6200.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.neu.csye6200.interfaces.DatabaseManager;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRules;
import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.SqlConnector;

public class ImmunizationRulesDataController implements DatabaseManager<ImmunizationRules> {

	@Override
	public void loadFromCSV(String filename) {
		String file = filename != null ? filename : "immunizationrules.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			
		// Write to DB
		SqlConnector.executeUpdate("INSERT INTO immunizationrules(min_age, max_age, vaccine_name) VALUES (" +
				stringArray[0] + "," + stringArray[1] + "," + "'"
				+ stringArray[2] + "'" + ");");
		}
	}

	@Override
	public ImmunizationRules fetchDataFromDB(String id) {
		ImmunizationRules immunizationRules = null;
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM immunizationrules WHERE id=" + id + ";");
		try {
			while (result.next()) {
				immunizationRules = new ImmunizationRules(result.getInt("id"),
						result.getInt("min_age"),
						result.getInt("max_age"),
						result.getString("vaccine_name")
				);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return immunizationRules;
	}

	@Override
	public List<ImmunizationRules> fetchAllFromDB() {
		List<ImmunizationRules> immunizationRulesRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM immunizationrules;");
		try {
			while (result.next()) {
				immunizationRulesRoster.add(new ImmunizationRules(result.getInt("id"),
						result.getInt("min_age"),
						result.getInt("max_age"),
						result.getString("vaccine_name")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		immunizationRulesRoster.forEach(System.out::println);
		return immunizationRulesRoster;
	}

}
