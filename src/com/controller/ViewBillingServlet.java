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
import com.pojo.Bill;
import com.pojo.Pregister;


@WebServlet("/ViewBillingServlet")
public class ViewBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
BLManager blm=new BLManager();
Pregister pr=new Pregister();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		List<Bill> b=blm.searchByPatientIdInBill(pid);
		
		if(b.isEmpty()==true){
			response.sendRedirect("RecordNotFound.jsp");
			
			
		}else{
		HttpSession session=request.getSession();
		session.setAttribute("b",b.get(0).getPregister().getPid());
		response.sendRedirect("ViewBillingDetails.jsp");
		}
	
	}

}
