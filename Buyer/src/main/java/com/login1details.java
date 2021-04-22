package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;



//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/login1")

public class login1details {

	login1details login = new login1details();

	public String readItems()
	{
		return login.readItems();
	}

//UserLogin login1 = new UserLogin();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String validateLogin(@FormParam("Username") String Username, 
							    @FormParam("Password") String Password) 
	{
		String output = login.validateLogin(Username, Password);
	   return output;
		//return login;
	}
}
