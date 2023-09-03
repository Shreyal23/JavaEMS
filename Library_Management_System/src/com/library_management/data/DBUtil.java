package com.library_management.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//return the connection object
public class DBUtil {
	
	private static Connection con;
	
	public static Connection getConn()
	{
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","root");
			System.out.println("Connection Established!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}
}
