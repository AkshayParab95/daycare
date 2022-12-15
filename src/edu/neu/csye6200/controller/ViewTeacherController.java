package edu.neu.csye6200.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.view.HomePage;

public class ViewTeacherController {

	private HomePage homePage;
	
	public ViewTeacherController(HomePage homePage) {
		this.homePage = homePage;
	}

	public void initController() {
		DefaultTableModel teacherModel = homePage.getTeacherDisplayModel();
		TeacherDataController td = new TeacherDataController();
		List<Teacher> teacherList = td.fetchAllFromDB();
		for(Teacher t: teacherList) {
			teacherModel.addRow(new Object[]{ t.getTeacherId(), t.getFirstName(), t.getLastName() });
		}
				
	}
}
