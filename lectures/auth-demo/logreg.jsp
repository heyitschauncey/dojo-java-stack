<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donations Full Spring</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>Register</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<!-- register form -->
		</form:form>

		<h1>Login</h1>
		<form:form action="/login" method="POST" modelAttribute="newLogin">
			<!-- login form -->
		</form:form>

	</div>
</body>
</html>





