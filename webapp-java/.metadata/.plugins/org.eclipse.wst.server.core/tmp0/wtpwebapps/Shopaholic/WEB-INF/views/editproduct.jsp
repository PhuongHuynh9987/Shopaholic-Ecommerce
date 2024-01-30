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
<title>Editing a Product</title>
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
			<h1>Updating Product</h1>
			<%
					String ProductName = (String)request.getAttribute("ProductName");
					String ProductType = (String)request.getAttribute("ProductType");
					Float price = (Float)request.getAttribute("Price");
					String Price = price.toString();
					String Img = (String)request.getAttribute("Img");
					String PID = (String)request.getAttribute("PID");
					%>
	        <form action="MerchantServlet" method="post" name = "Form" enctype = "multipart/form-data" onsubmit="return validateForm()">
	       		<input type="hidden" name="action" value = <%=PID%> >	
				<table>
					<tr>	
						<td>Product Type</td>
						<td><input type="text" name="productType" id = "productType" value = "<%=ProductType%>" onkeypress="removeElert()"/></td>
					</tr>
					
					<tr>
						<td>Product Name</td>
						<td><input type="text" name="productName" id = "productName" value = <%=ProductName%> onkeypress="removeElert()" /></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="price"  id = "price"  value = <%=Price%> onkeypress="removeElert()" /></td>
					</tr>
	
					 <tr>
						<td>Old Image File Name</td>
						<td><input type="text" name="image" id = "image" value = <%=Img.replace("images/","") %>  onkeypress="removeElert()"/></td>
					</tr>
					
					<tr>
						<td>Product Image</td>
						<td><input type="file" name="imageFile"/> </td>
					</tr>
					
				</table>
				<span class="emptyField">Please Fill In All Required Fields!</span>
				<input type="submit" value="Update Product" class= "addProduct"/>
			</form>
		
		</div>
		<div class = "footer">
				<a href="MerchantServlet">Cancel</a>
				
				<form action="MerchantServlet" method="post">
					<input type="hidden" name="action" value="Delete">
					<button type="submit">Delete</button>
				</form> 
			</div>
	</div>
	
	<script  type="text/javascript">
	 	var emptyField = document.querySelector(".emptyField");
	 	
	 	console.log(productType);
	 	
		function validateForm() {
			var a = document.getElementById("productType").value;
			var b = document.getElementById("productName").value;
			var c = document.getElementById("price").value;
			var d = document.getElementById("image").value;
		   
		    
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