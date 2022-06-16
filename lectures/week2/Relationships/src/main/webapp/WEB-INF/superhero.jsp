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
   <h1>Information on <c:out value="${ superHero.name }" /></h1>
   <p>Super Power: <c:out value="${ superHero.superPower }" /></p>
   <p>Weakness: <c:out value="${ superHero.weakness }" /></p>
   <a href="/superheros">Dashboard</a>
   <a href="/superheros/${ superHero.id }/edit">Edit this Hero</a>
   <form action="/superheros/${ superHero.id }/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <button class="btn btn-danger">Delete</button>
	</form>
</body>
</html>