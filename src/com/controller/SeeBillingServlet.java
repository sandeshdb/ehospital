package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Bill;

/**
 * Servlet implementation class SeeBillingServlet
 */
@WebServlet("/SeeBillingServlet")
public class SeeBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
Bill b=new Bill();
BLManager blm=new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdid=Integer.parseInt(request.getParameter("pdid"));
		b=blm.searchByPatientDiseaseIdInBill(pdid);
		HttpSession session=request.getSession();
		session.setAttribute("b",b.getPdisease().getPdid());
		response.sendRedirect("SeeBillingDetails1.jsp");
		
		
		

	}

}
