package com;

import model.Researcher;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Researcher")
public class Researcherregi
{
	Researcher itemObj = new Researcher();
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
public String insertreseacher(@FormParam("fname") String fname,
 @FormParam("lname") String lname,
 @FormParam("lname") String phone,
 @FormParam("bdate") String bdate,
 @FormParam("email") String email,
 @FormParam("inoctgry") String inoctgry,
 @FormParam("country") String country,
 @FormParam("edustate") String edustate,
 @FormParam("password") String password,
 @FormParam("cpasswored") String cpasswored)
{
 String output = itemObj.insertreseacher(fname, lname, phone, bdate, email,inoctgry,country,edustate,password,cpasswored);
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
 String rid = doc.select("rid").text();
 String output = itemObj.deleteItem(rid);
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
 String rid = itemObject.get("rid").getAsString();
 String fname = itemObject.get("fname").getAsString();
 String lname = itemObject.get("lname").getAsString();
 String phone = itemObject.get("phone").getAsString();
 String bdate = itemObject.get("bdate").getAsString();
 String email = itemObject.get("email").getAsString();
 String inoctgry = itemObject.get("inoctgry").getAsString();
 String country = itemObject.get("country").getAsString();
 String edustate = itemObject.get("edustate").getAsString();
 String password = itemObject.get("password").getAsString();
 String cpasswored = itemObject.get("cpasswored").getAsString();
 String output = itemObj.updateItem(rid, fname, lname, phone, bdate,email,inoctgry,country,edustate,password,cpasswored);
return output;
}
}
