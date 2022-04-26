package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.updateEmployee;
import com.dbconnect.dbConnection;

public class updateEmployeeDao {

	public static boolean checkempID(updateEmployee updateemployee) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from employeedb where empID=?");
			ps.setLong(1, updateEmployee.getEmpID());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public static boolean updateemployeedetails(updateEmployee updateemployee) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update employeedb set empName=? , salary=? , gender=? , contact=? , department=? , joined_date=?");
			ps.setString(1, updateEmployee.getNewempName());
			ps.setDouble(2, updateEmployee.getNewsalary());
			ps.setString(3, updateEmployee.getNewgender());
			ps.setInt(4, updateEmployee.getNewcontact());
			ps.setString(5, updateEmployee.getNewdepartment());
			ps.setString(6, updateEmployee.getNewjoined_date());
			
			
			
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
}
