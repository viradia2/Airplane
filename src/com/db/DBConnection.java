package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/airplaneticket";
		String user="root";
		String password="";
		Connection con=DriverManager.getConnection(url,user,password);
		
		
		return con;
		
	}
	
	

}
