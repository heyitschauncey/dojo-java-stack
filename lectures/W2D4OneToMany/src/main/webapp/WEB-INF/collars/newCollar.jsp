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
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <title>Dog Emporium</title>
</head>
<body>
	<header class="d-flex justify-content-between align-items-center border-bottom">
		<h1>Dog Emporium</h1>
		<a href="/dogs">Dashboard</a>	
	</header>
	
	<h2>Add a new collar for a dog!</h2>	
	<form:form action="/collars" method="post" modelAttribute="newCollar" class="form">
		<p>
			<form:select path="dog">
				<c:forEach var="oneDog" items="${ listOfDogs }">
					<form:option value="${ oneDog.id }" label="${ oneDog.name }" />
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="color">Color:</form:label>
			<form:input path="color" />
			<form:errors path="color" />
		</p>
		<p>
			<form:label path="tagShape">Shape of the tag:</form:label>
			<form:input path="tagShape" />
			<form:errors path="tagShape" />
		</p>
		<button class="btn btn-outline-primary">Add a collar!</button>
	</form:form>
	
</body>
</html>