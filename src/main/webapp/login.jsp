<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
    history.forward();
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet" method="post">
 <h1 style="text-align:center;">Welcome !!</h1>
 
 <br><br><br>
 <div style="padding-left:80px">
   <table>
  		<tr>
  		<th>PAN number</th>
  		<th><input type="text" name="pan"></th>
  		</tr>
  		
  		<tr>
  		<th>Password</th>
  		<th><input type="password" name="password"></th>
		</tr>
 		
  </table>   <br>
   <input type="submit" value="login">
   
  <div style="padding-left:100px">
 
  <a href="forget.jsp">forget password</a>
  </div>
   
    </div>
    
    </form>
</body>
</html>