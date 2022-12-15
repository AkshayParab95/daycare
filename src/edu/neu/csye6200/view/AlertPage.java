package edu.neu.csye6200.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Shivam Thabe
 */
public class AlertPage extends JPanel {
	private JTable table;
	private DefaultTableModel alertModel;


	/**
	 * Create the frame.
	 */
	public AlertPage() {
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("AlertPage");
		lblNewLabel.setBounds(244, 28, 61, 16);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 531, 306);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
        // Column Names for Student
        String[] columnNames = { "ID", "FirstName", "LastName", "Vaccine", "Status", "DueDate", "MemberShip Renewal" };		
        alertModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(alertModel);
		table.setBounds(38, 214, 447, 260);
		scrollPane.setViewportView(table);
		
	}
	
	public DefaultTableModel getAlertDisplayModel() {
		return this.alertModel;
	}

}
