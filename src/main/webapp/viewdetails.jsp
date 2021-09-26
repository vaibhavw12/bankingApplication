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
details :
<%

if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
	response.sendRedirect("index.html");
}

ArrayList<String> list=new ArrayList<>(LoginServlet.viewDetails());
//out.print("<br>	id            : "+list.get(0));
out.print("<br>	name          : "+list.get(1));
out.print("<br>	pan_number    : "+list.get(2));
out.print("<br>	Email_id      : "+list.get(3));
out.print("<br>	Mobile_number : "+list.get(4));
out.print("<br>	password      : "+list.get(5));
out.print("<br>	balance       : "+list.get(6));
%>
<br>
 <a href="loginsuccess.jsp">dashboard</a>
</body>
</html>