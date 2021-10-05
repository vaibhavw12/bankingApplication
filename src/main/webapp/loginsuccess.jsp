<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div style="padding-left:80px">
 <h3>Login Successfull</h3>
 <h4>welcome : </h4>
 <%

 if((session.getAttribute("name")==null) || session.getAttribute("unique")==null){
 	response.sendRedirect("index.html");
 }

 String name =(String) session.getAttribute("name");
 out.print(name);
 %>
 <br><br>

   <table style="color:green">
  		<tr>
  		<th>1.</th>
  		<th><a href="withdraw.jsp">withdraw amount</a></th>
  		</tr>
  		<tr>
  		<th>2.</th>
  		<th><a href="deposit.jsp">deposit amount</a></th>
  		</tr>
  		<tr>
  		<th>3.</th>
  		<th><input type="button" onclick="window.location.href = 'balance.jsp';" value="balance"/></th>
  		</tr>
  		<tr>
  		<th>4.</th>
  		<th><a href="viewdetails.jsp">view details</a></th>
  		</tr>
  		<tr>
  		<th>5.</th>
  		<th><a href="editdetails.jsp">edit details</a></th>
  		</tr>
  		<tr>
  		<th>6.</th>
  		<th><a href="logout.jsp">Logout</a></th>
  		</tr>
  		
  </table>
 
 </div>
</body>
</html>