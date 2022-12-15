package edu.neu.csye6200.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.view.HomePage;

public class ViewStudentController {
	
	private HomePage homePage;
	
	public ViewStudentController(HomePage homePage) {
		this.homePage = homePage;
	}

	public void initController() {
		DefaultTableModel studentModel = homePage.getStudentDisplayModel();
		StudentDataController sd = new StudentDataController();
		List<Student> studentList = sd.fetchAllFromDB();
		for(Student s: studentList) {
			studentModel.addRow(new Object[]{ s.getStudentId(), s.getFirstName(), s.getLastName(), s.getAge(), s.getMotherName(), s.getFatherName() });
		}
				
	}

	
}
