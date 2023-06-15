<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <title>Dog Emporium</title>
</head>
<body class="p-3">
	<header class="d-flex justify-content-between align-items-center border-bottom">
		<h1>Dog Emporium</h1>
		<a href="/dogs/new">Add a new dog!</a>	
	</header>
	
	<h3>Here are the dogs currently available to see!</h3>
	<ul>
		<c:forEach var="oneDog" items="${ listOfDogs }">
			<li>
				<a href="/dogs/${ oneDog.id }"><c:out value="${ oneDog.name }" /></a>
				 | 
				<a href="/dogs/${ oneDog.id }/edit">Edit this dog</a>
				 | 
				 <form action="/dogs/${oneDog.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button class='btn btn-outline-success'>Adopted</button>
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>