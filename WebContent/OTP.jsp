<%@page import="com.pojo.Pregister"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTP verify</title>
<style type="text/css">

.otp{

background:#fff;
width: 500px;
height: 150px;
border-radius:10px 10px 10px 10px;
margin: auto;
top:50%;

}



</style>
</head>
<body>
<%

BLManager blm=new BLManager();
Pregister pr=new Pregister();
int pid=(int)session.getAttribute("pr");
pr=blm.searchByPatientId(pid);
request.setAttribute("pr",pr);



%>
<div class="otp">
<form action="otpVerifyServlet" method="post">
<p style="visibility: hidden;"><input type="text" name="pid" value="${pr.pid}"></p>
<p>OTP sent to your mobile number ${pr.pmobileNumber}</p>
<br>
<input type="text" name="otp" >
<br>
<input type="submit" value="Verify">
</form>
</div>

</body>
</html>