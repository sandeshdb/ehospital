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


@WebServlet("/SavePatientInfo")
public class SavePatientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager blm=new BLManager();
   Pregister pr=new Pregister();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	String emailid=request.getParameter("emailid");
	String password=request.getParameter("password");
    String	gender=request.getParameter("gender");
   String pdate=request.getParameter("dob");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
try {
	Date udate=sdf.parse(pdate);
	long ms=udate.getTime();
	java.sql.Date sdate=new java.sql.Date(ms);
	pr.setDob(sdate);
	
} catch (ParseException e) {

	e.printStackTrace();
}
long mobno=Long.parseLong(request.getParameter("mobno"));
pr.setPname(name);
pr.setPaddress(address);
pr.setPemailid(emailid);
pr.setPassword(password);
pr.setGender(gender);
pr.setPmobileNumber(mobno);

blm.savePatientRecord(pr);
response.sendRedirect("AddPatient.jsp");
		
		
		
	}

}
