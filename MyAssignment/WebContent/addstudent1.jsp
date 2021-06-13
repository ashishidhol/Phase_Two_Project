<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addstudent_firstyear</title>
</head>
<body>
<a href="dashboard.jsp">View Class Report</a>
<br> </br>
<a href="classreport.jsp"> Back to StudentList</a>  |
<h2 style='color:red'> Add student details to insert new student</h2>
	<form action="<%=request.getContextPath()%>/insertStudent">
		<input type="text" name="id" placeholder="Student ID" />
		<br> </br>
		<input type="text" name="fname" placeholder=" Enetr FirstName" />
		<br> </br>
		<input type="text" name="lname" placeholder="Enter LastName" />
		<br> </br>
		<input type="text" name="age" placeholder=" Enter Age" />
		<br> </br>
		<input type="text" name="email" placeholder="Enter Emailid" />
		<br> </br>
		<input type="Submit" value="Submit" />
	</form>

</body>
</html>