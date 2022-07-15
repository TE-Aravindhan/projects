
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String ename = (String) request.getAttribute("ename");
Integer empno = (Integer) request.getAttribute("empno");
String doj = (String) request.getAttribute("doj");
String role = (String) request.getAttribute("role");
Double salary = (Double) request.getAttribute("salary");
Integer deptno = (Integer) request.getAttribute("deptno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./bootstrap-4.6.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="show.css">

</head>
<body>
	<script src="./jquery.slim.min.js"></script>
    <script src="./bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
	<nav class="navbar" id="nav">
		<form class="container-fluid justify-content-start">
		 <a href="./welcome.html"><button class="btn" id="home" type="button">Home</button></a>   
		</form>
	  </nav>
	<form action="./functions.html" id="form">
	
			<h1 id="t1">Your Details<h1>
		
	<table >
		
		<tr>
			<th>Description</th>
			<th>Details</th>
		</tr>
		<tr>
			<td>Name</td>
			<td id="td2"><%=ename%>
		</tr>
		<tr>
			<td>Employee Id</td>
			<td id="td2"><%=empno%>
		</tr>
		<tr>
			<td>Date of Joining</td>
			<td id="td2"><%=doj%>
		</tr>
		<tr>
			<td>Role</td>
			<td id="td2"><%=role%>
		</tr>
		<tr>
			<td>Salary</td>
			<td id="td2"><%=salary%>
		</tr>
		<tr>
			<td>Department Id</td>
			<td id="td2"><%=deptno%>
		</tr>
	</table>
	<div>
	<input id="done" class="btn" type="submit" value="Done">
	</div>
	</form>

</body>
</html>