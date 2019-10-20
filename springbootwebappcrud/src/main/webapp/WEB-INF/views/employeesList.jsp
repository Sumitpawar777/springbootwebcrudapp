<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<h1 class="text-center">Employee List</h1>
		<table class="table m-3" border = "1">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Gender</th>
					<th scope="col">Department</th>
					<th scope="col">Date of Birth</th>
					<th scope="col">Actions</th>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${list}" var="e">
					<tr>
						<td>${e.name}</td>
						<td>${e.gender}</td>
						<td>${e.department}</td>
						<td>${e.dob}</td>
						<td><a href = "${pageContext.request.contextPath}/employee?id=${e.id}">Edit</a> | <a href = "${pageContext.request.contextPath}/delete/${e.id}">delete</a></td>
					</tr>
			</tbody>
			</c:forEach>
		</table>
	<div class="col-md-12 center-block">
	<button class="btn btn-primary center-block" onclick="window.location.href = '${pageContext.request.contextPath}/showEmployeeForm'">Add Employee</button>
	</div>
</body>
</html>