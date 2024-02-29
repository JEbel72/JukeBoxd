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
			<h1><c:out value="${ album.title }"/></h1>
			<ul>
				<li><a href="/albums">back to your diary</a></li>
				<li>
					<form action="/logout" method="POST">
						<input type="submit" class="btn-logout" value="Logout"/>
					</form>
				</li>
			</ul>
		</nav>
			<h1><c:out value="${ album.title }"/></h1> 
			<h2><c:out value="${ album.artist }"/></h2>
			<h3><c:out value="${ album.user.username }"/>'s rating: <c:out value="${ album.rating }"/></h3>		
			<h3><c:out value="${ album.user.username }"/>'s review:</h3>			
		<p>_______________________________________________</p>
		<p><c:out value="${ album.review }"/></p>
		<p>_______________________________________________</p>
		<c:if test="${ user.id.equals(album.user.id) }">
			<div class="btns">
				<a href="/albums/${ album.id }/edit" class="btn">Edit</a>
			<form action="/albums/${ album.id }/delete" method="POST">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" class="btn-logout" value="Delete">
			</form>
			</div>
		</c:if>
	</body>
</html>
