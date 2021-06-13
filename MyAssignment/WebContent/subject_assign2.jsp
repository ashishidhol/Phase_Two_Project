<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Assign ThirdYearSubject</title>
</head>
<body>
<a href="TeacherServlet">Go Back to TeacherList </a> 
<div align="center">
<h2 style='color:red'>Insert Teacher Details to assign Subject..</h2>
	<form action="<%=request.getContextPath()%>/insertSubject">
 
<div align="center">
   
    <form action="<%=request.getContextPath()%>/insertSubject">
        
<input type="text" name="id" placeholder="Teacher ID" />
		<br> </br>
		<input type="text" name="name" placeholder="Teacher Name" />
		<br> </br>
		<label for="Gender">Select Gender:</label>
<select name="gender" id="gender">
  <option value="Male">Male</option>
  <option value="Female">Female</option>
  <option value="Other">Other</option>
  </select>
		<br> </br>
		<label for="classes">Select Class:</label>
<select name="assign_class" id="classes">
  <option disabled value="First Year">First Year</option>
  <option disabled value="Second Year">Second Year</option>
  <option value="Third Year">Third Year</option>
  <option disabled value="Fourth Year">Fourth Year</option>
  </select>

<br> </br>
        <label for="subjecs">Select Subject:</label>
       <select name="assign_subject">
            <c:forEach items="${subjects2}" var="category">
                <option value="${category.subjectname}">${category.subjectname}
                    
                </option>
            </c:forEach>
        </select>

        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>

