package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class product {
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reseacher", "root", "Root@123");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
	
	public String insertreseacher(String pcode, String pname, String pcatelog, String pprice)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " insert into product(`pid`,`pcode`,`pname`,`pcatelog`,`pprice`)"
	 + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, pcode);
	 preparedStmt.setString(3, pname);
	 preparedStmt.setString(4, pcatelog);
	 preparedStmt.setString(5, pprice);
	
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

	 output = "<table border='1'><tr><th>Product ID</th><th>Product Code</th>" +"<th>Product Name</th>" +"<th>Product Catelog</th>" +"<th>Product Price</th></tr>";

	 String query = "select * from product";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String pid = Integer.toString(rs.getInt("pid"));
	 String pcode = rs.getString("pcode");
	 String pname = rs.getString("pname");
	 String pcatelog = rs.getString("pcatelog");
	 String pprice = rs.getString("pprice");

	 // Add into the html table
	 output += "<tr><td>" + pid + "</td>";
	 output += "<td>" + pcode + "</td>";
	 output += "<td>" + pname + "</td>";
	 output += "<td>" + pcatelog + "</td>";
	 output += "<td>" + pprice + "</td>";

	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='pid' type='hidden' value='" + pid
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
	
	

}
