package edu.neu.csye6200.view;


import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

/**
 * @author Shivam Thabe
 */
public class StudentPage extends JPanel {
	private JTable table;
	private DefaultTableModel studentModel;

	/**
	 * Create the frame.
	 */
	public StudentPage() {
		setBackground(new Color(32, 178, 170));
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Student Data");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(205, 24, 138, 42);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 126, 447, 177);
		add(scrollPane);
		
		//table = new JTable((TableModel) null);
		//scrollPane.setViewportView(table);
		
		
        // Column Names for Student
        String[] columnNames = { "ID", "FirstName", "LastName", "Age", "MotherName", "FatherName" };		
        studentModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(studentModel);
		table.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
		table.setBackground(new Color(175, 238, 238));
		table.setBounds(38, 214, 447, 260);
		scrollPane.setViewportView(table);
		
	}

	public DefaultTableModel getStudentDisplayModel() {
		return this.studentModel;
	}
}

