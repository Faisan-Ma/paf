package com.dbconnect;

import java.sql.*;

public class dbConnection {
	public static Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedb", "root", "N1812652p*");
			
			//for testing
			System.out.print("SUCCESSFULLY CONNECTED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
