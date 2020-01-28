package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Doctor;

/**
 * Servlet implementation class DeleteDoctorRecordServlet
 */
@WebServlet("/DeleteDoctorRecordServlet")
public class DeleteDoctorRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Doctor d=new Doctor();
       BLManager blm=new BLManager();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("DId"));
	d=blm.searchByDoctorId(id);
	System.out.print("Dr id :"+ d.getDId());
	blm.DeleteDoctorRecord(d);
	response.sendRedirect("viewDoctor.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
