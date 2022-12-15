package edu.neu.csye6200.controller;

import edu.neu.csye6200.view.HomePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class CreateStudentController {
	private HomePage homePage;
	
	public CreateStudentController(HomePage homePage) {
		this.homePage = homePage;
	}

	public void initController() {
		homePage.getBtnAddStudent().addActionListener(e->addStudent());
	}
	
	public void addStudent() {
		
		System.out.println(homePage.getStudentFirstNameTxtField().getText() +" "+ homePage.getStudentLastNameTxtField().getText());
		String firstName = homePage.getStudentFirstNameTxtField().getText();
		String lastName = homePage.getStudentLastNameTxtField().getText();
		String motherName = homePage.getMotherNameTxtField().getText();
		String fatherName = homePage.getFatherNameTxtField().getText();
		String studentAge = homePage.getStudentAgeTxtField().getText();
		
    	if(!(typeIsRight(firstName) && typeIsRight(lastName) && typeIsRight(motherName) && typeIsRight(fatherName) ) ) {
    		
    		homePage.showPopupMessage("Please enter valid entries for Student");

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
