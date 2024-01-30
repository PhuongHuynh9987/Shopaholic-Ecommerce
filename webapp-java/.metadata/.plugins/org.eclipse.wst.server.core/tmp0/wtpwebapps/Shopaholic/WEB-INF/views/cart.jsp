<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%@ page import="shopaholicjava.*"%>
<head>
<meta name = "viewport" 
	content = "width = device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="author" content = "" />

<!-- Favicon -->
<link rel = "icon" type = "image/x-icon" href = "asset/favicon.ico"/>
<!-- Font Awesome icons (free version) -->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin = "anonymous"></script>
<!--Google fonts  -->
<link href = "https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type = text/css />
<!-- Core theme CSS (bootstrap) -->	
<link href = "style.css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<div class='body'>
		<div class='shopping-cart'>
			<div class = "top">
				<h3>Cart</h3>
				<div>
					<form action="UserServlet">
						<button type="submit" class="cartCancel">X</button>
					</form>
				</div>
			</div>
			<hr>
			
		<%ArrayList<CartProduct> products = (ArrayList<CartProduct>) request.getAttribute("cartdata");
		
		  Iterator<CartProduct> items = products.iterator();
		  
		  while (items.hasNext()){
			  CartProduct item = items.next();
			  String PID = item.getProductId();
			  Float price= item.getPrice();
			  String Price = price.toString();

			  Float total = (Float)request.getAttribute("total");
			  String Total = total.toString();
			%>
			<div class='items'>
				<div class="image">
					<img src=<%=item.getImg()%>>
				
				</div>
				<div class='left'>
					
					<h3><%=item.getProductName()%></h3>
					<h5>Quantity: <%=item.getQuantity() %></h5>
				</div>
				<div class='right'>
					<form action = "EditCartServlet" method = "post" >
						<input type= "hidden" name = "action" value = "delete"> 
						<button type ="submit" name = "PID" value = <%=PID%> class="cartCancel">X</button>
					</form>
					<h3>Subtotal: $ <%=Price %></h3>
				</div>

			</div>
			<%}%>


			<hr>
			<div style="text-align: right">
				<h3>Total: $ <%= (Float)request.getAttribute("total") %></h3>
			</div>

		</div>
	</div>
	
	

	

</body>
</html>
