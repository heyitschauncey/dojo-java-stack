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
			<h2>Add a Collar</h2>
			<form:form action="/collars/create" method="post" modelAttribute="collar">
				<div class="form-group">
					<form:select path="dog">
						<c:forEach items="${ allDogs }" var="dog">
							<form:option value="${ dog.id }" label="${ dog.name }" />
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="color">Color:</form:label>
					<form:input type="text" path="color"/>
					<form:errors path="color" class="text-danger" />
				</div>
				<button class="btn btn-success">Add a Collar</button>
			</form:form>
		</div>
	</div>
</body>
</html>