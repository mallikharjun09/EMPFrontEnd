package com.ims.services;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			response.getWriter().print("<h3>Welcome to First Servlet</h3>");
			
			//Getting data from HTML using request.getParameter method.
			
			String userName = request.getParameter("user");
			String pws = request.getParameter("pwd");
			
			response.getWriter().print("<table border=2>");
			response.getWriter().print("<tr><td> User Name </td><td>"+userName+"</td></tr>");
			response.getWriter().print("<tr><td> Password </td><td>"+pws+"</td></tr>");
			response.getWriter().print("</table>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
