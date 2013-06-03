<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.content{
	width:200px;
	padding:100px;
	margin-left:30%;
	margin-right:30%;
	margin-top:10%;
	background:rgba(255,125,255,0.8);
	border-radius:45px;
	}
	input{
	display:block;
	height:100px;
	width:200px;
	font-size:2em;
	}
</style>
<body>
<div class="content">
	<form method="get" action="ProductsServlet">
	<input type="submit" value="Enter"/>
	</form>
</div>
</body>
</html>