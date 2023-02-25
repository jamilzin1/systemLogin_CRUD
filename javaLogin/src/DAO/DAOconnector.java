package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAOconnector {

	public static final String DATABASE = "javalogin";
	public static final String USER = "root";
	public static final String PASS = "123";
	public static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE;
	
	public Connection DBConnection()
	{
		Connection connector = null;
		
		try {
			connector = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "MYSQL"+error);
		}
		
		return connector;
	}


}