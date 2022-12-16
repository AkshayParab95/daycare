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
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.FileUtil;
import edu.neu.csye6200.utils.SqlConnector;

/**
 * Immunization Data Controller
 * @author kaushikgnanasekar
 *
 */
public class ImmunizationDataController implements DatabaseManager<Immunization> {

	@Override
	public void loadFromCSV(String filename) {
		String file = filename != null ? filename : "immunization.txt";
		List<String> fileList = new ArrayList<String>();
		fileList = FileUtil.readFile(file);
		for (String i : fileList) {
			String[] stringArray = i.split(",");
			
		// Write to DB
		SqlConnector.executeUpdate("INSERT INTO immunizations(student_id, immunization_date, immunization_name, duration, rule_id) VALUES (" +
				stringArray[0] + "," + "'" + stringArray[1] + "'" + "," + "'"
				+ stringArray[2] + "'" + "," + stringArray[3] + "," + stringArray[4] + ");");
		}
	}

	@Override
	public Immunization fetchDataFromDB(String id) {
		Immunization immunization = null;
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM students WHERE id=" + id + ";");
		try {
			while (result.next()) {
				LocalDate immunizationDate = LocalDate.parse(result.getString("immunization_date"));
				immunization = new Immunization(result.getInt("student_id"),
						result.getInt("id"),
						result.getString("immunization_name"),
						result.getInt("duration"),
						immunizationDate,
						result.getInt("rule_id")
				);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return immunization;
	}

	@Override
	public List<Immunization> fetchAllFromDB() {
		List<Immunization> immunizationRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM immunizations;");
		try {
			while (result.next()) {
				LocalDate immunizationDate = LocalDate.parse(result.getString("immunization_date"));
				immunizationRoster.add(new Immunization(result.getInt("student_id"),
						result.getInt("id"),
						result.getString("immunization_name"),
						result.getInt("duration"),
						immunizationDate,
						result.getInt("rule_id")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		immunizationRoster.forEach(System.out::println);
		return immunizationRoster;
	}
	
	/**
	 * Custom query
	 * @param query
	 * @return
	 */
	public List<Immunization> fetchCustomQuery(String query) {
		List<Immunization> immunizationRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery(query);
		try {
			while (result.next()) {
				LocalDate immunizationDate = LocalDate.parse(result.getString("immunization_date"));
				immunizationRoster.add(new Immunization(result.getInt("student_id"),
						result.getInt("id"),
						result.getString("immunization_name"),
						result.getInt("duration"),
						immunizationDate,
						result.getInt("rule_id")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		immunizationRoster.forEach(System.out::println);
		return immunizationRoster;
	}
	
	/**
	 * Get all immunization alerts
	 * @return
	 */
	public List<Object[]> getAllImmunizationAlerts() {
		StudentDataController studentController = new StudentDataController();
		List<Student> studentInRangeRoster;
		ImmunizationRulesDataController immunizationRules = new ImmunizationRulesDataController();
		List<Student> unVaccinatedStudents = new Vector<>();
		List<Student> vaccinatedStudents = new Vector<>();
		List<Object[]> finalList = new Vector<>();
		List<ImmunizationRules> immunizationRulesRoster = immunizationRules.fetchAllFromDB();
		
		for (int i=0; i < immunizationRulesRoster.size(); i++) {
			ImmunizationRules rulesObject = immunizationRules.fetchDataFromDB(String.valueOf(immunizationRulesRoster.get(i).getImmunizationRuleId()));
			// Find students between the age range of the immunization rule
			studentInRangeRoster = studentController.fetchWithCustomQuery("SELECT * FROM students WHERE age > " 
					+ rulesObject.getMinAge() + " AND age < " + rulesObject.getMaxAge()  + ";");
			studentInRangeRoster.forEach(System.out::println);
			String studentIds = "";
			for (Student x:  studentInRangeRoster) {
				studentIds = studentIds + String.valueOf(x.getId()) + ",";
				
			}
			studentIds = studentIds.substring(0, studentIds.length() - 1);
			List<Immunization> vaccinatedList = fetchCustomQuery("SELECT * FROM immunizations WHERE student_id IN (" + studentIds + ");");
			vaccinatedList.forEach(System.out::println);
			if (vaccinatedList.size() == 0) {
				studentInRangeRoster.forEach(System.out::println);
				return finalList;
			}
			
			// Vaccinated student list
			for (Immunization item: vaccinatedList) {
				for (Student st: studentInRangeRoster) {
					if (st.getId() == item.getId()) {
						vaccinatedStudents.add(st);
						finalList.add(new Object[] {String.valueOf(st.getId()), st.getFirstName().toString(), item.getImmunizationName().toString(), item.getImmunizationDate().toString(), "Completed"});
						System.out.println(String.valueOf(st.getId()) + st.getFirstName().toString() + item.getImmunizationName().toString() + item.getImmunizationDate().toString() + "Completed");
					}
				}
			}
			
			// Unvaccinated students
			for (Immunization item: vaccinatedList) {
				studentInRangeRoster.removeIf(s -> s.getId() == item.getId());
			}
			
			for (Immunization item: vaccinatedList) {
				for (Student st: studentInRangeRoster) {
					finalList.add(new Object[] {String.valueOf(st.getId()), st.getFirstName().toString(), item.getImmunizationName().toString(), item.getImmunizationDate().toString(), "Pending"});
					System.out.println(String.valueOf(st.getId()) + st.getFirstName().toString() + item.getImmunizationName().toString() + item.getImmunizationDate().toString() + "Pending");
				}
			}
			
			unVaccinatedStudents.addAll(studentInRangeRoster);
		}
		finalList.forEach(System.out::print);
		return finalList;
	}
}
