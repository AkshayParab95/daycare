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
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

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
		setBackground(new Color(32, 178, 170));
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("ClassroomPage");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setBounds(208, 39, 176, 19);
		add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(93, 115, 404, 243);
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
		table.setBorder(new LineBorder(new Color(72, 61, 139), 1, true));
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(175, 238, 238));
		scrollPane_2.setViewportView(table);
		
	}
	
	public DefaultTableModel getClassRoomDisplayModel() {
		return this.classRoomModel;
	}

}

