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

@WebServlet("/LoginCheckServlett")
public class LoginCheckServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pregister pr = new Pregister();
	BLManager blm = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println("emailid :"+name);
		System.out.println("pass :"+pass);
		
		if (pass.equals("drcare")) {

			HttpSession ss = request.getSession();
			ss.setAttribute("admin", name);
			response.sendRedirect("AdminDashboard.jsp");

		}

		else {

			pr = blm.serachPatientByEmailId(name);
			String email = pr.getPemailid();
			String psw = pr.getPassword();

			if (pass.equals(psw) && name.equals(email)) {

				HttpSession session = request.getSession();
				session.setAttribute("pr", pr.getPid());
				response.sendRedirect("PatientProfile.jsp");

			} else {

				response.sendRedirect("SignIn.html");
			}
		}

	}

}
