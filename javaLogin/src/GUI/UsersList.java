package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAOuser;
import DTO.UserDTO;


import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.Color;

public class UsersList {

	private JFrame frame;
	private JTable usersTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersList window = new UsersList();
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
	public UsersList() {
		initialize();
		listUsers();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 261);
		frame.getContentPane().add(panel);
 
String column[]={"ID","NAME","SALARY"};  
		panel.setLayout(null);
		
		usersTable = new JTable();
		usersTable.setBounds(28, 34, 311, 216);
		panel.add(usersTable);
	}

	
	
	private void listUsers() {

		try {
			DAOuser objDAOuser = new DAOuser();
			DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
			model.setNumRows(0);
			
			ArrayList<UserDTO> list = objDAOuser.listAllUsers();
			
			for(int i=0; i<list.size(); i++)
			{
				model.addRow(new Object[] {
						list.get(i).getIdUser(),
						list.get(i).getUserUsername()
				});
			}
			
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "UsersList"+error);
		}
	}
}
