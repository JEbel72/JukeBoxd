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
  			<h1>Welcome, ${ user.username }!</h1>
			<ul>
				<li><a href="/albums/new">Add an Album!</a></li>
				<li>
					<form action="/logout" method="POST">
						<input type="submit" class="btn-logout" value="Logout"/>
					</form>
				</li>
			</ul>
		</nav>
		<h3>Your Diary:</h3>
		<table>
			<thead>
				<tr>
					<th>Date Listened:</th>
					<th>Title:</th>
					<th>Artist:</th>
					<th>Rating:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="album" items="${ allAlbums }">
					<tr>
						<td><c:out value="${ album.date }"/></td>
						<td><a href="/albums/${ album.id }"><c:out value="${ album.title }"/></a></td>
						<td><c:out value="${ album.artist }"/></td>
						<td><c:out value="${ album.rating }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
