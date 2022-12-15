package edu.neu.csye6200.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Shivam Thabe
 */
public class ClassroomPage extends JPanel {
	private JTable table;
	private DefaultTableModel classRoomModel;

	/**
	 * Create the frame.
	 */
	public ClassroomPage() {
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("ClassroomPage");
		lblNewLabel.setBounds(205, 24, 101, 16);
		add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(93, 115, 337, 189);
		add(scrollPane_2);
		
		//table = new JTable((TableModel) null);
		//scrollPane_2.setViewportView(table);
		
		
		//display classrooms
        String[] classroomColumnNames = { "ClassID", "Student", "Teacher" };		
        classRoomModel = new DefaultTableModel(classroomColumnNames, 0);
		//scrollPane_2 = new JScrollPane();
		//scrollPane_2.setBounds(583, 467, 337, 189);
		//contentPane.add(scrollPane_2);
		
		table = new JTable(classRoomModel);
		scrollPane_2.setViewportView(table);
		
	}
	
	public DefaultTableModel getClassRoomDisplayModel() {
		return this.classRoomModel;
	}

}

