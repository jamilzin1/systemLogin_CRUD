package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UserDTO;

public class DAOuser {

	Connection connector = null;
	
	public ResultSet authUser(UserDTO objUserDTO) 
	{
		
		connector = new DAOconnector().DBConnection();
		
		try {
			String sql = "Select * from dblogin where username = ? and pass = ? ";
			PreparedStatement pstm = connector.prepareStatement(sql);
			pstm.setString(1, objUserDTO.getUserUsername());
			pstm.setString(2, objUserDTO.getUserPassword());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
		
		}
		catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "DAOUSER"+error);
			return null;
		}
	}
		
		public void registerUser(UserDTO objUserDTO) {
			connector = new DAOconnector().DBConnection();
			
			try {
				String sql = "insert into dblogin(username,pass) values(?,?)";
				PreparedStatement pstm = connector.prepareStatement(sql);
				pstm.setString(1, objUserDTO.getUserUsername());
				pstm.setString(2, objUserDTO.getUserPassword());
				pstm.execute();
				pstm.close();

			
			}
			catch(SQLException error) {
				JOptionPane.showMessageDialog(null, "DAOUSER"+error);
			}
		}
			
	}

