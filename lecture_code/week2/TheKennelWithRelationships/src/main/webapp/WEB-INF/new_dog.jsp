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
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="main">
			<h2>Add a Dog to the Kennel</h2>
			<form:form action="/dogs/create" method="post" modelAttribute="dog">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name" />
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="age">Age:</form:label>
					<form:input type="number" path="age" min="0" value="0"/>
					<form:errors path="age" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="hairColor">Hair Color:</form:label>
					<form:input type="text" path="hairColor" />
					<form:errors path="hairColor" class="text-danger" />
				</div>
				<button class="btn btn-success">Add a Dog</button>
			</form:form>
		</div>
	</div>
</body>
</html>