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
			<h1>Hello <c:out value="${ loggedInUser.firstName }" />, Welcome to Poke Creator!</h1>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">logout</a>
		</div>
		<div class="main">
			<h2>Here is the information for the pokemon: <c:out value="${ pokemon.name }" /></h2>
			<p>Type: <c:out value="${ pokemon.type }" /></p>
			<p>Level: <c:out value="${ pokemon.level }" /></p>
			<p>Created By: <c:out value="${ pokemon.creator.firstName }" /></p>
		</div>
	</div>
</body>
</html>