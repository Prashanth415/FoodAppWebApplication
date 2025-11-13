package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	
	private static String url="jdbc:mysql://localhost:3306/foodappwebapplication";
	
	private static String username="root";
	private static String password="6303088415@Pp";
	private static Connection connection;
	public final static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
