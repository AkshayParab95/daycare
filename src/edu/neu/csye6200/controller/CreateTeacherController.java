package edu.neu.csye6200.controller;
import edu.neu.csye6200.view.HomePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String firstName = homePage.getTeacherFirstNameTxtField().getText();
		String lastName = homePage.getTeacherLastNameTxtField().getText();
		
    	if(!(typeIsRight(firstName) && typeIsRight(lastName) ) ) {
    		
    		homePage.showPopupMessage("Please enter valid name for the teacher");

    	}else {
    		
    		TeacherDataController.createTeacherFromUI(firstName, lastName);
    	}
	
	}
	
	
    public boolean typeIsRight(String s) {
    	Pattern p = Pattern.compile("[A-Za-z]{1,}");
        Matcher m = p.matcher(s);
    	return m.matches();
    }
}
