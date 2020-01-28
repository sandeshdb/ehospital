<!DOCTYPE html>
<%@page import="com.pojo.Pdisease"%>
<%@page import="com.pojo.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.model.BLManager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Star Admin Free Bootstrap-4 Admin Dashboard Template</title>
<!-- plugins:css -->
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
<style type="text/css">
body {
	color: #212529;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol";
	font-size: 0.875rem;
	font-weight: 400;
	line-height: 1.5;
}

table {
	width: 80%;
	border: 1px solid rgba(0, 0, 0, 0.125);
	border-collapse: collapse;
	table-layout: fixed;
}

th, td {
	padding: 10px;
	text-align: left;
	width: 50%;
	padding-left: 10px;
}
</style>
</head>
<%

HttpSession ss=request.getSession(false);
String name=(String )ss.getAttribute("admin");
%>
<%
  
  
  BLManager blm=new BLManager();
  int pdid=(int)session.getAttribute("pd");
  Pdisease pd=blm.searchByPatientDiseaseId(pdid);
  request.setAttribute("pd",pd);
  
  %>

<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->
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
									<h6 class="preview-subject ellipsis font-weight-medium text-dark">
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
							class="profile-text">Hello, <%=name%>!
						</span> <img class="img-xs rounded-circle" src="images1/faces/face1.jpg"
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
			<!-- partial:../../partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item nav-profile">
						<div class="nav-link">
							<div class="user-wrapper">
								<div class="profile-image">
									<img src="images1/faces/face1.jpg" alt="profile image">
								</div>


								<div class="text-wrapper">
									<p class="profile-name">
										Hello
										<%=name %></p>
									<div>
										<small class="designation text-muted">Admin</small> <span
											class="status-indicator online"></span>
									</div>
								</div>
							</div>


						</div>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="AdminDashboard.jsp"> <i
							class="menu-icon mdi mdi-television"></i> <span
							class="menu-title">Dashboard</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#uii-basic" aria-expanded="false"
						aria-controls="uii-basic"> <i
							class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Department</span> <i class="menu-arrow"></i>
					</a>
						<div class="collapse" id="uii-basic">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="AddDepartment.jsp">Add Department</a></li>
								<li class="nav-item"><a class="nav-link"
									href="viewDepartment.jsp">View Department</a></li>
							</ul>
						</div></li>

					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#ui-basic" aria-expanded="false"
						aria-controls="ui-basic"> <i
							class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Doctor</span> <i class="menu-arrow"></i>
					</a>
						<div class="collapse" id="ui-basic">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="AddDoctor.jsp">Add Doctor</a></li>
								<li class="nav-item"><a class="nav-link"
									href="viewDoctor.jsp">View Doctor</a></li>

							</ul>
						</div></li>
					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#ui-basic1" aria-expanded="false"
						aria-controls="ui-basic1"> <i
							class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Patient</span> <i class="menu-arrow"></i>
					</a>
						<div class="collapse" id="ui-basic1">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="AddPatient.jsp">Add Patient</a></li>
								<li class="nav-item"><a class="nav-link"
									href="viewPatient.jsp">View Patient</a></li>

							</ul>
						</div></li>
					<li class="nav-item"><a class="nav-link"
						href="Appointment.jsp"> <i
							class="menu-icon mdi mdi-television"></i> <span
							class="menu-title">Appointment</span>
					</a></li>
					 <li class="nav-item">
          <a class="nav-link" data-toggle="collapse" href="#ui-basic2" aria-expanded="false"
						aria-controls="ui-basic2"> 
						<i class="menu-icon mdi mdi-content-copy"></i> <span
							class="menu-title">Billing</span> <i class="menu-arrow"></i>
					</a>
						<div class="collapse" id="ui-basic2">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item">
								<a class="nav-link"	href="Billing.jsp">Add Billing</a>
									</li>
								<li class="nav-item">
								<a class="nav-link"	href="viewBilling.jsp">View Billing</a>
									</li>

							</ul>
						</div></li>
				</ul>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Patient Information</h4>
									<table border="">
										<tr>
											<th class="font-weight-medium">Patient Name</th>
											<td>${pd.pregister.pname}</td>
										</tr>
										<tr>
											<th class="font-weight-medium">Disease Name</th>
											<td>${pd.diseaseName}</td>
										</tr>
										<tr>
											<th class="font-weight-medium">Admission Date.</th>
											<td>${pd.admissionDate}</td>
										</tr>
										

									</table>
								</div>
								<div class="row">
									<div class="col-12 grid-margin">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">Billing Details</h4>
												<form class="form-sample" method="post"
													action="AddBillingServlet">
													<div class="row">

														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">General</label>
																<div class="col-sm-9">
																	<input type="text" id="general" name="general"
																		class="form-control" placeholder="Per day cost" onkeyup="calculate()" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Days</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control" onkeyup="calculate()" id="gday" name="gday" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">=</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control"  id="gt" name="gt" />
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-7 col-form-label">Special 
																 <input type="radio" name="acnonac" value="Ac" >Ac 
																<input type="radio" name="acnonac" value="Non-Ac">Non-Ac 
																
																</label>
																<div class="col-sm-5">
																	<input type="text" name="special" id="special" onkeyup="calculate()"
																		class="form-control" placeholder="Per day cost" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Days</label>
																<div class="col-sm-9">
																	<input class="form-control" type="text" name="sday" id="sday" onkeyup="calculate()"
																		placeholder="" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">=</label>
																<div class="col-sm-9">
																	<input class="form-control" type="text" name="st" id="st" />
																</div>
															</div>
														</div>
														
													</div>
													
													<div class="row">
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">ICU </label>
																<div class="col-sm-9">
																	<input type="text" id="icu" name="icu" onkeyup="calculate()"
																		class="form-control" placeholder="Per day cost" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Days</label>
																<div class="col-sm-9">
																	<input type="text" name="iday" id="iday" onkeyup="calculate()" class="form-control" />
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">=</label>
																<div class="col-sm-9">
																	<input type="text" name="it" id="it"  class="form-control" />
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Other Charges
																	</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control" id="other" onkeyup="calculate()" name="other" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">reason
																	</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control"  name="reason"  />
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Operation
																	Theater</label>
																<div class="col-sm-9">
																	<input type="text" id="ot" onkeyup="calculate()" name="ot" class="form-control" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Consulting
																	Fees </label>
																<div class="col-sm-9">
																	<input type="text" class="form-control" id="confee" onkeyup="calculate()" name="confee" />
																</div>
															</div>
														</div>

													</div>
														<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Lab Test
																	Charges</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control" onkeyup="calculate()" id="lab" name="lab" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Medical Charges</label>
																<div class="col-sm-9">
																	<input type="text" class="form-control" id="medical" onkeyup="calculate()" name="medical" />
																</div>
															</div>
														</div>
													</div>
															
													
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Payment mode</label>
																<div class="col-sm-9">
																	<select name="payment" class="form-control">
																		<option>Card</option>
																		<option>Cash</option>
      																</select>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Total Amount</label>
																<div class="col-sm-9">
																	<input type="text"  name="amt" id="amt" class="form-control">
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-4" style="visibility: hidden;">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">pdid</label>
																<div class="col-sm-9">
																	<input type="text" value="${pd.pdid}" name="pdid">

																</div>
															</div>
														</div>
														<div class="col-md-4" style="visibility: hidden;">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">pid</label>
																<div class="col-sm-9">
																	<input type="text" value="${pd.pregister.pid}" name="pid">

																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group row">
																<div class="col-sm-9">
																	<input type="submit" value="Save">
																</div>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<footer class="footer">
					<div class="container-fluid clearfix">
						<span
							class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright
							� 2018 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>.
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
	<script src="js1/off-canvas.js"></script>
	<script src="js1/misc.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<!-- End custom js for this page-->
	<script type="text/javascript">
	
	function calculate(){
		var general=parseInt(document.getElementById("general").value);
		var gday=parseInt(document.getElementById("gday").value);
		var tg=general*gday;
		document.getElementById("gt").value=tg;
		
		var special=parseInt(document.getElementById("special").value);
		var sday=parseInt(document.getElementById("sday").value);
		var ts=special*sday;
		document.getElementById("st").value=ts;
		
			
		var icu=parseInt(document.getElementById("icu").value);
		var iday=parseInt(document.getElementById("iday").value);
		var it=icu*iday;
		document.getElementById("it").value=it;
		

		var lab=parseInt(document.getElementById("lab").value);
		var other=parseInt(document.getElementById("other").value);
		var ot=	parseInt(document.getElementById("ot").value);
		var confee=parseInt(document.getElementById("confee").value);
		var medical=parseInt(document.getElementById("medical").value);	
		
		var amt=tg+ts+it+lab+other+ot+confee+medical;
		document.getElementById("amt").value=amt;    
		


		
		
	}
	
	
	</script>
</body>

</html>