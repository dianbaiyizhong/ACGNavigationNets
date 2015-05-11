package hhm.zjicm.acgnavigationnets.database;


import java.sql.*;

public class DBConnByMySql {
	static String dbdriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/acgnavigationnets?"
			+ "useUnicode=true&characterEncoding=UTF-8";
	static String user = "root";
	static String pass = "";

	public static Connection getConnection() {
		Connection ret = null;
		try {
			Class.forName(dbdriver);
			ret = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
