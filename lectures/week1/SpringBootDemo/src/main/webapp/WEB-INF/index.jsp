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
    <title>Spring boot demo</title>
</head>
<body>
	<h1>Hello There</h1>
	<%-- <h1><c:out value="${2+2}"/></h1> --%>
	<h2>Your name is:</h2>
	<p>First name: <c:out value="${ firstName }" /> </p>
	<p>Last Name: <c:out value="${ lastName }"/></p>
	
	<c:forEach var="oneDojo" items="${dojosFromMyController}">
        <p><c:out value="${oneDojo}"/></p>
    </c:forEach>
</body>
</html>