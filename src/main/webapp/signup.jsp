<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Account</title>
</head>
<body>
<br>
  <br>
  enter your details according to your PAN card
  <br><br>
  <form action="ControllerServlet" method="post">
  <table>
  		<tr>
  		<th>Name</th>
  		<th><input type="text" name="name"></th>
  		</tr>
  		<tr>
  		<th>PAN number</th>
  		<th><input type="text" name="pan"></th>
  		</tr>
  		<tr>
  		<th>Mobile number</th>
  		<th><input type="number" name="mobile"></th>
  		</tr>
  		<tr>
  		<th>Email ID</th>
  		<th><input type="email" name="email"></th>
  		</tr>
  		<tr>
  		<th>Password</th>
  		<th><input type="password" name="password"></th>
  		</tr>
  		
  		
  </table>   <br>
   <input type="submit" value="create account">
  </form> 

</body>
</html>