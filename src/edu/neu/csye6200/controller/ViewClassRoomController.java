package edu.neu.csye6200.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.SqlConnector;
import edu.neu.csye6200.view.ClassroomPage;
import edu.neu.csye6200.view.HomePage;

/**
 * @author Shivam Thabe
 */
public class ViewClassRoomController {
	
	private ClassroomPage classroomPage;
	
	public ViewClassRoomController(ClassroomPage classroomPage) {
		this.classroomPage = classroomPage;
	}

	public void initController() {
		DefaultTableModel classRoomModel = classroomPage.getClassRoomDisplayModel();
		//StudentDataController sd = new StudentDataController();
		List<Classroom> classList = fetchAllFromDB();
		for(Classroom c: classList) {
			Integer classroomId = c.getId();
			
			TeacherDataController td = new TeacherDataController();
			Integer teacherID = c.getTeacherId();

			if(teacherID != null) {
				Teacher teacher = td.fetchDataFromDB( teacherID.toString() );
				if(teacher != null) {
					System.out.println("*************** " + teacher.getFirstName());
					String teacherFirstName = teacher.getFirstName();
					String teacherLastName = teacher.getLastName();
					
					StudentDataController sd = new StudentDataController();
					String classId = classroomId.toString();
					List<Student> studentList = sd.fetchStudentsFromClassroom(classId);
					
					
					for(Student s: studentList) {
						classRoomModel.addRow(new Object[]{ classId, s.getFirstName() + s.getLastName(), teacherFirstName + teacherLastName });
						classId = "";
						teacherFirstName = "";
						teacherLastName = "";
						
					}
				}
			}


			
			
			
			//classRoomModel.addRow(new Object[]{ s.getStudentId(), s.getFirstName(), s.getLastName(), s.getAge(), s.getMotherName(), s.getFatherName() });
		}
				
	}
	
	public List<Classroom> fetchAllFromDB() {
		List<Classroom> classRoomRoster = new Vector<>();
		ResultSet result = SqlConnector.executeQuery("SELECT * FROM classrooms;");
		try {
			while (result.next()) {
				classRoomRoster.add(new Classroom(result.getInt("id"), result.getInt("teacher_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classRoomRoster;
	}

}
