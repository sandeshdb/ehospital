<!DOCTYPE html>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.ibm.icu.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.pojo.Department"%>
<%@page import="com.pojo.Appo"%>
<%@page import="com.pojo.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.Pregister"%>
<%@page import="com.model.BLManager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<%
BLManager blm=new BLManager();
Appo ap=new Appo();
int apid=(int)session.getAttribute("apid");
ap=blm.searchByApidInAppo(apid);
int drid=ap.getDoctor().getDId();
Doctor dr=new Doctor();
dr=blm.searchByDoctorId(drid);
Date StartTime=dr.getInTime();
System.out.print("Date Time :"+StartTime);
Date EndTime=dr.getOutTime();
SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
SimpleDateFormat df = new SimpleDateFormat("hh:mm a");

String st1=sdf.format(StartTime);
String et1=df.format(EndTime);
String st2=st1.replace(":00","");
String et2=et1.replace(":00","");
String st3=st2.replace(":",".");
System.out.print("String float: "+st3);
String et3=et2.replace(":",".");
System.out.println("String float: "+et3);
float st=Float.parseFloat(st3);
float et=Float.parseFloat(et3);

System.out.println("float starttime: "+st);
System.out.println("float end time: "+et);

Calendar gc=new GregorianCalendar();
Date d=sdf.parse(st1);
System.out.print(df.format(d));
for(float i=st;i<et;i=i+0.30f){
	gc.setTime(d);
	gc.add(Calendar.MINUTE,15);
	Date d2=gc.getTime();
	d=d2;
	System.out.print(df.format(d2));
	
	
	
}



%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Star Admin Free Bootstrap Admin Dashboard Template</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="css1/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="images1/favicon.png" />
</head>

