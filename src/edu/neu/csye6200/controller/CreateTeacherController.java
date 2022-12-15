package edu.neu.csye6200.controller;
import edu.neu.csye6200.view.HomePage;
import edu.neu.csye6200.view.HomePageForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class CreateTeacherController {
	private HomePageForm homePageForm;
	
	public CreateTeacherController(HomePageForm homePageForm) {
		this.homePageForm = homePageForm;
	}
	
	public void initController() {
		homePageForm.getBtnAddTeacher().addActionListener(e->addTeacher());
	}
	
	public void addTeacher() {
		
		System.out.println(homePageForm.getTeacherFirstNameTxtField().getText() +" "+ homePageForm.getTeacherLastNameTxtField().getText());
		String firstName = homePageForm.getTeacherFirstNameTxtField().getText();
		String lastName = homePageForm.getTeacherLastNameTxtField().getText();
		
    	if(!(typeIsRight(firstName) && typeIsRight(lastName) ) ) {
    		
    		homePageForm.showPopupMessage("Please enter valid name for the teacher");

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
