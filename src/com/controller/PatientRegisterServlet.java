package com.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.model.RandomNumber;
import com.pojo.Pregister;


@WebServlet("/PatientRegisterServlet")
public class PatientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Pregister pr = new Pregister();
	BLManager blm = new BLManager();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String add = request.getParameter("add");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		long no = Long.parseLong(request.getParameter("no"));
		System.out.println("****Mob no in long :"+no);
		int otp = RandomNumber.PrintRandomNumber();
		System.out.println("Random Number OTP is :" + otp);
		pr.setOtp(otp);
		pr.setPname(name);
		pr.setPemailid(email);
		pr.setPaddress(add);
		pr.setPassword(pass);
		pr.setPmobileNumber(no);
		pr.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date udate = sdf.parse(dob);
			long ms = udate.getTime();
			java.sql.Date sdate = new java.sql.Date(ms);
			pr.setDob(sdate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		int pid = blm.savePatientRecord(pr);
		pr = blm.searchByPatientId(pid);
	
		int otp1 = 1234;
		String mob = "+91"+String.valueOf(no);
		String authkey = "270652ALSvD6olsfdL5ca45778";
		String message = "Hello "+name+" Thanks for registed on DRCARE. Your OTP is "+otp;
		
		URL myURL = null;
		URLConnection urlConnection = null;
		BufferedReader reader = null;
		// encoding message
	String encoded_message=URLEncoder.encode(message);
		// Send SMS API
		String mainURL = "http://control.msg91.com/api/sendotp.php?authkey=270652ALSvD6olsfdL5ca45778&message="+message+"&mobile="+no+"&sender=DrCare&otp="+otp;
		StringBuilder sb = new StringBuilder(mainURL);
		mainURL = sb.toString();
		try {
			myURL = new URL(mainURL);
			urlConnection = myURL.openConnection();
			urlConnection.connect();
			reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String response1;
			while ((response1 = reader.readLine()) != null)
				
				System.out.println(response1);
				reader.close();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("pr", pr.getPid());
		response.sendRedirect("OTP1.jsp");

	}

}
