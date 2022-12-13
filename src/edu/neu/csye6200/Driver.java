package edu.neu.csye6200;

import edu.neu.csye6200.controller.CreateTeacherController;
import edu.neu.csye6200.view.HomePage;

/**
 * @author Shivam Thabe
 */
public class Driver {
        public static void main(String[] args) {
                System.out.println("============Main Execution Start===================\n\n");
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                CreateTeacherController c = new CreateTeacherController(homePage);
                c.initController();
                System.out.println("\n\n============Main Execution End===================");
        }
}
