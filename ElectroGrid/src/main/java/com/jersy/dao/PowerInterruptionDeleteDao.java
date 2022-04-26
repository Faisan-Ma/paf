package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.jersy.bean.PowerInterruptionDeleteBean;
import com.jersy.dbconnect.DbConnect;


public class PowerInterruptionDeleteDao {

	
	
	public static boolean PowerInterruptionDelete(PowerInterruptionDeleteBean powerInterruptionDeleteBean) {

		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM powerinterruptiondetails WHERE interruptionid=?");
			ps.setLong(1, PowerInterruptionDeleteBean.getInterruptionid());
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
