<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
	
<h1 style='color:red'>Learners Academy</h1>
<h2 style='color:blue'>Login Page</h2>
	<form action="LoginSevlet" method="post">
		<input type="text" name="username" placeholder="Enter Username" />
		<input type="password" name="password" placeholder="Enter Password" />
		<input type="submit" value="Login" />
	</form>
	
</body>
</html>