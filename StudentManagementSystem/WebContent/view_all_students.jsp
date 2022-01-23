<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Students</title>
</head>
<body>

<div><%@include file="header.html" %></div>
<div>
<h1>View All Students</h1>
	<table border="1px">
<thead>
	<tr>
		<th>Roll Number</th>
		<th>Student Name</th>
		<th>Gender</th>
		<th>Course</th>
    </tr>
</thead>
<tbody>
	 <c:forEach items="${list}" var="item">
	 	<tr>
	 		<td><c:out value="${item.getRollNumber()}"/></td>
	 		<td><c:out value="${item.getName()}"/></td>
	 		<td><c:out value="${item.getGender()}"/></td>
	 		<td><c:out value="${item.getCourse()}"/></td>
	 	</tr>
	 </c:forEach>
</tbody>

</table>

</div>
<div><%@include file="footer.html" %></div>


</body>
</html>