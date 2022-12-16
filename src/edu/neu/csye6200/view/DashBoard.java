package edu.neu.csye6200.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import edu.neu.csye6200.controller.CreateStudentController;
import edu.neu.csye6200.controller.CreateTeacherController;
import edu.neu.csye6200.controller.ViewAlertsController;
import edu.neu.csye6200.controller.ViewClassRoomController;
import edu.neu.csye6200.controller.ViewStudentController;
import edu.neu.csye6200.controller.ViewTeacherController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * @author Shivam Thabe
 */
public class DashBoard extends JFrame {
	private JPanel contentPane;
	private Image img_logo = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/daycare.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_home = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/home.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_children = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/baby.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_teacher = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/teacher.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_classroom = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/classroom.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_alerts = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/alerts.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_signout = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/signout.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	
	
	private HomePageForm homePageForm;
	private StudentPage studentPage;
	private TeacherPage teacherPage;
	private ClassroomPage classroomPage;
	private AlertPage alertPage;
	//private ViewTeacherController viewTeacher;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashBoard() {
		setBackground(new Color(47, 79, 79));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 450);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		homePageForm = new HomePageForm();
        CreateTeacherController c = new CreateTeacherController(homePageForm);
        c.initController();
        
        CreateStudentController s = new CreateStudentController(homePageForm);
        s.initController();
		
		homePageForm.setBounds(0, 0, 572, 438);
		
		
		studentPage = new StudentPage();
        ViewStudentController viewStudent = new ViewStudentController(studentPage);
        viewStudent.initController();		
		
		
		teacherPage = new TeacherPage();
		ViewTeacherController viewTeacher = new ViewTeacherController(teacherPage);
        viewTeacher.initController();
		
		
		classroomPage = new ClassroomPage();
        ViewClassRoomController viewClass = new ViewClassRoomController(classroomPage);
        viewClass.initController();
		
		
		alertPage = new AlertPage();
		ViewAlertsController viewAlerts = new ViewAlertsController(alertPage);
		viewAlerts.initController();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(6, 6, 243, 438);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(6, 6, 231, 126);
		panelMenu.add(lblIcon);
		lblIcon.setIcon(new ImageIcon(img_logo));
		
		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(homePageForm);
			}
		});
		panelHome.setBackground(new Color(0, 139, 139));
		panelHome.setBounds(0, 140, 243, 40);
		panelMenu.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(97, 6, 140, 28);
		panelHome.add(lblNewLabel);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setBounds(45, 0, 40, 40);
		panelHome.add(lblIconHome);
		lblIconHome.setIcon(new ImageIcon(img_home));
		
		JPanel panelStudents = new JPanel();
		panelStudents.addMouseListener(new PanelButtonMouseAdapter(panelStudents) {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewStudent.initController();	
				menuClicked(studentPage);
			}
		});
		panelStudents.setBackground(new Color(0, 139, 139));
		panelStudents.setBounds(0, 180, 243, 40);
		panelMenu.add(panelStudents);
		panelStudents.setLayout(null);
		
		JLabel lblStudents = new JLabel("STUDENTS");
		lblStudents.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudents.setForeground(new Color(255, 255, 240));
		lblStudents.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStudents.setBounds(94, 6, 130, 28);
		panelStudents.add(lblStudents);
		
		JLabel lblIconStudent = new JLabel("");
		lblIconStudent.setBounds(45, 0, 40, 40);
		panelStudents.add(lblIconStudent);
		lblIconStudent.setIcon(new ImageIcon(img_children));
		
		JPanel panelTeachers = new JPanel();
		panelTeachers.addMouseListener(new PanelButtonMouseAdapter(panelTeachers) {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewTeacher.initController();
				menuClicked(teacherPage);
			}
		});
		panelTeachers.setBackground(new Color(0, 139, 139));
		panelTeachers.setBounds(0, 220, 243, 40);
		panelMenu.add(panelTeachers);
		panelTeachers.setLayout(null);
		
		JLabel lblTeachers = new JLabel("TEACHERS");
		lblTeachers.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeachers.setForeground(new Color(255, 255, 240));
		lblTeachers.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTeachers.setBounds(94, 6, 130, 28);
		panelTeachers.add(lblTeachers);
		
		JLabel lblIconTeacher = new JLabel("");
		lblIconTeacher.setBounds(45, 0, 40, 40);
		panelTeachers.add(lblIconTeacher);
		lblIconTeacher.setIcon(new ImageIcon(img_teacher));
		
		JPanel panelClassrooms = new JPanel();
		panelClassrooms.addMouseListener(new PanelButtonMouseAdapter(panelClassrooms) {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewClass.initController();
				menuClicked(classroomPage);
			}
		});
		panelClassrooms.setBackground(new Color(0, 139, 139));
		panelClassrooms.setBounds(0, 260, 243, 40);
		panelMenu.add(panelClassrooms);
		panelClassrooms.setLayout(null);
		
		JLabel lblClassroom = new JLabel("CLASSROOMS");
		lblClassroom.setHorizontalAlignment(SwingConstants.LEFT);
		lblClassroom.setForeground(new Color(255, 255, 240));
		lblClassroom.setFont(new Font("Dialog", Font.BOLD, 14));
		lblClassroom.setBounds(95, 6, 128, 28);
		panelClassrooms.add(lblClassroom);
		
		JLabel lblIconClassroom = new JLabel("");
		lblIconClassroom.setBounds(45, 0, 40, 40);
		panelClassrooms.add(lblIconClassroom);
		lblIconClassroom.setIcon(new ImageIcon(img_classroom));
		
		JPanel panelAlerts = new JPanel();
		panelAlerts.addMouseListener(new PanelButtonMouseAdapter(panelAlerts) {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewAlerts.initController();
				menuClicked(alertPage);
			}
		});
		panelAlerts.setBackground(new Color(0, 139, 139));
		panelAlerts.setBounds(0, 300, 243, 40);
		panelMenu.add(panelAlerts);
		panelAlerts.setLayout(null);
		
		JLabel lblAlerts = new JLabel("ALERTS");
		lblAlerts.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlerts.setForeground(new Color(255, 255, 240));
		lblAlerts.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAlerts.setBounds(94, 6, 143, 28);
		panelAlerts.add(lblAlerts);
		
		JLabel lblIconAlerts = new JLabel("");
		lblIconAlerts.setBounds(45, 0, 40, 40);
		panelAlerts.add(lblIconAlerts);
		lblIconAlerts.setIcon(new ImageIcon(img_alerts));
		
		JPanel panelSignout = new JPanel();
		panelSignout.addMouseListener(new PanelButtonMouseAdapter(panelSignout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?") == 0 ) {
					LoginPage loginPage = new LoginPage();
					loginPage.setVisible(true);
					DashBoard.this.dispose();
				}

			}
		});
		panelSignout.setBackground(new Color(0, 139, 139));
		panelSignout.setBounds(0, 340, 243, 40);
		panelMenu.add(panelSignout);
		panelSignout.setLayout(null);
		
		JLabel lblSignout = new JLabel("SIGNOUT");
		lblSignout.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignout.setForeground(new Color(255, 255, 240));
		lblSignout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSignout.setBounds(95, 6, 131, 28);
		panelSignout.add(lblSignout);
		
		JLabel lblIconSignout = new JLabel("");
		lblIconSignout.setBounds(45, 0, 40, 40);
		panelSignout.add(lblIconSignout);
		lblIconSignout.setIcon(new ImageIcon(img_signout));
		
		
		JLabel lblx = new JLabel("x");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashBoard.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblx.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblx.setForeground(Color.WHITE);
			}
		});
		lblx.setForeground(new Color(0, 0, 0));
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblx.setBounds(816, 0, 20, 20);
		contentPane.add(lblx);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(258, 6, 572, 438);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		
		panelMainContent.add(homePageForm);
		panelMainContent.add(studentPage);
		panelMainContent.add(teacherPage);
		panelMainContent.add(classroomPage);
		panelMainContent.add(alertPage);
		
		//homePageForm.setVisible(true);
		menuClicked(homePageForm);
	}	
	
	public void menuClicked(JPanel panel) {
		homePageForm.setVisible(false);
		studentPage.setVisible(false);
		teacherPage.setVisible(false);
		classroomPage.setVisible(false);
		alertPage.setVisible(false);
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
	    public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(0, 139, 139));
		}

		@Override
	    public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}

		@Override
	    public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}

		@Override
	    public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 139, 139));
		}
		
	}
	
	
	
	
	
	
	

}
