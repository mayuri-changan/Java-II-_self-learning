package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getMyConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/springmvcdb?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"root"
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
