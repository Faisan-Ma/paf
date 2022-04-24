package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jersy.bean.PowerInterruptionUpdateBean;

import com.jersy.dbconnect.DbConnect;


public class PowerInterruptionUpdateDao {
	
	public static boolean checkinterruptionid(PowerInterruptionUpdateBean powerInterruptionUpdateBean) {

		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from powerinterruptiondetails where interruptionid=? and date=?");
			ps.setLong(1, powerInterruptionUpdateBean.getInterruptionid());
			ps.setLong(2, powerInterruptionUpdateBean.getNewdate());
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

	public static boolean updatepowerdetails(PowerInterruptionUpdateBean powerInterruptionUpdateBean) {

		Connection con = DbConnect.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update powerinterruptiondetails set date=? where interruptionid=?");
			ps.setLong(1, powerInterruptionUpdateBean.getNewdate());
			ps.setLong(2, powerInterruptionUpdateBean.getInterruptionid());
			
			
			
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
