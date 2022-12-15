package edu.neu.csye6200;

import edu.neu.csye6200.controller.CreateStudentController;
import edu.neu.csye6200.controller.CreateTeacherController;
import edu.neu.csye6200.controller.ViewClassRoomController;
import edu.neu.csye6200.controller.ViewStudentController;
import edu.neu.csye6200.controller.ViewTeacherController;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.view.HomePage;

/**
 * @author Shivam Thabe
 */
public class Driver {
        public static void main(String[] args) {
                System.out.println("============Main Execution Start===================\n\n");
                
//                try {
//					Classroom.assign(9, 21);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}


                
                
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                CreateTeacherController c = new CreateTeacherController(homePage);
                c.initController();
                
                CreateStudentController s = new CreateStudentController(homePage);
                s.initController();
                
                ViewStudentController viewStudent = new ViewStudentController(homePage);
                viewStudent.initController();
                
                ViewTeacherController viewTeacher = new ViewTeacherController(homePage);
                viewTeacher.initController();
                
                ViewClassRoomController viewClass = new ViewClassRoomController(homePage);
                viewClass.initController();
                
                
                
                
                System.out.println("\n\n============Main Execution End===================");
        }
}
