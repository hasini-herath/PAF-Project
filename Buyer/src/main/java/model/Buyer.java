package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
public class Buyer {
	
	//A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		 //Provide the correct details: DBServer/DBName, username, password
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer","root", "Root@123");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 } 

		
		
		
		public String insertItem(String ftname, String ltname, String bphone, String birthdate, String email, String country, String pass, String compass)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 // create a prepared statement
		 String query = " insert into bdetails (`bid`,`fname`,`lname`,`phone`,`bdate`,`email`,`country`,`password`,`cpassword`)"
		 + " values (?, ?, ?, ?, ?, ?, ?, ?,?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, ftname);
		 preparedStmt.setString(3, ltname);
		 preparedStmt.setString(4, bphone);
		 preparedStmt.setString(5, birthdate);
		 preparedStmt.setString(6, email);
		 preparedStmt.setString(7, country);
		 preparedStmt.setString(8, pass);
		 preparedStmt.setString(9, compass);
		// execute the statement
		
		 preparedStmt.execute();
		 con.close();
		 output = "Inserted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }

		

		
		public String readItems()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Buyer ID</th><th>first Name</th><th>Last Name</th>" +
		 "<th>bphone </th>" +
		 "<th>birthdate </th>" +
		 "<th>email</th><th>country</th><th>pass</th><th>compass</th></tr>";

		 String query = "select * from bdetails";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String bid = Integer.toString(rs.getInt("bid"));
		 String fname = rs.getString("fname");
		 String lname = rs.getString("lname");
		 String phone = rs.getString("phone");
		 String bdate = rs.getString("bdate");
		 String email = rs.getString("email");
		 String country = rs.getString("country");
		 String password = rs.getString("password");
		 String cpassword = rs.getString("cpassword");
	
		 // Add into the html table
		 output += "<tr><td>" + bid + "</td>";
		 output += "<td>" + fname + "</td>";
		 output += "<td>" + lname + "</td>";
		 output += "<td>" + phone + "</td>";
		 output += "<td>" + bdate + "</td>";
		 output += "<td>" + email + "</td>";
		 output += "<td>" + country + "</td>";
		 output += "<td>" + password + "</td>";
		 output += "<td>" + cpassword + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='buyers.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				 + "<input name='bid' type='hidden' value='" + bid
				 + "'>" + "</form></td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		
		
		
		
		
		
		
		
		public String updateItem(String bid,String ftname, String ltname, String bphone, String birthdate, String email, String country, String pass, String compass)
		
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE bdetails SET fname=?,lname=?,phone=?,bdate=?, email=?, country=?, password=?, cpassword=? WHERE bid=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, ftname);
		 preparedStmt.setString(2, ltname);
		 preparedStmt.setString(3,bphone);
		 preparedStmt.setString(4, birthdate);
		 preparedStmt.setString(5, email);
		 preparedStmt.setString(6, country);
		 preparedStmt.setString(7, pass);
		 preparedStmt.setString(8, compass);
		 preparedStmt.setInt(9, Integer.parseInt(bid)); 
		
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 } 
		
		
		public String deleteItem(String bid)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from bdetails where bid=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(bid));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while deleting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
}