<body>

	
	
	<% 
	Appo ap1=new Appo();
	 BLManager blm1=new BLManager();
	 int apid1=(int)session.getAttribute("apid");
	 ap=blm.searchByApidInAppo(apid1);
	 request.setAttribute("ap",ap);
	 Date inTime=ap.getDoctor().getInTime();
	 Date outTime=ap.getDoctor().getOutTime();
	 Department dept=ap.getDoctor().getDepartment();
	%>
	
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav
			class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
				<a class="navbar-brand brand-logo" href="index.html"> <img
					src="images1/logo.svg" alt="logo" />
				</a> <a class="navbar-brand brand-logo-mini" href="index.html"> <img
					src="images1/logo-mini.svg" alt="logo" />
				</a>
			</div>
			<div class="navbar-menu-wrapper d-flex align-items-center">

				<ul class="navbar-nav navbar-nav-right">
					<li class="nav-item dropdown"><a
						class="nav-link count-indicator dropdown-toggle"
						id="messageDropdown" href="#" data-toggle="dropdown"
						aria-expanded="false"> <i class="mdi mdi-file-document-box"></i>
							<span class="count">7</span>
					</a>
						<div
							class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
							aria-labelledby="messageDropdown">
							<div class="dropdown-item">
								<p class="mb-0 font-weight-normal float-left">You have 7
									unread mails</p>
								<span class="badge badge-info badge-pill float-right">View
									all</span>
							</div>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="images1/faces/face4.jpg" alt="image"
										class="profile-pic">
								</div>
								<div class="preview-item-content flex-grow">
									<h6
										class="preview-subject ellipsis font-weight-medium text-dark">
										David Grey <span
											class="float-right font-weight-light small-text">1
											Minutes ago</span>
									</h6>
									<p class="font-weight-light small-text">The meeting is
										cancelled</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="images1/faces/face2.jpg" alt="image"
										class="profile-pic">
								</div>
								<div class="preview-item-content flex-grow">
									<h6
										class="preview-subject ellipsis font-weight-medium text-dark">
										Tim Cook <span
											class="float-right font-weight-light small-text">15
											Minutes ago</span>
									</h6>
									<p class="font-weight-light small-text">New product launch
									</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="images/faces/face3.jpg" alt="image"
										class="profile-pic">
								</div>
								<div class="preview-item-content flex-grow">
									<h6
										class="preview-subject ellipsis font-weight-medium text-dark">
										Johnson <span class="float-right font-weight-light small-text">18
											Minutes ago</span>
									</h6>
									<p class="font-weight-light small-text">Upcoming board
										meeting</p>
								</div>
							</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link count-indicator dropdown-toggle"
						id="notificationDropdown" href="#" data-toggle="dropdown"> <i
							class="mdi mdi-bell"></i> <span class="count">4</span>
					</a>
						<div
							class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
							aria-labelledby="notificationDropdown">
							<a class="dropdown-item">
								<p class="mb-0 font-weight-normal float-left">You have 4 new
									notifications</p> <span
								class="badge badge-pill badge-warning float-right">View
									all</span>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-success">
										<i class="mdi mdi-alert-circle-outline mx-0"></i>
									</div>
								</div>
								<div class="preview-item-content">
									<h6 class="preview-subject font-weight-medium text-dark">Application
										Error</h6>
									<p class="font-weight-light small-text">Just now</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-warning">
										<i class="mdi mdi-comment-text-outline mx-0"></i>
									</div>
								</div>
								<div class="preview-item-content">
									<h6 class="preview-subject font-weight-medium text-dark">Settings</h6>
									<p class="font-weight-light small-text">Private message</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-info">
										<i class="mdi mdi-email-outline mx-0"></i>
									</div>
								</div>
								<div class="preview-item-content">
									<h6 class="preview-subject font-weight-medium text-dark">New
										user registration</h6>
									<p class="font-weight-light small-text">2 days ago</p>
								</div>
							</a>
						</div></li>

					<li class="nav-item dropdown d-none d-xl-inline-block"><a
						class="nav-link dropdown-toggle" id="UserDropdown" href="#"
						data-toggle="dropdown" aria-expanded="false"> <span
							class="profile-text">Hello, ${ap.pregister.pname } ! </span> <img
							class="img-xs rounded-circle" src="images1/faces/face1.jpg"
							alt="Profile image">
					</a>
						<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
							aria-labelledby="UserDropdown">
							<a class="dropdown-item p-0">
								<div class="d-flex border-bottom">
									<div
										class="py-3 px-4 d-flex align-items-center justify-content-center">
										<i class="mdi mdi-bookmark-plus-outline mr-0 text-gray"></i>
									</div>
									<div
										class="py-3 px-4 d-flex align-items-center justify-content-center border-left border-right">
										<i class="mdi mdi-account-outline mr-0 text-gray"></i>
									</div>
									<div
										class="py-3 px-4 d-flex align-items-center justify-content-center">
										<i class="mdi mdi-alarm-check mr-0 text-gray"></i>
									</div>
								</div>
							</a> <a class="dropdown-item mt-2"> Manage Accounts </a> <a
								class="dropdown-item"> Change Password </a> <a
								class="dropdown-item"> Check Inbox </a> <a class="dropdown-item">
								Sign Out </a>
						</div></li>
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="mdi mdi-menu"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item nav-profile">
						<div class="nav-link">
							<div class="user-wrapper">
								<div class="profile-image">
									<img src="images1/faces/face1.jpg" alt="profile image">
								</div>



								<div class="text-wrapper">
									<p class="profile-name">Hello ${ap.pregister.pname } </p>
									<div>
										<small class="designation text-muted">Admin</small> <span
											class="status-indicator online"></span>
									</div>
								</div>
							</div>


						</div>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="PatientDashboard.jsp"> <i
							class="menu-icon mdi mdi-television"></i> <span
							class="menu-title">Dashboard</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="PatientProfile.jsp"> <i
							class="menu-icon mdi mdi-content-copy "></i> <span
							class="menu-title">Your Profile</span>
					</a></li>
					<li class="nav-item"><a href="UpdatePatienProfile.jsp"
						class="nav-link"> <i class="menu-icon mdi mdi-content-copy"></i>
							<span class="menu-title">Update Profile</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="PDiseaseDetaiil.jsp"> <i
							class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Disease Details</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="BillingDetails.jsp"> <i
							class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Billing Details</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="Appointment.jsp"> <i
							class="menu-icon mdi mdi-television"></i> <span
							class="menu-title">Appointment</span>
					</a></li>

				</ul>
			</nav>
			<!-- partial -->
			
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
								<form action="AppoDrAvailServlet" method="post">
							
										<div class="row">
											<div class="col-md-4">
												
											</div>
											<div class="col-md-8">
												<div class="row">
													<div class="col-md-8">
													<input type="text" name="apid" value="${ap.aid}">
													
													</div>
													<div class="col-md-4">
														<button type="submit" class="btn btn-primary mr-2">Submit</button>

													</div>
												</div>

											</div>


										</div>
										<br>
									<h4 class="card-title">Select Time</h4>
									<div class="table-responsive">
									
										<table class="table table-bordered">
											<thead>
												<tr>
													<th></th>
													<th>Name</th>
													<th>Specialist</th>
													<th>Profile</th>
													
										</tr>
											</thead>
											<tbody>

												<tr>
											     <c:forEach items="${sessionScope.list}" var="l">
											   	   <td><label class="radio-inline"><input type="radio"
															name="drid" value="${l.DId}" required="required"></label> </td>
											   		<td class="font-weight-medium">${l.dname}</td>
											     	<td class="font-weight-medium">${l.department.deptname}</td> 												   
											     	 <td><a href="EditDoctorServlet?DId=${l.DId}">View Profile</a></td>
													</tr>
												   </c:forEach>
											</tbody>
										</table>							
										
									</div>
									
</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<footer class="footer">
					<div class="container-fluid clearfix">
						<span
							class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright
							© 2018 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>.
							All rights reserved.
						</span> <span
							class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted
							& made with <i class="mdi mdi-heart text-danger"></i>
						</span>
					</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->

	<!-- plugins:js -->
	<script src="vendors/js/vendor.bundle.base.js"></script>
	<script src="vendors/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="js/off-canvas.js"></script>
	<script src="js/misc.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="js/dashboard.js"></script>
	<!-- End custom js for this page-->
</body>

</html>