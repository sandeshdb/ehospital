package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Department;

/**
 * Servlet implementation class SaveDepartmentInfo
 */
@WebServlet("/SaveDepartmentInfo")
public class SaveDepartmentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
BLManager blm=new BLManager();
Department dept=new Department();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String name=request.getParameter("name");
dept.setDeptname(name);
blm.saveDepartment(dept);
response.sendRedirect("AddDepartment.jsp");
	
	
	}

}
