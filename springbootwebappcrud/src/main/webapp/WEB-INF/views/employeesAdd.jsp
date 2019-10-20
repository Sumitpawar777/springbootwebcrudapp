<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<h1 class="text-center">Add Employee</h1>
	<form:form class="border" action = "${pageContext.request.contextPath}/save" modelAttribute="employee">
		<div class="form-group">
		Enter Name: <form:input path="name"/><br/>
		</div>
		<div class="form-group">
		Select Gender: <form:radiobutton path="gender" value = "Male"/>Male&nbsp;
					<form:radiobutton path="gender" value = "Female"/>Female&nbsp;<br/>
		</div>
		<div class="form-group">
		Departement: 
		<form:select path="department">
			<form:option value="Support">Support</form:option>
			<form:option value="Testing">Testing</form:option>
			<form:option value="Development">Development</form:option>
			<form:option value="Business Analyst">Business Analyst</form:option>
		</form:select><br/>
		</div>
		<div class="form-group">
		Date of Birth: <form:input path="dob" type = "date"/><br/>
		</div>
		<form:hidden path = "id"/>
		<div class="form-group">
		<button class="btn btn-primary" type = "submit">Save</button>
		<div class="form-group">
	</form:form>	
</body>
</html>