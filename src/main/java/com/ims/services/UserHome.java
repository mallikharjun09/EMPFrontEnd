package com.ims.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserHome extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		//get Attributes using session object
		HttpSession session = req.getSession();
		
		String id = session.getAttribute("id").toString();
		String pwd = session.getAttribute("pass").toString();
		
		
		
		/*
		//Get cookies array
		Cookie myCookies[] =  req.getCookies();
		
		//Get values from cookie keys.
		for(Cookie c : myCookies) {
			if(c.getName().equals("id")) {
				id = c.getValue();
			}
			else if(c.getName().equals("pass")) {
				pwd = c.getValue();
			}
		}
		*/
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.displayEmployee(Integer.parseInt(id), pwd);
		
		out.println("<p align='right'>Welcome "+emp.getEmpName()+"<a href='SignIn.html'>Logout</a></p>");
	}
}
