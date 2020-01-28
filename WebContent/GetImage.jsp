<%@page import="java.io.OutputStream"%>
<%@page import="com.pojo.Doctor"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 

Doctor d=new Doctor();
BLManager blm=new BLManager();
int id=Integer.parseInt(request.getParameter("DId"));
d=blm.searchByDoctorId(id);
response.setContentType("image/jpg");
byte[] imga=d.getPic();
OutputStream os=response.getOutputStream();
os.write(imga);
os.flush();
os.close();
response.sendRedirect("viewDetailDoctorProfile.jsp");




%>
</body>
</html>