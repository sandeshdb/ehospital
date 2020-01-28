
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
import com.pojo.Report;

/**
 * Servlet implementation class ReportImageServlet
 */
@WebServlet("/ReportImageServlet")
public class ReportImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Report r=new Report();
	
	BLManager blm=new BLManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 int pdid=Integer.parseInt(request.getParameter("pdid"));
 List<Report> r=blm.searchByPdiInReport(pdid);
 System.out.println("pdid :"+pdid);
 HttpSession session=request.getSession();
 System.out.println("heloo :"+r.get(0).getPdisease().getPdid());
 session.setAttribute("r",r.get(0).getPdisease().getPdid());
 response.sendRedirect("ViewReport.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
