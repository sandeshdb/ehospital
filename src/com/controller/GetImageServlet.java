package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Doctor;



@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Doctor d = new Doctor();
	BLManager blm = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("image/jpg");
		int did = Integer.parseInt(request.getParameter("DId"));
		
		d = blm.searchByDoctorId(did);
		byte[] image = d.getPic();
		OutputStream os = response.getOutputStream();
		os.write(image);
		os.flush();
		os.close();
		response.sendRedirect("viewDetailDoctorProfile.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
	}

}
