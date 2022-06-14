package com.ims.services;

import java.io.IOException;
import java.sql.Date;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateEmployee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getParameter("id"));
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("empname");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dob"));
		
		EmployeeDAO dao =new EmployeeDAO();
		Employee emp = dao.displayEmployee(id);
		emp.setEmpId(id);
		emp.setDob(dob);
		emp.setGender(gender);
		emp.setEmpName(name);
		
		dao.updateEmployee(emp);
		resp.sendRedirect("displayAll");
	}
}
