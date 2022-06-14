package com.ims.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayAllEmployees extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		out.println("<!DOCTYPE>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css'");
		out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js' ></script>");
		out.println("</head");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<table class='table table-primary table-striped'");
		out.println("<tr>");
		out.println("<th>Employee Id</th><th>Employee Name</th><th>Gender</th><th>Department Id</th><th>Role</th><th>Salary</th><th>Date of Birth</th><th></th>");
		out.println("</tr>");
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = dao.displayEmployee();
		for(Employee emp : employees) {
			out.println("<tr>");
			out.println("<td>"+emp.getEmpId()+"</td>");
			out.println("<td>"+emp.getEmpName()+"</td>");
			out.println("<td>"+emp.getGender()+"</td>");
			out.println("<td>"+emp.getDeptId()+"</td>");
			out.println("<td>"+emp.getRole()+"</td>");
			out.println("<td>"+emp.getSalary()+"</td>");
			out.println("<td>"+emp.getDob()+"</td>");
			out.println("<td><a class='btn btn-primary' href=update?empId="+emp.getEmpId()+">Edit</a> <a class='btn btn-danger'href=delete?empId="+emp.getEmpId()+">Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
