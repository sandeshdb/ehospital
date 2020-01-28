package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.pojo.Pregister;

/**
 * Servlet implementation class UpdatePatientInfo
 */
@WebServlet("/UpdatePatientInfo")
public class UpdatePatientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Pregister pr = new Pregister();
	BLManager blm = new BLManager();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String pdate = request.getParameter("dob");
		pr=blm.searchByEmailId(emailid);
		
//		HttpSession session=request.getSession();
//		session.setAttribute("pid", pr.getPid());
		System.out.println(name);
		System.out.println(address);
		System.out.println(pdate);
		System.out.println(emailid);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(pdate);

		pr.setPname(name);
		pr.setPaddress(address);
		pr.setPemailid(emailid);
		pr.setPassword(password);
		pr.setGender(gender);
		
		long mobno = Long.parseLong(request.getParameter("mobno"));
		System.out.println(mobno);
		pr.setPmobileNumber(mobno);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date udate = sdf.parse(pdate);
			long ms = udate.getTime();
			java.sql.Date sdate = new java.sql.Date(ms);
			pr.setDob(sdate);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		blm.UpdatePatientRecord(pr);
		
		System.out.println("*****");
		System.out.println("name " + pr.getPname());
		response.sendRedirect("PatientProfile.jsp");

	}
}
