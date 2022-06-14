package com.ims.services;

import java.io.IOException;
import java.sql.Date;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveEmpDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("empid"));
		String name = req.getParameter("empname");
		String role = req.getParameter("role");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		int deptId = Integer.parseInt(req.getParameter("deptid"));
		double salary = Double.parseDouble(req.getParameter("salary"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		
		Employee emp = new Employee();
		emp.setDeptId(deptId);
		emp.setDob(dob);
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setGender(gender);
		emp.setPass(pwd);
		emp.setRole(role);
		emp.setSalary(salary);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.registerEmployee(emp);
		
		resp.sendRedirect("displayAll");
	}
}
