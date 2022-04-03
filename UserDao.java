package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {
	
	//inserting data/create user
	public int insertUser(UserBean user) {
		String insertQuery = "INSERT INTO customer(name, email, password) VALUES (?, ?, ?)";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		
		if(conn != null) {
			try {
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());
				
				rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					System.out.println("Data Inserted Successfully");
				} else {
					System.out.println("Data Failed to Insert");
				}
				
			} catch (Exception e) {	//SQLEXCEPTION
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			System.out.println("UserDao insertUser()-: DB not Connected");
		}
		return rowsAffected;
		
	}
	
	public ArrayList<UserBean> ListUser() {
		String listQuery = "SELECT * FROM customer";
		
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		if(conn != null) {
			Statement stmt = null;
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(listQuery);
				UserBean userBean = null;
				
				while(rs.next()) {
					userBean = new UserBean();
					
					int cid = rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					String password = rs.getString(4);
					
					userBean = new UserBean(cid, name, email, password);
					
					list.add(userBean);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			System.out.println("UserDao ListUser()-: DB not Connected");
		}
		return list;
	}
	
	public int deleteUser(int cid) {
		String deleteUser = "DELETE FROM customer WHERE cid = ?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt;
		int i = -1;
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(deleteUser);
				pstmt.setInt(1, cid);
				
				i = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("UserDao deleteuser()-: Db not connected");
		}
		
		return i;
	}
	
	
}
public class UserDao {

}
