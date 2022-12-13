package edu.neu.csye6200.controller;
import edu.neu.csye6200.view.HomePage;
import javax.swing.JOptionPane;

public class CreateTeacherController {
	private HomePage homePage;
	
	public CreateTeacherController(HomePage homePage) {
		this.homePage = homePage;
	}
	
	public void initController() {
		homePage.getBtnAddTeacher().addActionListener(e->addTeacher());
	}
	
	public void addTeacher() {
		System.out.println(homePage.getTeacherFirstNameTxtField().getText() +" "+ homePage.getTeacherLastNameTxtField().getText());
	}
}
