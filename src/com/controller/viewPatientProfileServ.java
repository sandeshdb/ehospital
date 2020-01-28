package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Pdisease;
import com.pojo.Report;

/**
 * Servlet implementation class viewPatientProfileServ
 */
@WebServlet("/viewPatientProfileServ")
public class viewPatientProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Report r = new Report();
	BLManager blm = new BLManager();
	Pdisease pd=new Pdisease();

	// History h=new History();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<Pdisease> pd=blm.searchByPidInPdisease(pid);
		
		if(pd.isEmpty()==true){
			
			response.sendRedirect("RecordNotFound.jsp");
			
		}
		else{
		HttpSession session = request.getSession();
	
		session.setAttribute("pd",pd.get(0).getPregister().getPid());
		
		response.sendRedirect("viewPatientProfile.jsp");}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
	}

}
