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
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Books Database</h1>
		</div>
		<div class="main">
			<div class="border border-dark p-3 mb-3">
				<h2>All Books</h2>
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Description</th>
							<th>Language</th>
							<th>Number Of Pages</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody id="tableBody"></tbody>
				</table>
			</div>
			<div class="border border-dark p-3">
				<h2>Add a book</h2>
				<form onsubmit="event.preventDefault(); submitForm();">
					<p>
						Title:
						<input type="text" name="title" id="" oninput="setTitle(event)"/>
					</p>
					<p>
						Description:
						<input type="text" name="description" id="" oninput="setDescription(event)"/>
					</p>
					<p>
						Language:
						<input type="text" name="language" id="" oninput="setLanguage(event)"/>
					</p>
					<p>
						Number of Pages:
						<input type="number" name="numberOfPages" id="" value="100" oninput="setNumberOfPages(event)"/>
					</p>
					<button class="btn btn-warning">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="script.js">
</script>
</html>