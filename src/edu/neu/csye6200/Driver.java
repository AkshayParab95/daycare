package edu.neu.csye6200;

import edu.neu.csye6200.controller.CreateStudentController;
import edu.neu.csye6200.controller.CreateTeacherController;
import edu.neu.csye6200.controller.ImmunizationDataController;
import edu.neu.csye6200.controller.ImmunizationRulesDataController;
import edu.neu.csye6200.controller.ViewClassRoomController;
import edu.neu.csye6200.controller.ViewStudentController;
import edu.neu.csye6200.controller.ViewTeacherController;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.view.HomePage;
import edu.neu.csye6200.view.LoginPage;

/**
 * @author Shivam Thabe
 */
public class Driver {
        public static void main(String[] args) {
                System.out.println("============Main Execution Start===================\n\n");
                
                  LoginPage login = new LoginPage();
                  login.setVisible(true);
                
                System.out.println("\n\n============Main Execution End===================");
        }
}
