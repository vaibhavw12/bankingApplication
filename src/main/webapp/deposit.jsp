<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="DepositInfo" method="post">
 enter amount to withdraw : <br>
 <input type="number" name="deposit"/><br>
 <input type="submit" value="deposit"/>
</form>

</body>
</html>