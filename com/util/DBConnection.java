package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/adv-java";
		String driverClass = "org.postgresql.Driver";
		String userName = "postgres";
		String password = "root";
		
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, userName, password);
			if(conn != null) {
				System.out.println("Db Connected...");
			}else {
				System.out.println("DB not Connected...");
			}
					
					
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getConnection());
//		System.out.println(getConnection());
//	}
}