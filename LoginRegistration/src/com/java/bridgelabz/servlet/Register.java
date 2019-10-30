package com.java.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException,IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("userName");
		String password=request.getParameter("userPass");
		String email=request.getParameter("userEmail");
		String country=request.getParameter("userCountry");
		
		try {
			Connection connection=UserDao.getMysqlConnection();
			PreparedStatement statement=connection.prepareStatement("insert into REGISTERUSER values(?,?,?,?)");
			
			statement.setString(1,name);  
			statement.setString(2,password);  
			statement.setString(3,email);  
			statement.setString(4,country); 
			
			int i=statement.executeUpdate();  
			if(i>0) {
				out.print("You are successfully registered...");
			}
			  
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
