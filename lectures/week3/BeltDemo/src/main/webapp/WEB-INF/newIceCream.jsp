<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="/css/style.css" />
<title></title>
</head>
<body>
	<h1>Make your new ice cream!</h1>

	<form:form action="/icecreams/create" method="post"
		modelAttribute="iceCream">
		<p>
			<form:label path="flavor">Flavor</form:label>
			<form:input path="flavor" />
			<form:errors path="flavor" class="text-danger"/>
		</p>
		<p>
			<form:label path="topping">Topping</form:label>
			<form:input path="topping" />
			<form:errors path="topping" class="text-danger" />
		</p>
		<p>
			<form:label path="coneType">coneType</form:label>
			<form:input path="coneType" />
			<form:errors path="coneType" class="text-danger" />
		</p>
		<p>
			<form:label path="numberOfScoops">numberOfScoops</form:label>
			<form:input path="numberOfScoops" type="number"/>
			<form:errors path="numberOfScoops" class="text-danger" />
		</p>
		<button class="btn btn-success">Create</button>
	</form:form>
	<a href="/dashboard">Dashboard</a>
</body>
</html>