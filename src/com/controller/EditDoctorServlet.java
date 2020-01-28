package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.pojo.Department;
import com.pojo.Doctor;

@MultipartConfig(maxFileSize = 169999999)
@WebServlet("/EditDoctorServlet")
public class EditDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Doctor d = new Doctor();
	Doctor d1 = new Doctor();
	Department dp = new Department();
	BLManager blm = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("DId"));
		d = blm.searchByDoctorId(id);
		HttpSession sess3 = request.getSession();
		sess3.setAttribute("dr", d);
		response.sendRedirect("EditDoctoInfo.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String dname = request.getParameter("name");
		// System.out.println("Dr. name is " + dname);
		String Qualification = request.getParameter("Qualification");
		String emailid = request.getParameter("emailid");
		String mob_string = request.getParameter("mobno");
		// System.out.print(" mobile No is :" + mob_string);
		long mobile = Long.parseLong(mob_string);
		String address = request.getParameter("address");
		String specialist = request.getParameter("specialist");
		String exp_string = request.getParameter("expe");
		// System.out.println("My Expiernce is " + exp_string);
		int Experience = Integer.parseInt(exp_string);
		String joinDate = request.getParameter("jdate");
		// System.out.println("Date is " + joinDate);
		String uid = request.getParameter("duid");
		String inTime = request.getParameter("intime");
		String outTime = request.getParameter("outtime");
		d = blm.searchByDrUniqID(uid);
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
			  SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			  Date it=sdf.parse(inTime);
			  long ms=it.getTime();
			  java.sql.Date sITime= new java.sql.Date(ms);
			  d.setInTime(sITime);
			  Date ot=sdf.parse(outTime);
			  long ms1=ot.getTime();
			  java.sql.Date sOTime=new java.sql.Date(ms);
			  d.setOutTime(sOTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		String[] days = request.getParameterValues("days");
		String list = Arrays.toString(days);
		d.setDay(list);

		String uid1 = d.getDuniqid();
		d.setDuniqid(uid1);
		byte[] b = d.getPic();
		d.setPic(b);

		blm.updateDoctorRecord(d);
		response.sendRedirect("viewDoctor.jsp");

	}

}
