package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DAO.DAOuser;
import DTO.UserDTO;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class front {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	UserDTO objDTOuser = new UserDTO();
	DAOuser objDAOuser = new DAOuser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front window = new front();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(43, 81, 66, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(43, 106, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton buttonSignUP = new JButton("SIGN UP");
		buttonSignUP.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				SignUP windowRegister = new SignUP();
				windowRegister.frame.setVisible(true);
				
				
			}
		});
		buttonSignUP.setBounds(162, 201, 89, 23);
		panel.add(buttonSignUP);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginMethod();
			}
		});
		loginButton.setBounds(162, 167, 89, 23);
		panel.add(loginButton);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(162, 78, 89, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(162, 103, 89, 20);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(179, 28, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnChangePassword = new JButton("New Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassword frame = new updatePassword();
				frame.setVisible(true);
			}
		});
		btnChangePassword.setBackground(new Color(240, 240, 240));
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChangePassword.setBounds(151, 134, 111, 23);
		btnChangePassword.setForeground(Color.BLUE);
		
		panel.add(btnChangePassword);
	}
	

	public void loginMethod() {
		
		try {
				String userUsername = txtUsername.getText();
				String userPassword = String.valueOf(txtPassword.getPassword());
				objDTOuser.setUserUsername(userUsername);
				objDTOuser.setUserPassword(userPassword);
				
				ResultSet rsDAOuser = objDAOuser.authUser(objDTOuser);

				 if (rsDAOuser.next())
				{
					JOptionPane.showMessageDialog(null, "Login sucessfull.");
						if (objDTOuser.getUserUsername().equals("admin"))
						{
						     new UsersList().setVisible(true);
						}
				} else {
					JOptionPane.showMessageDialog(null, "Username or password wrong.");
			}
			
	
			
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "front"+error);
		}
	}
}
