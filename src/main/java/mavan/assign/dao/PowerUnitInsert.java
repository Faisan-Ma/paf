package mavan.assign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mavan.assign.com.Powerunit;
import mavan.assign.DB.DbConnect;

public class PowerUnitInsert {
	public static String PowerInterruptionInsert(Powerunit rs) {

		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select unitid from powerUnit where unitid=?");
			ps1.setInt(1, rs.getUnitid());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				
				PreparedStatement ps = con.prepareStatement("insert into powerinterruptiondetails values(?,?,?,?)");
				ps.setInt(1, rs.getUnitid());
				ps.setInt(2, rs.getAccountNo());
				ps.setString(3, rs.getCusName());
				ps.setInt(4, rs.getUnit());
			

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

