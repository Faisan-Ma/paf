package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.insertEmployee;
import com.dbconnect.dbConnection;

public class insertEmployeeDao {

	public static String InsertEmployee(insertEmployee rs) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select empID from employeedb where empID=?");
			ps1.setInt(1, rs.getEmpID());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				
				PreparedStatement ps = con.prepareStatement("insert into employeedb values(?,?,?,?)");

				ps.setString(1, rs.getEmpName());
				ps.setDouble(2, rs.getSalary());
				ps.setString(3, rs.getGender());
				ps.setInt(4, rs.getContact());
				ps.setString(5, rs.getDepartment());
				ps.setString(6, rs.getJoined_date());			

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
	
}


