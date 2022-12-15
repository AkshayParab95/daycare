package edu.neu.csye6200.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * @author Shivam Thabe
 */
public class HomePage extends JFrame {
	
	private JPanel contentPane;
	private JTextField studentIdTxtField;
	private JTextField studentFirstNameTxtField;
	private JTextField studentLastNameTxtField;
	private JTextField studentAgeTxtField;
	private JTextField fatherNameTxtField;
	private JTextField motherNameTxtField;
	private JTextField teacherFirstNameTxtField;
	private JTextField teacherLastNameTxtField;
	private JTextField teacherStateTxtField;
	private JTextField teacherIdTxtField;
	private JButton btnAddTeacher;
	private JButton btnAddStudent;
	private JTable table;
	private DefaultTableModel studentModel;
	private JTable table_1;
	private DefaultTableModel teacherModel;
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private DefaultTableModel classRoomModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Student");
		lblNewLabel.setBounds(118, 6, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Register Teacher");
		lblNewLabel_1.setBounds(627, 6, 108, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(259, 70, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setBounds(38, 42, 86, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setBounds(260, 42, 73, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Age");
		lblNewLabel_2_1_1_1.setBounds(38, 70, 73, 16);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Father Name");
		lblNewLabel_2_1_1_1_1.setBounds(38, 98, 86, 16);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Mother Name");
		lblNewLabel_2_1_1_1_1_1.setBounds(259, 98, 86, 16);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		studentIdTxtField = new JTextField();
		studentIdTxtField.setToolTipText("Student ID");
		studentIdTxtField.setBounds(354, 65, 130, 26);
		contentPane.add(studentIdTxtField);
		studentIdTxtField.setColumns(10);
		
		studentFirstNameTxtField = new JTextField();
		studentFirstNameTxtField.setToolTipText("First Name");
		studentFirstNameTxtField.setColumns(10);
		studentFirstNameTxtField.setBounds(118, 37, 130, 26);
		contentPane.add(studentFirstNameTxtField);
		
		studentLastNameTxtField = new JTextField();
		studentLastNameTxtField.setToolTipText("Last Name");
		studentLastNameTxtField.setColumns(10);
		studentLastNameTxtField.setBounds(354, 37, 130, 26);
		contentPane.add(studentLastNameTxtField);
		
		studentAgeTxtField = new JTextField();
		studentAgeTxtField.setToolTipText("Age");
		studentAgeTxtField.setColumns(10);
		studentAgeTxtField.setBounds(118, 65, 130, 26);
		contentPane.add(studentAgeTxtField);
		
		fatherNameTxtField = new JTextField();
		fatherNameTxtField.setToolTipText("Father Name");
		fatherNameTxtField.setColumns(10);
		fatherNameTxtField.setBounds(118, 93, 130, 26);
		contentPane.add(fatherNameTxtField);
		
		motherNameTxtField = new JTextField();
		motherNameTxtField.setToolTipText("Mother Name");
		motherNameTxtField.setColumns(10);
		motherNameTxtField.setBounds(354, 93, 130, 26);
		contentPane.add(motherNameTxtField);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(191, 131, 117, 29);
		contentPane.add(btnAddStudent);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("First Name");
		lblNewLabel_2_1_2.setBounds(511, 47, 86, 16);
		contentPane.add(lblNewLabel_2_1_2);
		
		teacherFirstNameTxtField = new JTextField();
		teacherFirstNameTxtField.setToolTipText("First Name");
		teacherFirstNameTxtField.setColumns(10);
		teacherFirstNameTxtField.setBounds(580, 42, 130, 26);
		contentPane.add(teacherFirstNameTxtField);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Last Name");
		lblNewLabel_2_1_1_2.setBounds(722, 47, 73, 16);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		teacherLastNameTxtField = new JTextField();
		teacherLastNameTxtField.setToolTipText("Last Name");
		teacherLastNameTxtField.setColumns(10);
		teacherLastNameTxtField.setBounds(790, 42, 130, 26);
		contentPane.add(teacherLastNameTxtField);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("State");
		lblNewLabel_2_1_1_1_2.setBounds(511, 80, 73, 16);
		contentPane.add(lblNewLabel_2_1_1_1_2);
		
		teacherStateTxtField = new JTextField();
		teacherStateTxtField.setToolTipText("State");
		teacherStateTxtField.setColumns(10);
		teacherStateTxtField.setBounds(580, 75, 130, 26);
		contentPane.add(teacherStateTxtField);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setBounds(722, 80, 61, 16);
		contentPane.add(lblNewLabel_2_2);
		
		teacherIdTxtField = new JTextField();
		teacherIdTxtField.setToolTipText("Teacher ID");
		teacherIdTxtField.setColumns(10);
		teacherIdTxtField.setBounds(790, 75, 130, 26);
		contentPane.add(teacherIdTxtField);
		
		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(641, 131, 117, 29);
		contentPane.add(btnAddTeacher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 214, 447, 177);
		contentPane.add(scrollPane);
		
		
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
            };
     
        // Column Names for Student
        String[] columnNames = { "ID", "FirstName", "LastName", "Age", "MotherName", "FatherName" };		
        studentModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(studentModel);
		table.setBounds(38, 214, 447, 260);
		scrollPane.setViewportView(table);
		
		//Display teachers list
        String[] teacherColumnNames = { "ID", "FirstName", "LastName" };		
        teacherModel = new DefaultTableModel(teacherColumnNames, 0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(583, 214, 337, 177);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(teacherModel);
		scrollPane_1.setViewportView(table_1);
		
		
		//display classrooms
        String[] classroomColumnNames = { "ClassID", "Student", "Teacher" };		
        classRoomModel = new DefaultTableModel(classroomColumnNames, 0);
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(583, 467, 337, 189);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable(classRoomModel);
		scrollPane_2.setViewportView(table_2);
		

		
	}
	
	public DefaultTableModel getClassRoomDisplayModel() {
		return this.classRoomModel;
	}
	
	public DefaultTableModel getTeacherDisplayModel() {
		return this.teacherModel;
	}
	
	public DefaultTableModel getStudentDisplayModel() {
		return this.studentModel;
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
	
	public JTextField setTeacherFirstNameTxtField(JTextField teacherLastNameTxtField) {
		return teacherLastNameTxtField;
	}
	
	public void showPopupMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
