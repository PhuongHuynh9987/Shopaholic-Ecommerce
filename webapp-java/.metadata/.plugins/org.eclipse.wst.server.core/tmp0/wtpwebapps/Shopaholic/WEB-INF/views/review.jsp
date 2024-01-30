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
<title>View A Product</title>
</head>
<body>
<% 

	String PID = (String) request.getAttribute("PID");
	String UserName = (String) request.getAttribute("UserName");
	String ProductName = (String) request.getAttribute("ProductName");
	String ProductType = (String) request.getAttribute("ProductType");
	Float price = (Float) request.getAttribute("price");
	String Img = (String) request.getAttribute("Img");	
%>

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
					<input type = "hidden" name = "UserType" value = "User">
					<button type="submit" class='signout'>Sign Out</button>
				</form>
			</div>
			
			<div>
				<h3><%=session.getAttribute("FirstName")%></h3>	
			</div>
		</div>
		
		
		<div class='product-info'>
			<img src=<%=Img %> >
			<div class='product-detail'>
				
				<h2>Product Name: <%=ProductName %></h2>
				<h5>Product Type:  <%=ProductType %></h5>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
				It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
				 It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, 
				 and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
				 </p>
				  <h3>Price: $<%=price %></h3>

				
			</div>
		</div>
		<div class='homepage'>
			<a href="UserServlet">Return</a>
		</div>
		
		
		<!----------  Review section -------->
		<div class="review-section">
			<h2>Add Review</h2>
			<span class="emptyField">Please add a review!!</span>
			<form action="UserServlet" method="post" onsubmit = "return validateForm()">
				<input type="hidden" name="action" value = "review">
				<input type="hidden" name="PID" value = <%=PID%>>
				Description:	
				<input name = "description" id = "description" onkeypress="removeElert()" >
				<button type="submit">Add Review</button>
			</form> 
	
		</div>
	</div>
		
	<script  type="text/javascript">
	 	var emptyField = document.querySelector(".emptyField");
	 	
	 	
	 	console.log(productType);
	 	
		function validateForm() {
			var a = document.getElementById("description").value;
		    
		    if ((a == null || a == "")) {
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