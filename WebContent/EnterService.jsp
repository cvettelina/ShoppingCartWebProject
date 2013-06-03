<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	input[type="checkbox"]
	{
		display:inline;
	}
</style>
<body>
<div class="content">
	<h1>Enter new service</h1>
	<form method="post" action="ProductsServlet">
		<input type="text" name="name" id="name" placeholder="enter name here"/>
		<input type="text" name="desc" id="desc" placeholder="enter description"/>
		<input type="text" name="price" id="price" placeholder="enter price here"/>
		<input type="checkbox" value="true" name="fixed" id="fixed">
		<label for="fixed">Fixed price</label>
		<input type="url" name="img" placeholder="enter image url here"/>
		<input type="submit" value="Add" name="enterService"/>
	</form>
</div>
</body>
</html>