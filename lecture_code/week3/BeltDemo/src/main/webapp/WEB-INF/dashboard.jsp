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
<html>
<head>
    <meta charset="UTF-8">
    <title>Poke Creator</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between align-items-center">
			<h1>Hello <c:out value="${ loggedInUser.firstName }" />, Welcome to Poke Creator!</h1>
			<a href="/logout">logout</a>
		</div>
		<div class="main">
			<h2>All of your Pokemon!</h2>
			<table class="table border border-black">
				<thead>
					<tr>
						<th>Name</th>
						<th>Type</th>
						<th>Level</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ loggedInUser.pokemon }" var="pokemon">
						<tr>
							<td><c:out value="${ pokemon.name }" /></td>
							<td><c:out value="${ pokemon.type }" /></td>
							<td><c:out value="${ pokemon.level }" /></td>
							<td class="d-flex justify-content-around">
								<a class="btn btn-link" href="/pokemon/${ pokemon.id }">View</a>
								<a class="btn btn-link" href="/pokemon/${ pokemon.id }/edit">Edit</a>
								<form action="/pokemon/${ pokemon.id }/delete" method="post">
									<input type="hidden" name="_method" value="delete"/>
									<button class="btn btn-link">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/pokemon/new" class="btn btn-link">Create a Pokemon!</a>
		</div>
	</div>
</body>
</html>






