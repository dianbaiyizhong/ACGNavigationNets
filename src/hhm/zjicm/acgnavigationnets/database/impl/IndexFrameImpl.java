package hhm.zjicm.acgnavigationnets.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hhm.zjicm.acgnavigationnets.database.DBConnByMySql;
import hhm.zjicm.acgnavigationnets.database.ExecuteDataBase;

public class IndexFrameImpl extends ExecuteDataBase {
	private Connection conn;

	public IndexFrameImpl() throws ClassNotFoundException {
		conn = DBConnByMySql.getConnection();
	}
	
	
	public int GetIndexFrameIDByName(String IndexFrameName) {
		String sql = "select * from IndexFrame where IndexFrameName = ?" ;

		int IndexFrameID = 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, IndexFrameName);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				IndexFrameID = rs.getInt("IndexFrameID");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return IndexFrameID;

	}
	
	
	public ResultSet GetIndexFrameSecondByID(int IndexFrameID) {
		String sql = "select * from IndexFrameSecond where IndexFrameID = " + "'" + IndexFrameID
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

	
}
