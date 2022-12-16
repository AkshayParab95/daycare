package edu.neu.csye6200;

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
