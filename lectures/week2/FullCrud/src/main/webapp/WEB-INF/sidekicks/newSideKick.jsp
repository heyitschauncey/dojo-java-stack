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
   <h1>Create a  New Side Kick</h1>
   
   <form:form action="/sidekicks/create" method="post" modelAttribute="sideKick">
   	<p>
   		<form:label path="name">Name</form:label>
   		<form:input path="name" />
   		<form:errors path="name" />
   	</p>
   	<p>
   		<form:label path="superPower">Super Power</form:label>
   		<form:input path="superPower" />
   		<form:errors path="superPower" />
   	</p>
   	<p>
   		<form:label path="weakness">Weakness</form:label>
   		<form:input path="weakness" />
   		<form:errors path="weakness" />
   	</p>
   	<p>
   		<form:label path="superHero">Super Hero</form:label>
   		<form:select path="superHero">
   			<c:forEach var="hero" items="${ superHeros }">
   				<form:option value="${ hero }"><c:out value="${ hero.name }" /></form:option>   			
   			</c:forEach>
   		</form:select>
   	</p>
   	<button class="btn btn-outline-success">Submit</button>
   </form:form>
   
   <a href="/superheros">Dashboard</a>
</body>
</html>