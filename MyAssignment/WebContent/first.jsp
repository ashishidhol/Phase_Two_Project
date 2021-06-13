<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>firstyear</title>
</head>
<body>

	<%
		session = request.getSession(false);
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
<a href="dashboard.jsp">Go Back to Dashboard</a>
<br> </br>
	<a href="studentlist.jsp">Go Back to StudentList</a> 
	<br />
	<br> </br>
	<a href="<%=request.getContextPath()%>/addNewStudent">AddnewStudent</a>
	<h2>First Year StudentList</h2>

	<table border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>FisrtName</th>
				<th>LastName</th>
				<th>Age</th>
				<th>Email</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stud" items="${students}">
				<tr>
					<td><c:out value="${stud.id}" /></td>
					<td><c:out value="${stud.firstName}" /></td>
					<td><c:out value="${stud.lastName}" /></td>
					<td><c:out value="${stud.age}" /></td>
					<td><c:out value="${stud.email}" /></td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>