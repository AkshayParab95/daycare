package edu.neu.csye6200.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Shivam Thabe
 */
public class TeacherPage extends JPanel {
	private JTable table;
	private DefaultTableModel teacherModel;


	/**
	 * Create the frame.
	 */
	public TeacherPage() {
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Teacher");
		lblNewLabel.setBounds(205, 24, 61, 16);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 103, 412, 177);
		add(scrollPane_1);
		
		//table = new JTable((TableModel) null);
		//scrollPane_1.setViewportView(table);
		
		//Display teachers list
        String[] teacherColumnNames = { "ID", "FirstName", "LastName" , "Review"};		
        teacherModel = new DefaultTableModel(teacherColumnNames, 0);
		//JScrollPane scrollPane_1 = new JScrollPane();
		//scrollPane_1.setBounds(583, 214, 337, 177);
		//contentPane.add(scrollPane_1);
		
		table = new JTable(teacherModel);
		scrollPane_1.setViewportView(table);
		
	}
	
	public DefaultTableModel getTeacherDisplayModel() {
		return this.teacherModel;
	}

}

