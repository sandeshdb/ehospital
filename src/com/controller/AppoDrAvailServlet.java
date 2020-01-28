package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Appo;
import com.pojo.Doctor;
import com.pojo.Pregister;

/**
 * Servlet implementation class AppoDrAvailServlet
 */
@WebServlet("/AppoDrAvailServlet")
public class AppoDrAvailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Pregister pr=new Pregister();
   BLManager blm=new BLManager();
   Appo ap=new Appo();
   Doctor dr=new Doctor();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pid=Integer.parseInt(request.getParameter("pid"));
int drid=Integer.parseInt(request.getParameter("drid"));
String d=request.getParameter("date");

pr=blm.searchByPatientId(pid);
dr=blm.searchByDoctorId(drid);
String days=dr.getDay();
String s1=days.replace("["," ");
String s2=s1.replace("]", " ");
String s3=s2.replace(","," ");
String s4=s3.replace("  " ," ");
String[] finalString=s4.split(" ");
for (int i=0;i<finalString.length;i++) {
	
	//System.out.println(finalString[i]);
}
int status=0;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
try {
	java.util.Date ud=sdf.parse(d);
	long ms=ud.getTime();
	java.sql.Date sdate=new java.sql.Date(ms);
	//System.out.println("Input date :"+d);
	
	SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
	String dayName=sdf1.format(ud);
	//System.out.println("parsing date :"+ud+" and day name :"+dayName);
		for(int i=0;i<finalString.length;i++){
		
		if(finalString[i].equals(dayName)){
			
			status=1;
			break;
			
			
		}
			
	}
	if(status==1){
		
	ap.setPregister(pr);
	ap.setDate(sdate);
	ap.setDoctor(dr);
	ap.setDay(dayName);
	int apid=blm.saveAppointment(ap);
	HttpSession session =request.getSession();
	session.setAttribute("apid",apid);
	//System.out.println("Apid :"+apid);
	response.sendRedirect("bookAppointment.jsp");
		
		
	}else{
		
		response.sendRedirect("DrDateNotAvail.jsp");


	}
	
	
	
	
} catch (ParseException e) {

	e.printStackTrace();
}


	
	}

}
