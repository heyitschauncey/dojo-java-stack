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
    <title></title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between align-items-center">
			<h1>The Kennel</h1>
			<a href="/dogs/new">Add a Dog</a>
			<a href="/collars/new">Add a Collar</a>
			<a href="/toys">Toys</a>
		</div>
		<div class="main">
			<h2>Here are the dogs in the kennel:</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Hair Color</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ allDogs }" var="dog">
						<tr>
							<td><c:out value="${ dog.name }" /></td>
							<td><c:out value="${ dog.age }" /></td>
							<td><c:out value="${ dog.hairColor }" /></td>
							<td>
								<a class="btn btn-link" href="/dogs/${ dog.id }">View</a> | 
								<a class="btn btn-link" href="/dogs/${ dog.id }/edit">Edit</a> | 
								<form action="/dogs/${ dog.id }/delete" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>