package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fundingbody", "root", "Root@123");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
}
