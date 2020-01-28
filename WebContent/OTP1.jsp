<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@page import="com.pojo.Pregister"%>
<%@page import="com.model.BLManager"%>
<!------ Include the above in your HEAD tag ---------->
<%

BLManager blm=new BLManager();
Pregister pr=new Pregister();
int pid=(int)session.getAttribute("pr");
pr=blm.searchByPatientId(pid);
request.setAttribute("pr",pr);



%>
<head>
<title>OTP Verification</title>
</head>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <h1>Dr.care</h1>
      <p>OTP has been sent to your mobile number ${pr.pmobileNumber}</p>
    </div>

    <!-- Login Form -->
    <form action="otpVerifyServlet" method="post">
      <input type="text" id="otp" class="fadeIn second" name="otp" placeholder="Enter Your OTP">
      <p style="visibility: hidden;"><input type="text" name="pid" value="${pr.pid}"></p>
<!--       <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password"> -->
      <input type="submit" class="fadeIn fourth" value="Verify">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
     <p>Not recived yet?</p><a class="underlineHover" href="ResendOtpServlet?pid=${pr.pid}">Resend OTP</a>
    </div>

  </div>
</div>
<style>
/* BASIC */

html {
  background-color: #56baed;
}

body {
  font-family: "Poppins", sans-serif;
  height: 100vh;
}


h1 {
  text-align: center;
  font-size: 25px;
  font-weight: 600;
  display:inline-block;
  margin: 40px 8px 10px 8px; 

  font-weight: bolder;
}

/* h2 { */
/*   text-align: center; */
/*   font-size: 16px; */
/*   font-weight: 600; */
/*   text-transform: uppercase; */
/*   display:inline-block; */
/*   margin: 40px 8px 10px 8px;  */
/*   color: #cccccc; */
/* } */



/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}



/* FORM TYPOGRAPHY*/

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 60px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 10px 10px 10px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
  background-color: #39ace7;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

#otp{
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 0.6px;
  width: 80%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

#otp:focus {
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}







@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}



.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
/* .underlineHover:after { */
/*   display: block; */
/*   left: 0; */
/*   bottom: -10px; */
/*   width: 0; */
/*   height: 2px; */
/*   background-color: #56baed; */
/*   content: ""; */
/*   transition: width 0.2s; */
/* } */

/* .underlineHover:hover { */
/*   color: #0d0d0d; */
/* } */

/* .underlineHover:hover:after{ */
/*   width: 100%; */
/* } */

h1{
    color:#60a0ff;
}

/* OTHERS */

*:focus {
    outline: none;
} 




</style>