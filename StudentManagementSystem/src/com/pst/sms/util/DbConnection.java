package com.pst.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	//1. Load the driver
	//2. Get the connection
	//3. Creating statement - sql query
	//4. Execute the statement and get result
	//5. close connection
	
	static Connection conn =null;
	
	public static Connection getConnection() {
		
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return conn;
	  
	}
	
}

