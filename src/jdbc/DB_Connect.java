package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/birthdayproject";
	private static final String user = "root";
	private static final String password = "root";
	private static Connection con = null;

	public static Connection getConnect() throws ClassNotFoundException 
	{
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return con;
	}

}
