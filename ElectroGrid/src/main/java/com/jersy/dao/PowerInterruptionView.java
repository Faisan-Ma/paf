package com.jersy.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.jersy.dbconnect.DbConnect;
import com.mysql.cj.xdevapi.Statement;

public class PowerInterruptionView {
	

	
	public static String enquiryViewAllDao() {

		String output = "";

		try {

			//db connection
		Connection con = DbConnect.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>Interruption ID</th>"
				+ "<th>Date</th>"
				+ "<th>Location</th>"
				+ "<th>Description</th> </tr>";
			

		//Quarry statement for select all in table
		String query = "select * from powerinterruptiondetails";
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);

		while (rs.next()) {
			String interruptionid = rs.getString(1);
			String date = rs.getString(2);
			String location = rs.getString(3);
			String description = rs.getString(4);
		

			// Add into the html table
			output += "<tr><td>" + interruptionid + "</td>";
			output += "<td>" + date + "</td>";
			output += "<td>" + location + "</td>";
			output += "<td>" + description + "</td>";
		

	}
		con.close();

		// Complete the html table
		output += "</table>";

	} catch (Exception e) {
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
	}
	return output;

}
	
	
	
}
