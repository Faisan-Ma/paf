package service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import controller.UniteControler;
import model.PowerUnit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/powerUsage")

public class UniteService {
	
	UniteControler unit = new UniteControler();
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.TEXT_HTML)
	public String readUnite()
	{
		return unit.readUnite();
	}
	
	//POST
	@POST
	@Path("/addPowerusage")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String PowerUnite(@FormParam(" unitid") String unitid,
	 @FormParam("accountNo") String accountNo,
	 @FormParam("CusName") String CusName,
	 @FormParam("month") String month)
	 @FormParam("amount") String amount)
	{
	 String output = unit.PowerUnite(unitid, accountNo, CusName, month,amount);
	return output;
	}
	
	//PUT
	@PUT
	@Path("/updatePowerusage ")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateunite(String unitData)
	{
	//Convert the input string to a JSON object
	 JsonObject unitObject = new JsonParser().parse(unitData).getAsJsonObject();
	//Read the values from the JSON object
	 String unitid = unitObject.get("unitid").getAsString();
	 String accountNo = unitObject.get("accountNo").getAsString();
	 String CusName = unitObject.get("CusName").getAsString();
	 String month = unitObject.get("month").getAsString();
	 String amount = unitObject.get("amount").getAsString();
	 
	 String output = unit.updateunite(unitid, accountNo, CusName, month,amount);
	return output;
	}
	
	//DELETE
	@DELETE
	@Path("/deletePowerusageById  ")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUnite(String unitData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(unitData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String unitid = doc.select("unitid").text();
	 String output = unit.deleteUnite(unitid);
	return output;
	}
	
	
}
