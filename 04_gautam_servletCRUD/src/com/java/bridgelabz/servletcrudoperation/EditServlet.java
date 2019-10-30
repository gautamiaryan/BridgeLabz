package com.java.bridgelabz.servletcrudoperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update User</h1>");
		String sId=request.getParameter("id");
		int id=Integer.parseInt(sId);

		User user=UserDao.getUserById(id);

		out.print("<form action='./EditServlet2' method='post'>");
		out.print("</table>");
		out.print("<tr><td></td><td><input type='text' name='id' value='"+user.getId()+"'/></td></tr>" );
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+user.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td> <input type='password' name='password' value='"+user.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td></tr> <input type='email' name='email' value='"+user.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");  
		out.print("</td></tr>");  
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		out.print("</table>");  
		out.print("</form>");  
          
		out.close();  
	}

	
}
