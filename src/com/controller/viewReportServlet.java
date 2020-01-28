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
 * Servlet implementation class viewReportServlet
 */
@WebServlet("/viewReportServlet")
public class viewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

BLManager blm=new BLManager();
Pdisease pd=new Pdisease();
Report r=new Report();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pdid=Integer.parseInt(request.getParameter("pdid"));
	List<Report> r=blm.searchByPdiInReport(pdid);
	HttpSession session=request.getSession();
	session.setAttribute("r",r.get(0).getPdisease().getPdid());
	response.sendRedirect("PViewReport.jsp");
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
