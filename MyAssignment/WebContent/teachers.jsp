<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>teachers list</title>
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
	<a href="ViewAllRecordServlet">View Complete Record of Academy</a>
<br/><br/><br/>
	
	<a href="<%=request.getContextPath()%>/assignSubject">Assign FirstYearSubject </a>
	<br> </br>
	<a href="<%=request.getContextPath()%>/assignSubject1">Assign SecondYearSubject</a>
		<br> </br>
	<a href="<%=request.getContextPath()%>/assignSubject2">Assign ThirdYearSubject</a>
		<br> </br>
	<a href="<%=request.getContextPath()%>/assignSubject3">Assign FourthYearSubject</a>
	<br />
	<h2>Teacher List</h2>

	<table border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Assign_class</th>
				<th>Assign_Subject</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teach" items="${teachers}">
				<tr>
					<td><c:out value="${teach.id}" /></td>
					<td><c:out value="${teach.name}" /></td>
					<td><c:out value="${teach.gender}" /></td>
					<td><c:out value="${teach.assign_class}" /></td>
					<td><c:out value="${teach.sub_assign}" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>