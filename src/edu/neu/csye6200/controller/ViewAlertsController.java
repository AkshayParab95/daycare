package edu.neu.csye6200.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.view.AlertPage;

/**
 * @author Shivam Thabe
 */
public class ViewAlertsController {

	private AlertPage alertPage;
	public ViewAlertsController(AlertPage alertPage) {
		this.alertPage = alertPage;
	}
	
	public void initController() {
		DefaultTableModel alertDisplayModel = alertPage.getAlertDisplayModel();
		alertDisplayModel.setRowCount(0);
		ImmunizationDataController iDC = new ImmunizationDataController();
		
		List<Object[]> alertsDataObj = new Vector<>();
		alertsDataObj = iDC.getAllImmunizationAlerts();
		for(Object[] obj: alertsDataObj) {
			alertDisplayModel.addRow(obj);
		}
		//alertDisplayModel.addRow(new Object[]{ classId, s.getFirstName() + s.getLastName(), teacherFirstName + teacherLastName });
	}
}
