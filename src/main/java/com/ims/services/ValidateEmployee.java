package com.ims.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ValidateEmployee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("empid"));
		String pwd = req.getParameter("pwd");
		
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.displayEmployee(id, pwd);
		
		RequestDispatcher dispatch;
		if(emp.getEmpId() != 0) {
			/* URL  Re-Writing Code
				resp.sendRedirect("userHome?userId="+emp.getEmpId()+"&pass="+emp.getPass());
			*/
			
			/*
			 * Working with Cookies
			//Create Cookie objects
			Cookie c1 = new Cookie("id",""+emp.getEmpId());
			Cookie c2 = new Cookie("pass",emp.getPass());
			
			//Add Cookies to the cookies array
			resp.addCookie(c1);
			resp.addCookie(c2);
			*/
			
			//Working with Sessions.
			//Create a Session object
			
			HttpSession session = req.getSession();
			
			
			//Add attributes to the session.
			session.setAttribute("id", emp.getEmpId());
			session.setAttribute("pass", emp.getPass());
			
			resp.sendRedirect("userHome");
		}
		else {
			
			dispatch = req.getRequestDispatcher("SignIn.html");
			dispatch.include(req, resp);
			out.print("<div class='container mt-3'><h3 class='bg-danger w-50 text-white'>Invalid Credentials, please login again</h3></div>");
		}
	}
}
