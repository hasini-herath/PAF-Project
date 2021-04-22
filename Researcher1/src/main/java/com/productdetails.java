package com;


import model.product;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/product")
public class productdetails
{
	product itemObj = new product();
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
public String insertreseacher(@FormParam("pcode") String pcode,
 @FormParam("pname") String pname,
 @FormParam("pcatelog") String pcatelog,
 @FormParam("pprice") String pprice)

{
 String output = itemObj.insertreseacher(pcode, pname, pcatelog, pprice);
return output;
}}