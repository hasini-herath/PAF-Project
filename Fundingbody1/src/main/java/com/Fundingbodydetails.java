package com;

import model.Fundingbody;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/funding")
public class Fundingbodydetails
{
	Fundingbody itemObj = new Fundingbody();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readfd()
{
	return itemObj.readfd();
}

@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertfd(@FormParam("fname") String fname,
 @FormParam("fcountry") String fcountry,
 @FormParam("fyears") String fyears,
 @FormParam("fcategory") String fcategory,
 @FormParam("frequirements") String frequirements)

{
 String output = itemObj.insertfd(fname, fcountry, fyears, fcategory, frequirements);
return output;
}



@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updatefd(String fdData)
{
//Convert the input string to a JSON object
 JsonObject itemObject = new JsonParser().parse(fdData).getAsJsonObject();
//Read the values from the JSON object
 String fid = itemObject.get("fid").getAsString();
 String fname = itemObject.get("fname").getAsString();
 String fcountry = itemObject.get("fcountry").getAsString();
 String fyears = itemObject.get("fyears").getAsString();
 String fcategory = itemObject.get("fcategory").getAsString();
 String frequirements = itemObject.get("frequirements").getAsString();

 String output = itemObj.updatefd(fid, fname, fcountry, fyears, fcategory,frequirements);
return output;
}


@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deletefd(String fdData)
{
//Convert the input string to an XML document
 Document doc = Jsoup.parse(fdData, "", Parser.xmlParser());

//Read the value from the element <itemID>
 String fid = doc.select("fid").text();
 String output = itemObj.deletefd(fid);
return output;
}



}