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
    <title>Movies</title>
</head>
<body>
  <h1>Create a new Movie!</h1> 
  
  <form:form action="/movies" method="post" modelAttribute="newMovie">
  	<p>
  		<form:label path="title">Title</form:label>
  		<form:input path="title" />
  		<form:errors path="title" />
  	</p>
  	<p>
  		<form:label path="description">Description</form:label>
  		<form:input path="description" />
  		<form:errors path="description" />
  	</p>
  	<p>
  		<form:label path="rating">Rating</form:label>
  		<form:input path="rating" type="number"/>
  		<form:errors path="rating" />
  	</p>
  	<button>Submit</button>
  </form:form>
  
  <a href="/movies">Dashboard.</a>
</body>
</html>