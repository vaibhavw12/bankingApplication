<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('website-design-banner.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
/* Style the links inside the pill navigation menu */
.pill-nav a {
  display: inline-block;
  color: black;
  text-align: center;
  padding: 14px;
  text-decoration: none;
  font-size: 17px;
  border-radius: 5px;
  
}

/* Change the color of links on mouse-over */
.pill-nav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.pill-nav a.active {
  background-color: dodgerblue;
  color: white;
}
.vertical-menu {
  width: 200px; /* Set a width if you like */

  
}

.vertical-menu a {
  background-color: #eee; /* Grey background color */
  color: black; /* Black text color */
  display: block; /* Make the links appear below each other */
  padding: 12px; /* Add some padding */
  text-decoration: none; /* Remove underline from links */
}

.vertical-menu a:hover {
  background-color: #ccc; /* Dark grey background on mouse-over */
}

.vertical-menu a.active {
  background-color: #04AA6D; /* Add a green color to the "active/current" link */
  color: white;
}

</style>
<body>
 <%

 if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
 	response.sendRedirect("index.html");
 }

 String name =(String) session.getAttribute("name");
// out.print("Login Successfull<br>");
// out.print("welcome : "+name);
 %>
 <div class="pill-nav">
  <a class="active" href="#home">Home</a>
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>
<div class="vertical-menu">
  <a href="#" class="active">Dashboard</a>
  <a href="withdraw.jsp">Withdraw Amount</a>
  <a href="deposit.jsp">Deposit Amount</a>
  <a href="balance.jsp">Check Balance</a>
  <a href="viewdetails.jsp">My Profile</a>
  <a href="editdetails.jsp">Edit Details</a>
  <a href="logout.jsp">Logout</a>
</div>

</body>
</html>