package com.demo.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		//step1 Register Driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/hibernate?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"root","Mayuri@12345");
			if(conn!=null) {
				System.out.println("Connection done");
			}else {
				System.out.println("connection not done");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("connection not done");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
