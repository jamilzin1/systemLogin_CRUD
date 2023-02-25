package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UserDTO;

public class DAOuser {

	Connection connector = null;
	
	public ResultSet authUser(UserDTO objUserDTO) {
		
		connector = new DAOconnector().DBConnection();
		
		try {
			String sql = "Select * from dblogin where username = ? and senha = ? ";
			PreparedStatement pstm = connector.prepareStatement(sql);
			pstm.setString(1, objUserDTO.getUserUsername());
			pstm.setString(2, objUserDTO.getUserPassword());
		}
		catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "DAOUSER"+error);
		}
			
	}
}
