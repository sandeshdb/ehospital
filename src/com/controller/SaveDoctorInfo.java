package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.model.RandomNumber;
import com.pojo.Department;
import com.pojo.Doctor;

@MultipartConfig(maxFileSize = 169999999)
@WebServlet("/SaveDoctorInfo")
public class SaveDoctorInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Department dp = new Department();
	Doctor d = new Doctor();
	BLManager blm = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String dname = request.getParameter("name");
		String Qualification = request.getParameter("Qualification");
		String emailid = request.getParameter("emailid");
		String mob_string = request.getParameter("mobno");
		long mobile = Long.parseLong(mob_string);
		String address = request.getParameter("address");
		String specialist = request.getParameter("specialist");
		String exp_string = request.getParameter("expe");
		int Experience = Integer.parseInt(exp_string);
		String joinDate = request.getParameter("jdate");
		String inTime = request.getParameter("intime");
		String outTime = request.getParameter("outtime");
		Part pi = request.getPart("pic");
		InputStream is = null;
		is = pi.getInputStream();
		byte b[] = org.apache.commons.io.IOUtils.toByteArray(is);
		d.setPic(b);
		d.setDname(dname);
		d.setQulification(Qualification);
		d.setDemailid(emailid);
		d.setAddress(address);
		d.setMobileNumber(mobile);
		d.setSpcialist(specialist);
		d.setExpirence(Experience);

		String department = request.getParameter("department");
		dp = blm.searchByDepartmentName(department);
		d.setDepartment(dp);
		
		int no = RandomNumber.PrintRandomNumber();
		String docname = "DRCARE";
		String duid = docname + no;
		d.setDuniqid(duid);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date udate = sdf.parse(joinDate);
			long ms = udate.getTime();
			java.sql.Date sJoinDate = new java.sql.Date(ms);
			d.setJoiningDate(sJoinDate);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		  
		  try {
			  System.out.println("String time format :"+inTime);
			  SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
			  SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm a");
			  Date it=sdf.parse(inTime);
			  sdf1.format(it);
			  long ms=it.getTime();
			  java.sql.Date sITime= new java.sql.Date(ms);
			  d.setInTime(sITime);
			  Date ot=sdf.parse(outTime);
			  sdf1.format(ot);
			  System.out.println("Out Time :"+ot);
			  long ms1=ot.getTime();
			  java.sql.Date sOTime=new java.sql.Date(ms1);
			  d.setOutTime(sOTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		String[] days = request.getParameterValues("days");
		String list = Arrays.toString(days);
		d.setDay(list);
		blm.saveDoctorRecord(d);
		response.sendRedirect("AddDoctor.jsp");

	}

}
