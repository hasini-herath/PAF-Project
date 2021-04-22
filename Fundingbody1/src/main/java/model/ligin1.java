package model;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

import com.DBConnect;

public class ligin1 {

	
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
	
	public String validateLogin(String userName, String password) 
	{
		String output = "";
		try
		{
			DBConnect db = new DBConnect();
			Connection con = null;
			//con = db.connect();
				
			if (con == null)
			{return "Error while connecting to the database for inserting."; }
			
				
			String query1 = "select usename, Pass from login";
			Statement stmt = con.createStatement();
			
			//PreparedStatement preparedStmt = con.prepareStatement(query1);
			ResultSet rs = stmt.executeQuery(query1);
			//preparedStmt.execute();	
			
			while(rs.next())
			{
				String un = rs.getString("usename");
				String pass = rs.getString("Pass");
					
				if(userName.equals(un) && password.equals(pass))
				{
					return "Welcome "+ userName;
				}
				else if(userName.equals("admin") && password.equals("admin"))
				{
					return "Welcome Admin";
				}
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return "Username or password incorrect";
	}
}
