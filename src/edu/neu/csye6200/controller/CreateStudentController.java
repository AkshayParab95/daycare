package edu.neu.csye6200.controller;

import edu.neu.csye6200.view.HomePage;
import edu.neu.csye6200.view.HomePageForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class CreateStudentController {
	private HomePageForm homePageForm;
	
	public CreateStudentController(HomePageForm homePageForm) {
		this.homePageForm = homePageForm;
	}

	public void initController() {
		homePageForm.getBtnAddStudent().addActionListener(e->addStudent());
	}
	
	public void addStudent() {
		
		System.out.println(homePageForm.getStudentFirstNameTxtField().getText() +" "+ homePageForm.getStudentLastNameTxtField().getText());
		String firstName = homePageForm.getStudentFirstNameTxtField().getText();
		String lastName = homePageForm.getStudentLastNameTxtField().getText();
		String motherName = homePageForm.getMotherNameTxtField().getText();
		String fatherName = homePageForm.getFatherNameTxtField().getText();
		String studentAge = homePageForm.getStudentAgeTxtField().getText();
		
    	if(!(typeIsRight(firstName) && typeIsRight(lastName) && typeIsRight(motherName) && typeIsRight(fatherName) ) ) {
    		
    		homePageForm.showPopupMessage("Please enter valid entries for Student");

    	}else {
    		
    		StudentDataController.createStudentFromUI(firstName, lastName, motherName, fatherName, studentAge);
    	}
	
	}
	
	
    public boolean typeIsRight(String s) {
    	Pattern p = Pattern.compile("[A-Za-z]{1,}");
        Matcher m = p.matcher(s);
    	return m.matches();
    }
	
}
