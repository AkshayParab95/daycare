package edu.neu.csye6200.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPage extends JFrame {

	private Image img_logo = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/daycare.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_username = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/admin.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_login = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/key.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(LoginPage.class.getResource("/edu/neu/csye6200/resources/padlock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String passText = new String(((JPasswordField) pwdPassword).getPassword());
				if(txtUsername.getText().equals("admin") && passText.equals("1234") ) {
					HomePage homePage = new HomePage();
					homePage.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong username/password. Please try again.");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLogin.setBackground(new Color(47, 79, 79));
			}
		});
		btnLogin.setBackground(new Color(47, 79, 79));
		btnLogin.setBounds(180, 300, 250, 40);
		contentPane.add(btnLogin);
		btnLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOG IN");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setBounds(112, 6, 61, 28);
		btnLogin.add(lblNewLabel_2);
		
		JLabel lbllogin = new JLabel("");
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setBounds(69, 6, 40, 28);
		btnLogin.add(lbllogin);
		lbllogin.setIcon(new ImageIcon(img_login));
		
		JLabel lblx = new JLabel("x");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginPage.this.dispose();
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
		lblx.setForeground(new Color(255, 255, 255));
		lblx.setHorizontalTextPosition(SwingConstants.CENTER);
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblx.setBounds(574, 6, 20, 20);
		contentPane.add(lblx);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(180, 41, 250, 102);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblIconUserName = new JLabel("New label");
		lblIconUserName.setBounds(390, 183, 31, 40);
		contentPane.add(lblIconUserName);
		lblIconUserName.setIcon(new ImageIcon(img_username));
		
		JLabel lblIconPassword = new JLabel("New label");
		lblIconPassword.setBounds(390, 229, 31, 40);
		contentPane.add(lblIconPassword);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(180, 183, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setBounds(6, 6, 196, 26);
		panel.add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtUsername.setText("Username");
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setToolTipText("Enter user name");
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(180, 229, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				} else {
					txtUsername.selectAll();
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setBounds(6, 6, 192, 26);
		panel_1.add(pwdPassword);
		pwdPassword.setText("Password");
		pwdPassword.setToolTipText("password");
	}
}
