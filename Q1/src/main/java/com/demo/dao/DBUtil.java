package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn;

	public static Connection getMyConnection() {
		if (conn == null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url = "jdbc:mysql://localhost:3306/springmvcdb?useSSL=false";
				conn = DriverManager.getConnection(url, "root", "Mayuri@12345");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void closeMyConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
