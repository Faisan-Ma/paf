package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.model.deleteEmployee;
import com.dbconnect.dbConnection;

public class deleteEmployeeDao {

	public static boolean DeleteEmployee(deleteEmployee deletemployee) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM employeedb WHERE empID=?");
			ps.setLong(1, deleteEmployee.getEmpID());
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
