package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import DTO.UserDTO;

public class DAOuser {

	
	Connection connector = new DAOconnector().DBConnection();

	ArrayList<UserDTO> list = new ArrayList<>();
	
	public ResultSet authUser(UserDTO objUserDTO) 
	{
		
		
		try {
			String sql = "Select * from dblogin where username = ? and pass = ? ";
			PreparedStatement pstm = connector.prepareStatement(sql);
			pstm.setString(1, objUserDTO.getUserUsername());
			pstm.setString(2, objUserDTO.getUserPassword());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
		
		}
		catch(Exception error) {

			JOptionPane.showMessageDialog(null, "DAOUSER"+error);
			return null;
		}
	}
		
		public void registerUser(UserDTO objUserDTO)   {
			
			try {
				
				String sql = "insert into dblogin(username,pass) values(?,?)";
				PreparedStatement pstm = connector.prepareStatement(sql);
				pstm.setString(1, objUserDTO.getUserUsername());
				pstm.setString(2, objUserDTO.getUserPassword());
				pstm.execute();
				pstm.close();
				JOptionPane.showMessageDialog(null, "Account created!");
			
			}

			
			catch(Exception error) {
				if(error.getCause() instanceof SQLIntegrityConstraintViolationException) {
					JOptionPane.showMessageDialog(null, "helo"+error);
				}
				else {
					JOptionPane.showMessageDialog(null, "register in DAO user"+error); }
			}
		}
			
		public void deleteUser(UserDTO objUserDTO) {
			
			try {
				String sql = "delete from dblogin where id = ?";
				PreparedStatement pstm = connector.prepareStatement(sql);
				pstm.setString(1, String.valueOf(objUserDTO.getIdUser()));
				pstm.execute();
				pstm.close();
				JOptionPane.showMessageDialog(null, "User deleted!");
			
			}
			catch(SQLException error) {
				JOptionPane.showMessageDialog(null, "DAOUSER"+error);
			}
		}
		
		public void changePassword(UserDTO objUserDTO) {
			
			try {
				String sql = "update dblogin set pass = ? where username = ?";
				PreparedStatement pstm = connector.prepareStatement(sql);
				pstm.setString(2, objUserDTO.getUserUsername());
				pstm.setString(1, objUserDTO.getUserPassword());
				pstm.execute();
				pstm.close();
				JOptionPane.showMessageDialog(null, "Password updated!");
			
			}
			catch(SQLException error) {
				JOptionPane.showMessageDialog(null, "DAOUSER"+error);
			}
		}
			
		
		public 	ArrayList<UserDTO> listAllUsers() {
			String sql = "Select * from dblogin";
			list.clear();
			
			try {
				PreparedStatement pstm = connector.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				
				while(rs.next()) {
					UserDTO objUserDTO = new UserDTO();
					objUserDTO.setIdUser(rs.getInt("id"));
					objUserDTO.setUserUsername(rs.getString("username"));
					list.add(objUserDTO);
				}

			} catch (SQLException error) {

				JOptionPane.showMessageDialog(null, "DAOuser"+error);
			}
			return list;
		}
		
		
		
		
		
	}

