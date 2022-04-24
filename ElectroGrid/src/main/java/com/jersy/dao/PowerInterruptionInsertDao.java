package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.jersy.bean.PowerInterruptionInsertBean;
import com.jersy.dbconnect.DbConnect;



public class PowerInterruptionInsertDao {

	public static String PowerInterruptionInsert(PowerInterruptionInsertBean rs) {

		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select interruptionid from powerinterruptiondetails where interruptionid=?");
			ps1.setInt(1, rs.getInterruptionid());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				
				PreparedStatement ps = con.prepareStatement("insert into powerinterruptiondetails values(?,?,?,?)");
				ps.setInt(1, rs.getInterruptionid());
				ps.setInt(2, rs.getDate());
				ps.setString(3, rs.getLocation());
				ps.setString(4, rs.getDescription());
			

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
