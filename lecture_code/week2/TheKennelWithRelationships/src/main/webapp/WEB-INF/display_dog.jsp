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
			<h2>Here is information about: <c:out value="${ dog.name }" /></h2>
			<ul>
				<li>Age: <c:out value="${ dog.age }" /></li>
				<li>Hair Color: <c:out value="${ dog.hairColor }" /></li>
			</ul>
			<h2>This Dog's collars:</h2>
			<ul>
				<c:forEach items="${ dog.collars }" var="collar">
					<li><c:out value="${ collar.color }" /></li>
				</c:forEach>
			</ul>
			<h3>The number of collars this dog owns is: <c:out value="${ dog.collars.size() }" /></h3>
		</div>
		<a href="/dogs/${ dog.id }/edit">Edit this Dog</a>
		<form action="/dogs/${ dog.id }/delete" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>