package com.ims.services;

import java.io.IOException;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("empId"));
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.displayEmployee(id);
		dao.deleteEmployee(emp);
		resp.sendRedirect("displayAll");
	}
}
