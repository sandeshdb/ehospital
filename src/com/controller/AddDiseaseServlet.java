package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.model.BLManager;
import com.pojo.Pregister;

@WebServlet("/AddDiseaseServlet")
public class AddDiseaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Pregister pr=new Pregister();  
 BLManager blm=new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int pid=Integer.parseInt(request.getParameter("pid"));
		pr=blm.searchByPatientId(pid);
		HttpSession patient=request.getSession();
		patient.setAttribute("pr",pr);
		response.sendRedirect("AddPatintDisease.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
