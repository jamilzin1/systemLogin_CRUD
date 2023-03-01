package GUI;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAOuser;
import DTO.UserDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatePassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	
	
	UserDTO objDTOuser = new UserDTO();
	DAOuser objDAOuser = new DAOuser(); 



	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePassword frame = new updatePassword();
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
	public updatePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(76, 79, 70, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("UPDATE PASSWORD");
		lblNewLabel.setBounds(168, 31, 101, 14);
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(174, 76, 83, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.setBounds(174, 107, 83, 20);
		panel.add(txtOldPassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(174, 138, 83, 20);
		panel.add(txtNewPassword);
		
		JLabel lblNewLabel_2 = new JLabel("OLD PASSWORD");
		lblNewLabel_2.setBounds(72, 110, 92, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NEW PASSWORD");
		lblNewLabel_2_1.setBounds(72, 141, 92, 14);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("CHANGE!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		btnNewButton.setBounds(168, 197, 89, 23);
		panel.add(btnNewButton);
	}
	
	public void changePassword() {
		
		try {
				String userUsername = txtUsername.getText();
				String userPassword = String.valueOf(txtOldPassword.getPassword());
				objDTOuser.setUserUsername(userUsername);
				objDTOuser.setUserPassword(userPassword);
				
				ResultSet rsDAOuser = objDAOuser.authUser(objDTOuser);
				if (rsDAOuser.next())
				{
					objDTOuser.setUserPassword(String.valueOf(txtNewPassword.getPassword()));
					objDAOuser.changePassword(objDTOuser);
				} else {
					JOptionPane.showMessageDialog(null, "Username or password wrong.");
			}
			
	
			
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "front"+error);
		}
	}
}
