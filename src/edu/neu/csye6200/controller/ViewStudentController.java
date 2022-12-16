package edu.neu.csye6200.controller;

import java.util.ArrayList;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.view.HomePage;
import edu.neu.csye6200.view.StudentPage;
/**
 * @author Shivam Thabe
 */
public class ViewStudentController {
	
	private StudentPage studentPage;
	
	public ViewStudentController(StudentPage studentPage) {
		this.studentPage = studentPage;
	}

	public void initController() {
		DefaultTableModel studentModel = studentPage.getStudentDisplayModel();
		studentModel.setRowCount(0);
		StudentDataController sd = new StudentDataController();
		List<Student> studentList = sd.fetchAllFromDB();
		for(Student s: studentList) {
			studentModel.addRow(new Object[]{ s.getStudentId(), s.getFirstName(), s.getLastName(), s.getAge(), s.getMotherName(), s.getFatherName() });
		}
				
	}

	
}
