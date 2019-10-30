package com.java.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("username");  
	    String password=request.getParameter("userpass"); 
	    
	    if(UserDao.velidate(userName, password)) {
	    	 RequestDispatcher reqDispatcher=request.getRequestDispatcher("WelcomeServlet");  
	         reqDispatcher.forward(request,response);  
	    }
	    else {
	    	out.print("Sorry username or password error");  
	        RequestDispatcher reqDispatcher=request.getRequestDispatcher("login.html");  
	        reqDispatcher.include(request,response);  
	    }
	    
	    
	}
}
