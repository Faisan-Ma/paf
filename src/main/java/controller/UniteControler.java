package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DbConnect;
import model.PowerUnit;

public class UniteControler {
	

	public  String PowerUnite(PowerUnit rs)
	
	{
		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select unitid from powerUnit where unitid=?");
			ps1.setInt(1, rs.getUnitid());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				
				PreparedStatement ps = con.prepareStatement("insert into powerUnit values(?,?,?,?,?,?)");
				ps.setInt(1, rs.getUnitid());
				ps.setInt(2, rs.getAccountNo());
				ps.setString(3, rs.getCusName());
				ps.setInt(4, rs.getUnit());
				ps.setString(5, rs.getMonth());
				ps.setInt(6, rs.getAmount());
			

				int i = ps.executeUpdate();

				if (i > 0) {
					return "success";
				} else {
					return "failed";
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "fail";

	}

	private String unit;

	
	public String readUnite() 
	{ 
		String output = ""; 
		try
		{ 
			Connection con =DbConnect.connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Unit ID</th>" + "<th>Account No</th>" + "<th>Customer Name</th>" + 
			"<th>Power Unite</th>"+"<th>Power Month</th>"+"<th>Amount</th>" + "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from orders"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String unitid = Integer.toString(rs.getInt("unitid"));
				String accountNo = rs.getString("accountNo");
				String CusName = rs.getString("CusName"); 
				String unit = rs.getString("unit");
				String month = rs.getString("unit");
				String amount = rs.getString("amount");
				
				
				// Add into the html table
				output += "<tr><td>" + unitid + "</td>";
				output += "<td>" + accountNo + "</td>";
				output += "<td>" + CusName + "</td>"; 
				output += "<td>" + unit + "</td>"; 
				output += "<td>" +amount + "</td>"; 
				
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" 
				+ "<td><form method='post' action='Units.jsp'>" 
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" 
				+ "<input name='itemID' type='hidden' value='" + unitid  
				+ "'>" + "</form></td></tr>";
				
			} 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the Power Unite details."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String updateunite(String unitid, String accountNo, String CusName, String  month, String amount)
	{
		String output = ""; 
		try
		{ 
			Connection con = DbConnect.connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for updating.";
			} 
			
			// create a prepared statement
			String query = "UPDATE powerUnit SET accountNo=?,CusName=?,unit=?,month=?,amount=? WHERE unitid=?"; 
			PreparedStatement ps = con.prepareStatement(query);
			
			// binding values
			ps.setInt(1,Integer.parseInt(unitid));
			ps.setInt(2,Integer.parseInt (accountNo));
			ps.setString(3, CusName);
			
			ps.setInt(4, Integer.parseInt(unit));
			ps.setString(5, month);
			
			ps.setInt(6, Integer.parseInt(amount));
			
			// execute the statement
			ps.execute(); 
			con.close(); 
			output = "Unite Updated successfully";
			
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while updating the Unite details."; 
			 System.err.println(e.getMessage()); 
		 } 
		
		return output;
    } 
	
		public String deleteUnite(String unitid) 
		{ 
			String output = "";
			try
			{ 
				Connection con = DbConnect.connect(); 
				if (con == null) 
				{
					return "Error while connecting to the database for deleting.";
				} 
				
				// create a prepared statement
				String query = "delete from Unite where unit_id=?"; 
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(unitid));
				
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
				output = "unit Deleted successfully"; 
					
			} 
			catch (Exception e) 
			{ 
				output = "Error while deleting the unit details."; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 

}
