<%@page import="com.pojo.Pregister"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>

<%
BLManager blm=new BLManager();
Pregister pr=new Pregister();
String op=request.getParameter("otp");


int otp=Integer.parseInt(op);
//System.out.println("OTP in int: "+otp);
int pid=Integer.parseInt(request.getParameter("pid"));
pr=blm.searchByPatientId(pid);
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ehospital","root","");  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from pregister where pid="+pid); 
	if(rs.next()){
		
		int otp1=rs.getInt("otp");
	System.out.print(otp1);
		
		
		if(otp1==otp){
			//System.out.println("servlet pid "+pr.getPid());
			 session =request.getSession();
			session.setAttribute("pr",pr.getPid());
			response.sendRedirect("PatientDashboard.jsp");
			System.out.print("OKay");
			
		}else{
			out.print("sorry incorect OTP! <img src='checked.gif'/>");  
			System.out.print("sorry");
		}
		
	
	}else{
		System.out.println("Record Not Found...");
		
	}
	
}catch(Exception e){
e.printStackTrace();
}





%>

