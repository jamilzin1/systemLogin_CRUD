package GUI;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.DAOuser;
import DTO.UserDTO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUP {

	JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtPassword1;
	
	UserDTO objUserDTO = new UserDTO();
	DAOuser objDAOuser = new DAOuser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP window = new SignUP();
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
	public SignUP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setBounds(192, 27, 128, 14);
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(168, 77, 86, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel registerUser = new JLabel("Username");
		registerUser.setBounds(73, 80, 85, 14);
		panel.add(registerUser);
		
		JLabel registerPassword = new JLabel("Password");
		registerPassword.setBounds(73, 120, 46, 14);
		panel.add(registerPassword);
		
		JLabel registerPassword1 = new JLabel("Password Again");
		registerPassword1.setBounds(73, 166, 86, 14);
		panel.add(registerPassword1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(168, 117, 86, 20);
		panel.add(txtPassword);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.setBounds(168, 163, 86, 20);
		panel.add(txtPassword1);
		
		JButton buttonRegister = new JButton("SIGN UP");
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerMethod();
			}
		});
		buttonRegister.setBounds(165, 227, 89, 23);
		panel.add(buttonRegister);
	}
	
	
	
	
	public void registerMethod() {
		
		try {
				if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtPassword1.getPassword())))
				{
					String userUsername = txtUsername.getText();
					String userPassword = String.valueOf(txtPassword.getPassword());
					objUserDTO.setUserUsername(userUsername);
					objUserDTO.setUserPassword(userPassword);
					objDAOuser.registerUser(objUserDTO);
					frame.dispose();
					
				}
				else {JOptionPane.showMessageDialog(null, "Mismatch password");}
					
			
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "front"+error);
		}
	}
}
