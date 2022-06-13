<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Pick your Pizza toppings:</h1>
	
	<form action="/order" method="POST">
		<p>
			Cheese:
			<select name="cheese" id="">
				<option value="mozzerella">Mozzerella</option>
				<option value="parmesean">Parmesean</option>
				<option value="feta">feta</option>
			</select>
		</p>
		<p>
			Sauce:
			<select name="sauce" id="">
				<option value="tomato">Tomato</option>
				<option value="pesto">Pesto</option>
				<option value="tzatziki">Tzatziki</option>
				<option value="bbq">BBQ</option>
			</select>
		</p>
		<p>
			Toppings:
			<select name="topping" id="">
				<option value="pepperoni">Pepperoni</option>
				<option value="jalepenos">Jalepenos</option>
				<option value="mango">Mango</option>
				<option value="pineapple">Pineapple</option>
				<option value="mushrooms">Mushrooms</option>
			</select>
		</p>
		
		<button>Submit</button>
	</form>
</body>
</html>