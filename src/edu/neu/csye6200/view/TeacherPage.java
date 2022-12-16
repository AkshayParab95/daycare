package edu.neu.csye6200.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

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
		setBackground(new Color(32, 178, 170));
		setBounds(0,0,572, 438);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Teacher Data");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(210, 30, 139, 35);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 103, 412, 224);
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
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(72, 61, 139), 1, true));
		table.setBackground(new Color(175, 238, 238));
		scrollPane_1.setViewportView(table);
		
	}
	
	public DefaultTableModel getTeacherDisplayModel() {
		return this.teacherModel;
	}

}

