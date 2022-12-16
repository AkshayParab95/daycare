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
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

/**
 * @author Shivam Thabe
 */
public class AlertPage extends JPanel {
	private JTable table;
	private JTable table_1;
	private DefaultTableModel alertModel;


	/**
	 * Create the frame.
	 */
	public AlertPage() {
		setBackground(new Color(32, 178, 170));
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Alerts ");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(247, 28, 128, 30);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 531, 306);
		add(scrollPane);
		
		//table = new JTable();
		//table.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		//table.setBackground(new Color(175, 238, 238));
		//table.setFillsViewportHeight(true);
		//scrollPane.setViewportView(table);
		
        // Column Names for Student
        String[] columnNames = { "ID", "FirstName", "LastName", "Vaccine", "Status", "DueDate", "Renewal" };		
        alertModel = new DefaultTableModel(columnNames, 0);
		table_1 = new JTable(alertModel);
		table_1.setFillsViewportHeight(true);
		table_1.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		table_1.setBackground(new Color(175, 238, 238));
		table_1.setBounds(38, 214, 447, 260);
		scrollPane.setViewportView(table_1);
		
	}
	
	public DefaultTableModel getAlertDisplayModel() {
		return this.alertModel;
	}

}
