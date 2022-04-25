package com.electrogrid.api.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.electrogrid.api.model.Complaint;

public class ComplaintService {
	
	Connection con;

	
	public ComplaintService(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/complaints");
			String uname ="root";
			String pwd = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert not sucessful");
		}
	}

	
	public Complaint addComplaint(Complaint complaint) {
		String insert = "insert into complaint(mesage,accountNumber) values(?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, complaint.getMessage());
			ps.setLong(2, complaint.getAccountNumber());
			
			ps.execute();
		} catch(Exception e) {
			System.out.println(e +"data insert not sucessful");
		}
		
		return complaint;
		
	}
		
		
}

