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
   <h1>Hello There <c:out value="${ user.firstName }" /></h1>
   
  	<h2>Here are all the ice creams that have been created:</h2>
  	
  	<table class="table">
  		<thead>
  			<tr>
  				<th>Flavor</th>
  				<th>Topping</th>
  				<th>Cone Type</th>
  				<th>Number of Scoops</th>
  				<th>Creator</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="iceCream" items="${ iceCreams }" >
  				<tr>
  					<td><c:out value="${ iceCream.flavor }" /></td>
  					<td><c:out value="${ iceCream.topping }" /></td>
  					<td><c:out value="${ iceCream.coneType }" /></td>
  					<td><c:out value="${ iceCream.numberOfScoops }" /></td>
  					<td><c:out value="${ iceCream.creator.firstName }" /></td>
  				</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	<a href="/icecreams/new">Create a new Ice Cream</a>
  	<a href="/logout">Logout</a>
</body>
</html>