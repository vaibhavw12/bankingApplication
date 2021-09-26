<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.vaibhav.info.BalanceInfo" %>
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

 String name =(String) session.getAttribute("name");
 String pan_num = (String) session.getAttribute("unique"); 
 %>
 <form action="BalanceInfo" method="post">
 enter amount to withdraw : <br>
 <input type="number" name="balance"/><br>
 <input type="submit" value="withdraw"/>
</form>
</body>
</html>