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
<body class="p-3">
	<header class="d-flex justify-content-between align-items-center border-bottom">
		<h1>Dog Emporium</h1>
		<a href="/">Dashboard</a>	
	</header>
	
	<h3>Add a new dog to the emporium!</h3>
	<form:form action="/dogs" method="post" modelAttribute="newDog">
		<p>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>	
		<p>
			<form:label path="age">Age:</form:label>
			<form:input path="age" type="nubmer"/>
			<form:errors path="age" />
		</p>
		<p>
			<form:label path="hairColor">Hair Color:</form:label>
			<form:input path="hairColor" />
			<form:errors path="hairColor" />
		</p>
		<button>Submit!</button>
	</form:form>
</body>
</html>
