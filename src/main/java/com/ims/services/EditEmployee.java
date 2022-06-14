package com.ims.services;

import java.io.IOException;
import java.io.PrintWriter;

import com.ems.dao.EmployeeDAO;
import com.ems.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("empId"));
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.displayEmployee(id);
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "   <head>\r\n"
				+ "	<meta charset=\"ISO-8859-1\">\r\n"
				+ "	<title>Insert title here</title>\r\n"
				+ "	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "	<div class=\"container\">\r\n"
				+ "	   <form method=\"Post\" action=\"updateEmp?id="+emp.getEmpId()+"\">\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee Id</label>\r\n"
				+ "	          <input type='number' name='empid' placeholder='Enter employee ID' class='form-control' disabled value='"+emp.getEmpId()+"' />\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee Name</label>\r\n"
				+ "	          <input type=\"text\" name=\"empname\" placeholder=\"Enter employee Name\" class=\"form-control\" value="+emp.getEmpName()+" />\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee's Role</label>\r\n"
				+ "	          <input type=\"text\" name=\"role\" placeholder=\"Enter employee Role\" class=\"form-control\" disabled value="+emp.getRole()+" />\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Department Id</label>\r\n"
				+ "    		  <input type=\"number\" placeholder=\"Department Id\" name=\"deptid\" class=\"form-control\" disabled value="+emp.getDeptId()+" />\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee Salary</label>\r\n"
				+ "	          <input type=\"number\" name=\"salary\" placeholder=\"Enter employee salary\" class=\"form-control\" disabled value="+emp.getSalary()+" />\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee's Gender</label>\r\n"
				+ "	          <select name=\"gender\" class=\"form-control\">\r\n"
				+ "	              <option value=\"\">Select gender</option>\r\n"
				+ "	              <option value=\"male\">Male</option>\r\n"
				+ "	              <option value=\"female\">Female</option>\r\n"
				+ "	              <option value=\"others\">Others</option>\r\n"
				+ "	          </select>\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"mb-3\">\r\n"
				+ "	          <label>Employee DOB</label>\r\n"
				+ "	          <input type=\"date\" name=\"dob\" class=\"form-control\"/>\r\n"
				+ "	      </div>\r\n"
				+ "	      <div class=\"text-end\">\r\n"
				+ "	          <button type=\"submit\" class=\"btn btn-success\">Update</button>\r\n"
				+ "	      </div>\r\n"
				+ "	   </form>\r\n"
				+ "	   </div>\r\n"
				+ "	</body>\r\n"
				+ "	</html>");
		
	}
}
