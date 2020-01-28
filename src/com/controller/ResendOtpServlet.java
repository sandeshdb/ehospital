package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.model.RandomNumber;
import com.pojo.Pregister;

/**
 * Servlet implementation class ResendOtpServlet
 */
@WebServlet("/ResendOtpServlet")
public class ResendOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
BLManager blm=new BLManager();
Pregister pr=new Pregister();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pid=Integer.parseInt(request.getParameter("pid"));
	pr=blm.searchByPatientId(pid);
	int otp = RandomNumber.PrintRandomNumber();
	pr.setOtp(otp);
	blm.UpdatePatientRecord(pr);
	String authkey = "270652ALSvD6olsfdL5ca45778";
	long no=pr.getPmobileNumber();
	String name=pr.getPname();
	String message = "Hello "+name+" Thanks for registed on DRCARE. Your OTP is "+otp;
	String sender="DrCare";
	URL myURL=null;
	URLConnection urlConnection=null;
	BufferedReader reader=null;
    String 	mainURL="http://control.msg91.com/api/sendotp.php?authkey="+authkey+"&message="+message+"&mobile="+no+"&sender="+sender+"&otp="+otp;
		StringBuilder sb=new StringBuilder(mainURL);
		mainURL=sb.toString();
		try{
		
			myURL =new URL(mainURL);
			urlConnection=myURL.openConnection();
			urlConnection.connect();
			reader =new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String res;
			while((res=reader.readLine())!=null){
				
				System.out.println(res);
				
			}
			
			response.sendRedirect("OTP1.jsp");
			
	}catch(Exception e){e.printStackTrace();}

}}
