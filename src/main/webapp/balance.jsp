<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vaibhav.controller.LoginServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
balance =
<%

if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
	response.sendRedirect("index.html");
}

out.print(LoginServlet.checkBalance());
%>
</body>
</html>