package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Pregister;


@WebServlet("/otpVerifyServlet")
public class otpVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BLManager blm=new BLManager();   
  Pregister pr=new Pregister();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		int pid=Integer.parseInt(request.getParameter("pid"));
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		pr=blm.searchByPatientId(pid);
		int otp=pr.getOtp();
		String otp1=String.valueOf(otp);
		String uotp=request.getParameter("otp");
	
		if(uotp.equals(otp1)){
			
			System.out.println("servlet pid "+pr.getPid());
			HttpSession session =request.getSession();
			session.setAttribute("pr",pr.getPid());
			response.sendRedirect("PatientDashboard.jsp");
			
		}
		else{
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<style>");
			out.println(".m {");        // note leading brace
			  out.println("color:red;");
			  out.println("text-align: center;");
			  out.println("");
			  out.println("padding-top:40px;");
			  
			  out.println("}"); ;
			out.print("</style>");
			out.print("<title>Hello</title>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("<p class='m'>Sorry, Invalid OTP<p>");
		    out.print("</body>");
			out.print("</html>");
	
			
			RequestDispatcher rd=request.getRequestDispatcher("OTP1.jsp");
			rd.include(request, response);
		}
		
	}

}
