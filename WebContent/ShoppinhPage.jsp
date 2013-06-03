<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" >
<title>Shopping Cart</title>
</head>
<body>
	<div class="content">
		<div class="products">
		<h2>Products</h2>
		<form name="orders" method="post" action="OrdersServlet">
			<c:forEach items="${productList}" var="current">
			<div class="ones">
				<h1>${current.getName()}</h1>
				<img src="${current.getImg()}" height="100" width="100"/>
				<label for="${current.getName()}">Quantity:</label>
				<input type="text" id="${current.getName()}" value="1" name="${current.getName()}"/>
				<button type="submit" value="${productList.indexOf(current)}" name="order">Buy</button>
			</div>
			</c:forEach>
		</form>	
		</div>
		<div class="services">
		<h2>Services</h2>
		<form name="orders" method="post" action="OrdersServlet">
			<c:forEach items="${serviceList}" var="current">
			<div class="ones">
				<h1>${current.getName()}</h1>
				<img src="${current.getImg()}" height="100" width="100"/>
				<c:if test="${current.getFixed()==false}">
					<label for="${current.getName()}">Hours:</label>
					<input type="text" id="${current.getName()}" value="1" name="${current.getName()}"/>
				</c:if>
				<button type="submit" value="${serviceList.indexOf(current)}" name="service">Buy</button>
			</div>
			</c:forEach>
		</form>
		</div>	
		<label for="show">My Cart</label>	
		<input type="checkbox" id="show">
		<div class="cart">
		<h1>My orders</h1>
			<form method="get" action="OrdersServlet">
			<c:forEach var="entry" items="${myCart.getProducts()}">
			<div class="dve">
			<c:if test="${entry.key.isInstanceOf().equals('class Shopping.Product')}">
 				<h3>Product</h3>
	 				<h4>${entry.key.getName()}</h4>
	 				 <img src="${entry.key.getImg()}" height="50" width="50"/>
	 				 <p>Description: ${entry.key.getDescription()}</p>
	 				 <p>Producer: ${entry.key.getProducer()} / Date of production: ${entry.key.getDate()}</p>
	 				 <p>Price: ${entry.key.getCost()}</p>
	  				Quantity: <c:out value="${entry.value}"/>
	  				Total: ${entry.key.getCost()*entry.value}</br>
	  				<button type="submit" name="removeProd" value="${entry.key.getId()}">Remove</button>
	  				</c:if>
	  			<c:if test="${entry.key.isInstanceOf().equals('class Shopping.Service')}">
	  				<h3>Service</h3>
	 				<h4>${entry.key.getName()}</h4>
	 				 <img src="${entry.key.getImg()}" height="50" width="50"/>
	 				 <p>Description: ${entry.key.getDescription()}</p>
	 				 <p>Price: ${entry.key.getCost()}</p>
	  				Hours: <c:out value="${entry.value}"/>
	  				Total: ${entry.key.getCost()*entry.value}</br>
	  				<button type="submit" name="removeServ" value="${entry.key.getId()}">Remove</button>
	  			</c:if>
  			</div>
			</c:forEach>
			</form>
				<h1>Total:${myCart.totalCost()}</h1>
			</div>
		<a href="EnterProduct.jsp">Enter new product</a>
		<a href="EnterService.jsp">Enter new service</a>
		</div>
</body>
</html>