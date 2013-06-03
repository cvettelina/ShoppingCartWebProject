<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter product</title>
</head>
<style>
	input{
	display:block;
	margin:10px;
	}
	.content{
	background:rgba(255,0,0,0.5);
	margin-left:20%;
	width:30%;
	}
</style>
<body>
<div class="content">
	<h1>Enter new product</h1>
	<form method="post" action="ProductsServlet">
		<input type="text" name="name" id="name" placeholder="enter name here"/>
		<input type="text" name="desc" id="desc" placeholder="enter description"/>
		<input type="text" name="price" id="price" placeholder="enter price here"/>
		<input type="text" name="producer" id="producer" placeholder="enter producer here"/>
		<input type="text" name="day" id="day" placeholder="enter day here"/>
		<input type="text" name="month" id="month" placeholder="enter month here"/>
		<input type="text" name="year" id="year" placeholder="enter year here"/>
		<input type="url" name="img" placeholder="enter image url here"/>
		<input type="submit" value="enter" name="enter"/>
	</form>
</div>
</body>
</html>