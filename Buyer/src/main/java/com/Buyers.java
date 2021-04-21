package com;
import model.Buyer;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


@Path("/Buyer")
public class Buyers
{
	Buyer itemObj = new Buyer();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
		{
			return itemObj.readItems();
		}
		
		

		@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertItem(@FormParam("fname") String fname,
			 @FormParam("lname") String lname,
			 @FormParam("phone") String phone,
			 @FormParam("bdate") String bdate,
			 @FormParam("email") String email,
			 @FormParam("country") String country,
			 @FormParam("password") String password,
			 @FormParam("cpassword") String cpassword)

			{
			 String output = itemObj.insertItem(fname, lname, phone, bdate,email,country,password,cpassword);
			return output;
			}
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateItem(String itemData)
		{
		//Convert the input string to a JSON object
		 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		 String bid = itemObject.get("bid").getAsString();
		 String fname = itemObject.get("fname").getAsString();
		 String lname = itemObject.get("lname").getAsString();
		 String phone = itemObject.get("phone").getAsString();
		 String bdate = itemObject.get("bdate").getAsString();
		 String email = itemObject.get("email").getAsString();
		 String country = itemObject.get("country").getAsString();
		 String password = itemObject.get("password").getAsString();
		 String cpassword = itemObject.get("cpassword").getAsString();
		 
		 String output = itemObj.updateItem(bid, fname, lname, phone, bdate,email,country,password,cpassword);
		return output;
		}
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteItem(String itemData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String bid = doc.select("bid").text();
		 String output = itemObj.deleteItem(bid);
		return output;
		}
		
		
}