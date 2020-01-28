package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Doctor;

/**
 * Servlet implementation class viewDetailDoctorProfileServ
 */
@WebServlet("/viewDetailDoctorProfileServ")
public class viewDetailDoctorProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Doctor d = new Doctor();
	BLManager blm = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("DId"));
		d = blm.searchByDoctorId(id);
		HttpSession session = request.getSession();
		session.setAttribute("dr", d.getDId());
		response.sendRedirect("viewDetailDoctorProfile.jsp");
		
	}

}
