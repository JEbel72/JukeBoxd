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
			<h1>Add an Album!</h1>
			<ul>
				<li><a href="/albums">back to your diary</a></li>
				<li>
					<form action="/logout" method="POST">
						<input type="submit" class="btn-logout" value="Logout"/>
					</form>
				</li>
			</ul>
		</nav>
		<form:form action="/albums/new" class="form" method="POST" modelAttribute="newAlbum">
			<div>
				<form:label path="title">Title:</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</div>
			<div>
				<form:label path="artist">Artist:</form:label>
				<form:errors path="artist"/>
				<form:input path="artist"/>
			</div>
			<div>
				<form:label path="review">Your Review:</form:label>
				<form:errors path="review"/>
				<form:textarea rows="5" path="review"/>
			</div>
			<div>
				<form:label path="rating">Your Rating:</form:label>
				<form:errors path="rating"/>
				<form:input type="number" path="rating"/>
			</div>
			<div>
				<form:label path="date">Date Listened:</form:label>
				<form:errors path="date"/>
				<form:input type="date" path="date"/>
			</div>
			<form:hidden path="user" value="${ user.id }"/>
			<input type="submit" class="btn" value="Submit"/>
		</form:form>
	</body>
</html>

