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
    <title></title>
</head>
<body>
  <h1 class="bg-dark text-white">Welcome to the Dog Emporium</h1>   
	<p>Here are some very good doggos:</p>
	<!-- <ul>
		<li>Vicky</li>
		<li>Leia</li>
		<li>Elvis</li>
		<li>Wu, short for Wu-Tang</li>
		<li>Nori</li>
		<li>Spike</li>
		<li>Max</li>
	</ul> -->
	<ul>
		<c:forEach var="name" items="${ dogNames }">
			<li>
				<c:out value="${ name }"/>
				<c:if test="${ name == 'Scooby' }">
					-- Ruh Roh!
				</c:if>
			</li>
		</c:forEach>
	</ul>
	<p>
		<c:out value="${ value1 }" />
	</p>
	<p>
		<c:out value="${ value2 }" />
	</p> 
</body>
</html>