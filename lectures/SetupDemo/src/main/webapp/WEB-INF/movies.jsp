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
   <h1>Movie Dashboard</h1>
   
   <h3>Here is a list of all the movies:</h3>
   <table class="table">
   	<thead>
   		<th>Title</th>
   		<th>Description</th>
   		<th>Rating</th>
   		<th>Actions</th>
   	</thead>
   	<tbody>
		<c:forEach var="oneMovie" items="${ listOfMovies }">
			<tr>
				<td><c:out value="${ oneMovie.title }" /></td>
				<td><c:out value="${ oneMovie.description }" /></td>
				<td><c:out value="${ oneMovie.rating }" /></td>
				<td>
					<a href="/movies/${ oneMovie.id }">View</a>
					 | 
					<a href="/movies/${ oneMovie.id }/edit">Edit</a>
					 | 
					<form action="/movies/${oneMovie.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
					</form>
				</td>
			</tr>	   
		</c:forEach>
   	</tbody>
   </table>
   
   <a href="/movies/new">Create a new movie.</a>
</body>
</html>