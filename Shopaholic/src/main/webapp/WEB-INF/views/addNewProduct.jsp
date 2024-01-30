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
			
			<div>
				<form action="LogoutServlet">
					<input type = "hidden" name = "UserType" value = "Merchant">
					<button type="submit" class='signout'>Sign Out</button>
				</form>
			</div>
			
			<div class='homepage'>
				<a href="MerchantServlet">Homepage</a>
			</div>
		</div>
		
		<div>
			<h1>Adding a New Product</h1>
	        <form action="MerchantServlet" method="post" name="Form"  enctype = "multipart/form-data" onsubmit="return validateForm()">
	       		<input type="hidden" name="action" value="add">	
				<table>
					<tr>
						<td>Product Type</td>
						<td><input type="text" name="productType" onkeypress="removeElert()"/></td>
					</tr>
					
					<tr>
						<td>Product Name</td>
						<td><input type="text" name="productName" onkeypress="removeElert()"/></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="price" onkeypress="removeElert()" /></td>
					</tr>

					<tr>
						<td>Product Image</td>
						<td><input type="file" name="imageFile" onkeypress="removeElert()"/></td>
					</tr>

				</table>
				<span class="emptyField">Please Fill In All Required Fields!</span>
				<input type="submit" value="Submit" class ="addProduct" />
			</form>
			<div class = "footer">
				<a href="MerchantServlet">Cancel</a>
			</div>
		</div>
	</div>
	
	<script  type="text/javascript">
	 	var emptyField = document.querySelector(".emptyField");
	
		function validateForm() {
		    var a = document.forms["Form"]["productType"].value;
		    var b = document.forms["Form"]["productName"].value;
		    var c = document.forms["Form"]["price"].value;
		    var d = document.forms["Form"]["imageFile"].value;
		   
		    if ((a == null || a == "") || (b == null || b == "") || (c == null || c == "") || (d == null || d == "")) {
		    	emptyField.classList.add("active");	  
		    	return false;
		    }
		    else {
		    	return true;
		    }
		 }
		
		 function removeElert() {
			emptyField.classList.remove("active");	
		 }
		
	</script>


</body>
</html>