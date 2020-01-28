<%@page import="java.io.OutputStream"%>
<%@page import="com.pojo.Report"%>
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
BLManager blm=new BLManager();
Report r=new Report();
int rid=Integer.parseInt(request.getParameter("rid"));
r=blm.searchByReportId(rid);
response.setContentType("image/jpg");
byte[] img=r.getRphoto();
OutputStream os=response.getOutputStream();
os.write(img);
os.flush();
os.close();
response.sendRedirect("ViewReport.jsp");
%>
</body>
</html>