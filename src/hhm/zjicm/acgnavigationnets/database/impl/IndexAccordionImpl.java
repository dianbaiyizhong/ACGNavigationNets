package hhm.zjicm.acgnavigationnets.database.impl;

import hhm.zjicm.acgnavigationnets.database.DBConnByMySql;
import hhm.zjicm.acgnavigationnets.database.ExecuteDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexAccordionImpl extends ExecuteDataBase {
	private Connection conn;

	public IndexAccordionImpl() throws ClassNotFoundException {
		conn = DBConnByMySql.getConnection();
	}

	public int GetIndexAccordionIDByName(String Name) {
		String sql = "select * from IndexAccordion where IndexAccordionName = ?";

		int MenuID = 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, Name);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MenuID = rs.getInt("IndexAccordionID");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MenuID;

	}

	public ResultSet GetIndexAccordionFirstByID(int id) {
		String sql = "select * from IndexAccordionFirst where IndexAccordionID = " + "'" + id
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

	public ResultSet GetIndexAccordionSecondByID(int id) {

		String sql = "select * from IndexAccordionSecond where IndexAccordionFirstID = " + "'"
				+ id + "'";
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
