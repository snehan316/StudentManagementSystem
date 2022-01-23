<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<% String msg = (String) request.getAttribute("msg");
	if(msg == null)
		msg = "";
%>

<div><%@include file="header.html" %></div>
<div>
<h1>Update Student</h1>
<h4 style= "color:green"><%= msg %></h4>	
<div class="search">
<form action="./SearchStudentController" method="post">
	<pre>
		Student RollNumber: <input type="text" name="rollNumber"/>
	</pre>
	<pre>
	<input type="submit" value="Search" />
	</pre>
</form>
</div>

<div>
	<form action="./UpdateStudentController" name="student_form" method="post">
		<table>
			<tr>
				<td>Student Roll Number</td>
				<td><input type="text" name="roll_number" value="${dto.getRollNumber()}"/><span id="rollNumberMsg"></span></td>
				
			</tr>
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="name" value="${dto.getName()}"/><span id="nameMsg"></span></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text"  name="gender" value="${dto.getGender()}"/></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><input type="text"  name="course" value="${dto.getCourse()}"/></td>
				
			</tr>
			<tr>
				<td><input type="submit" value="Update"/></td>
				<td><input type="button" value="Cancel"/></td>
			</tr>
		
		
		</table>
	
	
	
	</form>
</div>



</div>
<div><%@include file="footer.html" %></div>
</body>
</html>