<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
    history.forward();
</script>
</head>
<body>
<%
if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
	response.sendRedirect("index.html");
}
%>
<form action="Logout" method="post">
 <input type="submit" value="logout">
</form>
</body>
</html>