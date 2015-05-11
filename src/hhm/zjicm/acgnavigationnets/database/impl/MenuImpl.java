package hhm.zjicm.acgnavigationnets.database.impl;

import hhm.zjicm.acgnavigationnets.database.DBConnByMySql;
import hhm.zjicm.acgnavigationnets.database.ExecuteDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MenuImpl extends ExecuteDataBase {
	
	private Connection conn;

	public MenuImpl() throws ClassNotFoundException {
		conn = DBConnByMySql.getConnection();
	}
	
	public int GetMenuIDByName(String MenuName) {
		String sql = "select * from Menu where MenuName = ?" ;

		int MenuID = 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, MenuName);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MenuID = rs.getInt("MenuID");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MenuID;

	}

	public ResultSet GetMenuFirstByID(int MenuID) {
		String sql = "select * from menufirst where MenuID = " + "'" + MenuID
				+ "'";

		ResultSet rs = null;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet GetMenuSecondByID(int MenuFirstID) {
		
		String sql = "select * from menusecond where MenuFirstID = " + "'"
				+ MenuFirstID + "'";
		ResultSet rs = null;

		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

}
