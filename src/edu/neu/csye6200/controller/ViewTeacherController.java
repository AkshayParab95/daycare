package edu.neu.csye6200.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.view.HomePage;
import edu.neu.csye6200.view.TeacherPage;

public class ViewTeacherController {

	private TeacherPage teacherPage;
	
	public ViewTeacherController(TeacherPage teacherPage) {
		this.teacherPage = teacherPage;
	}

	public void initController() {
		DefaultTableModel teacherModel = teacherPage.getTeacherDisplayModel();
		teacherModel.setRowCount(0);
		TeacherDataController td = new TeacherDataController();
		List<Teacher> teacherList = td.fetchAllFromDB();
		for(Teacher t: teacherList) {
			teacherModel.addRow(new Object[]{ t.getTeacherId(), t.getFirstName(), t.getLastName(), t.getReview() });
		}
				
	}
}
