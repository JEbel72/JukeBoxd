<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<title>JukeBoxd</title>
    	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    	<link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    	<script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
	</head>
	<body>
		<nav>
			<h1>Welcome to JukeBoxd!</h1>
		</nav>
		<h2>Register</h2>
		<form:form action="/register" class="form" method="POST" modelAttribute="newUser">
			<div>
				<form:label path="username">User Name:</form:label>
				<form:errors path="username"/>
				<form:input path="username"/>
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email"/>
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password"/>
				<form:password path="password"/>
			</div>
			<div>
				<form:label path="confirm">Confirm Password:</form:label>
				<form:errors path="confirm"/>
				<form:password path="confirm"/>
			</div>
			<input type="submit" class="btn" value="Register"/>
		</form:form>
		<h2>Log In:</h2>
		<form:form action="/login" class="form" method="POST" modelAttribute="newLogin">
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email"/>
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password"/>
				<form:password path="password"/>
			</div>
			<input type="submit" class="btn" value="Login"/>
		</form:form>
	</body>
</html>




