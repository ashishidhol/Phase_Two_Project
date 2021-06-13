<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>classlist</title>
</head>
<body>

	<%
		session = request.getSession(false);
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<a href="dashboard.jsp">Go Back to Dashboard</a>

	<br />
	<h2>Class List</h2>

	<table border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>ClassId</th>
				<th>ClassName</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="clas" items="${classes}">
				<tr>
					<td><c:out value="${clas.classid}" /></td>
					<td><c:out value="${clas.classname}" /></td>
					
					
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>