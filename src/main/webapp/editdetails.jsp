<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vaibhav.controller.LoginServlet,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
	response.sendRedirect("index.html");
}
%>
<form action="EditInfo" method="post">
edit your details :
<br>
<table>
  		<tr>
  		<th>Email</th>
  		<th><input type="text" name="email"></th>
  		</tr>
  		
  		<tr>
  		<th>Password</th>
  		<th><input type="password" name="password"></th>
		</tr>
		
		<tr>
  		<th>Mobile</th>
  		<th><input type="number" name="mobile"></th>
		</tr>
 		
  </table>   <br>
   <input type="submit" value="update">
</form>
</body>
</html>