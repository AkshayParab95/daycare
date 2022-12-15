package edu.neu.csye6200.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

/**
 * @author Shivam Thabe
 */
public class HomePageForm extends JPanel {
	private JTextField teacherFirstNameTxtField;
	private JTextField teacherIDTxtField;
	private JTextField teacherLastNameTxtField;
	private JTextField teacherReviewTxtField;
	private JTextField studentFirstNameTxtField;
	private JTextField studentLastNameTxtField;
	private JTextField fatherNameTxtField;
	private JTextField motherNameTxtField;
	private JTextField studentAgeTxtField;
	private JButton btnAddTeacher;
	private JButton btnAddStudent;

	
	
	/**
	 * Create the frame.
	 */
	public HomePageForm() {
		setBounds(0,0,572, 438);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register Teacher");
		lblNewLabel_1.setBounds(138, 255, 108, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Teacher Review");
		lblNewLabel_1_1.setBounds(374, 255, 108, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("First Name");
		lblNewLabel_2_1_2.setBounds(58, 295, 86, 16);
		add(lblNewLabel_2_1_2);
		
		teacherFirstNameTxtField = new JTextField();
		teacherFirstNameTxtField.setToolTipText("First Name");
		teacherFirstNameTxtField.setColumns(10);
		teacherFirstNameTxtField.setBounds(138, 290, 130, 26);
		add(teacherFirstNameTxtField);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("ID");
		lblNewLabel_2_1_2_1.setBounds(294, 295, 86, 16);
		add(lblNewLabel_2_1_2_1);
		
		teacherIDTxtField = new JTextField();
		teacherIDTxtField.setToolTipText("First Name");
		teacherIDTxtField.setColumns(10);
		teacherIDTxtField.setBounds(374, 290, 130, 26);
		add(teacherIDTxtField);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Last Name");
		lblNewLabel_2_1_1_2.setBounds(58, 323, 73, 16);
		add(lblNewLabel_2_1_1_2);
		
		teacherLastNameTxtField = new JTextField();
		teacherLastNameTxtField.setToolTipText("Last Name");
		teacherLastNameTxtField.setColumns(10);
		teacherLastNameTxtField.setBounds(138, 318, 130, 26);
		add(teacherLastNameTxtField);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Review");
		lblNewLabel_2_1_1_2_1.setBounds(294, 323, 73, 16);
		add(lblNewLabel_2_1_1_2_1);
		
		teacherReviewTxtField = new JTextField();
		teacherReviewTxtField.setToolTipText("Last Name");
		teacherReviewTxtField.setColumns(10);
		teacherReviewTxtField.setBounds(374, 318, 130, 26);
		add(teacherReviewTxtField);
		
		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(138, 351, 117, 29);
		add(btnAddTeacher);
		
		JButton btnRateTeacher = new JButton("Rate Teacher");
		btnRateTeacher.setBounds(374, 351, 117, 29);
		add(btnRateTeacher);
		
		JLabel lblNewLabel = new JLabel("Register Student");
		lblNewLabel.setBounds(221, 33, 108, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setBounds(58, 69, 86, 16);
		add(lblNewLabel_2_1);
		
		studentFirstNameTxtField = new JTextField();
		studentFirstNameTxtField.setToolTipText("First Name");
		studentFirstNameTxtField.setColumns(10);
		studentFirstNameTxtField.setBounds(138, 64, 130, 26);
		add(studentFirstNameTxtField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setBounds(280, 69, 73, 16);
		add(lblNewLabel_2_1_1);
		
		studentLastNameTxtField = new JTextField();
		studentLastNameTxtField.setToolTipText("Last Name");
		studentLastNameTxtField.setColumns(10);
		studentLastNameTxtField.setBounds(374, 64, 130, 26);
		add(studentLastNameTxtField);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Father Name");
		lblNewLabel_2_1_1_1_1.setBounds(58, 102, 86, 16);
		add(lblNewLabel_2_1_1_1_1);
		
		fatherNameTxtField = new JTextField();
		fatherNameTxtField.setToolTipText("Father Name");
		fatherNameTxtField.setColumns(10);
		fatherNameTxtField.setBounds(138, 97, 130, 26);
		add(fatherNameTxtField);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Mother Name");
		lblNewLabel_2_1_1_1_1_1.setBounds(279, 102, 86, 16);
		add(lblNewLabel_2_1_1_1_1_1);
		
		motherNameTxtField = new JTextField();
		motherNameTxtField.setToolTipText("Mother Name");
		motherNameTxtField.setColumns(10);
		motherNameTxtField.setBounds(374, 97, 130, 26);
		add(motherNameTxtField);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Age");
		lblNewLabel_2_1_1_1.setBounds(58, 135, 73, 16);
		add(lblNewLabel_2_1_1_1);
		
		studentAgeTxtField = new JTextField();
		studentAgeTxtField.setToolTipText("Age");
		studentAgeTxtField.setColumns(10);
		studentAgeTxtField.setBounds(138, 130, 130, 26);
		add(studentAgeTxtField);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(212, 168, 117, 29);
		add(btnAddStudent);
		setVisible(true);
		
	}
	
	public JButton getBtnAddStudent() {
		return this.btnAddStudent;
	}
	
	public JTextField getStudentFirstNameTxtField() {
		return studentFirstNameTxtField;
	}
	
	public JTextField getStudentLastNameTxtField() {
		return studentLastNameTxtField;
	}
	
	public JTextField getFatherNameTxtField() {
		return fatherNameTxtField;
	}
	
	public JTextField getMotherNameTxtField() {
		return motherNameTxtField;
	}
	
	public JTextField getStudentAgeTxtField() {
		return studentAgeTxtField;
	}
	
	public JButton getBtnAddTeacher() {
		return this.btnAddTeacher;
	}
	
	public JTextField getTeacherFirstNameTxtField() {
		return teacherFirstNameTxtField;
	}
	
	public JTextField getTeacherLastNameTxtField() {
		return teacherLastNameTxtField;
	}
	public void showPopupMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
