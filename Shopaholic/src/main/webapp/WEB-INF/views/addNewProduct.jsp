<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="shopaholicjava.*"%>
<%@ page import = "javax.servlet.http.*" %>


<html>
<head>
<meta charset="UTF-8">
<!-- Favicon -->
<link rel = "icon" type = "image/x-icon" href = "asset/favicon.ico"/>
<!-- Font Awesome icons (free version) -->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin = "anonymous"></script>
<!--Google fonts  -->
<link href = "https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type = text/css />
<!-- Core theme CSS (bootstrap) -->	
<link href = "style.css" rel="stylesheet"/>
<!-- <meta charset="ISO-8859-1"> -->
<title>Adding a New Product</title>
</head>
<body>
	<div class='body'>
		<div class='navbar'>
			<div class='logo'>
				<img src="images/logo.png" alt="logo">
			</div>
			<div class='searchbar'>
				<input type="text" placeholder="Search..">
			</div>
			
			<div class='signin'>
				<a href="LogoutServlet"><button>Log Out</button></a>
			</div>
			
			<div class='homepage'>
				<a href="MerchantServlet">Homepage</a>
			</div>
		</div>
		
		<div>
			<h1>Product Register Form</h1>
	        <form action="MerchantServlet" method="post"  enctype = "multipart/form-data">
	       		<input type="hidden" name="action" value="add">	
				<table style="with: 80%">
					<tr>
						<td>Product Type</td>
						<td><input type="text" name="productType" /></td>
					</tr>
					
					<tr>
						<td>Product Name</td>
						<td><input type="text" name="productName" /></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="price" /></td>
					</tr>

					<tr>
						<td>Product Image</td>
						<td><input type="file" name="imageFile"/>	</td>
					</tr>
				</table>
				<input type="submit" value="Submit" />
			</form>
		</div>
	</div>


</body>
</html>