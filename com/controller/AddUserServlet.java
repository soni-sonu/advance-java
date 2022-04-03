package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;

@WebServlet("/AddUserServlet")	//annotation
public class AddUserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int i = 0;
		try {
			Connection conn = DBConnection.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("insert into customer (name, email, password) values(?,?,?)");

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			i = pstmt.executeUpdate();
			
//			if (i == 1) {
//				System.out.println("Data inserted Successfully");
//			} else {
//				System.out.println("Data failed to insert");
//			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		RequestDispatcher rd = null;
		if(i == 1) {
			rd = req.getRequestDispatcher("Home.jsp");
		}else {
			rd = req.getRequestDispatcher("Fail.jsp");
		}
		
		rd.forward(req, resp);
	}
}