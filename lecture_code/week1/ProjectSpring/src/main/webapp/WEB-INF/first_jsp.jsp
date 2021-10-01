<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<!-- for rendering errors on PUT routes -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Here is my first JSP!</h1>
	<h3>Here is an example java expression: <c:out value="${2+2}"/></h3>
	
	<%-- % for(int i = 0; i < 5; i++) { %>
        <h1><%= i %></h1>
    <% } %>
    <p>The time is: <%= new Date() %></p> --%>
</body>
</html>