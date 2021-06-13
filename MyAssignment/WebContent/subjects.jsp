<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>subjects</title>
</head>
<body>

	<%
		session = request.getSession(false);
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<a href="dashboard.jsp">Go Back to Dashboard</a>
	<br> <br>
<a href="ViewAllRecordServlet">View Complete Record of Academy</a>
	<br />
	
	<table border="1" cellpadding="10" cellspacing="0">
		<caption>First Year Subjects</caption>
		<thead>
			<tr>
				
				<th>SubjectName</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sub" items="${subjects}">
				<tr>
					
					<td><c:out value="${sub.subjectname}" /></td>
					
					
				</tr>
			</c:forEach>

		</tbody>
		
		<br> </br>
	

	<table border="1" cellpadding="10" cellspacing="0">
	<caption>Second Year Subjects</caption>
		<thead>
			<tr>
				
				<th>SubjectName</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sub" items="${subjects1}">
				<tr>
					
					<td><c:out value="${sub.subjectname}" /></td>
					
					
				</tr>
			</c:forEach>

		</tbody>
		<br> </br>
	</table>
<br> </br>
<table border="1" cellpadding="10" cellspacing="0">
	<caption>Third Year Subjects</caption>
		<thead>
			<tr>
				
				<th>SubjectName</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sub" items="${subjects2}">
				<tr>
				
					<td><c:out value="${sub.subjectname}" /></td>
					
					
				</tr>
			</c:forEach>

		</tbody>
		<br> </br>
	</table>
	
	
		<br> </br>
<table border="1" cellpadding="10" cellspacing="0">
	<caption>Fourth Year Subjects</caption>
		<thead>
			<tr>
				
				<th>SubjectName</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sub" items="${subjects3}">
				<tr>
					
					<td><c:out value="${sub.subjectname}" /></td>
					
					
				</tr>
			</c:forEach>

		</tbody>
		<br> </br>
	</table>
</body>
</html>