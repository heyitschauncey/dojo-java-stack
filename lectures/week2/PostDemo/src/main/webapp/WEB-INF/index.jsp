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
   	<h1>Hello There</h1>
   
   <h2>Order your pizza here:</h2>
   	<form action="/submit" method="post">
   		<p>
   			Crust Selection:
   			<input type="text" name="crust"  />
   		</p>
   		<p>
   			Cheese Selection:
   			<input type="text" name="cheese"  />
   		</p>
   		<p>
   			Sauce Selection:
   			<input type="text" name="sauce"  />
   		</p>
   		<p>
   			Topping Selection:
   			<input type="text" name="topping"  />
   		</p>
   		<button>Order Pizza</button>
   	</form>
</body>
</html>