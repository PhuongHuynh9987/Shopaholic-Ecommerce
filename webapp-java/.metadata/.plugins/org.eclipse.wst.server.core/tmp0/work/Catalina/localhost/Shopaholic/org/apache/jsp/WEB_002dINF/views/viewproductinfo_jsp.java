/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-01-30 18:09:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import shopaholicjava.*;
import javax.servlet.http.*;

public final class viewproductinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("shopaholicjava");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<!-- Favicon -->\n");
      out.write("<link rel = \"icon\" type = \"image/x-icon\" href = \"asset/favicon.ico\"/>\n");
      out.write("<!-- Font Awesome icons (free version) -->\n");
      out.write("<script src=\"https://use.fontawesome.com/releases/v5.15.4/js/all.js\" crossorigin = \"anonymous\"></script>\n");
      out.write("<!--Google fonts  -->\n");
      out.write("<link href = \"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type = text/css />\n");
      out.write("<!-- Core theme CSS (bootstrap) -->	\n");
      out.write("<link href = \"style.css\" rel=\"stylesheet\"/>\n");
      out.write("<!-- <meta charset=\"ISO-8859-1\"> -->\n");
      out.write("<title>View A Product</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
 

	String PID = (String) request.getAttribute("PID");
	String UserName = (String) request.getAttribute("UserName");
	String ProductName = (String) request.getAttribute("ProductName");
	String ProductType = (String) request.getAttribute("ProductType");
	Float price = (Float) request.getAttribute("price");
	String Img = (String) request.getAttribute("Img");	

      out.write("\n");
      out.write("\n");
      out.write("	<div class='body'>\n");
      out.write("		<div class='navbar'>\n");
      out.write("			<div class='logo'>\n");
      out.write("				<img src=\"images/logo.png\" alt=\"logo\">\n");
      out.write("			</div>\n");
      out.write("			<div class='searchbar'>\n");
      out.write("				<input type=\"text\" placeholder=\"Search..\">\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<div>\n");
      out.write("				<form action=\"LogoutServlet\">\n");
      out.write("					<input type = \"hidden\" name = \"UserType\" value = \"User\">\n");
      out.write("					<button type=\"submit\" class='signout'>Sign Out</button>\n");
      out.write("				</form>\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<div>\n");
      out.write("				<h3>");
      out.print(session.getAttribute("FirstName"));
      out.write("</h3>	\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class='homepage'>\n");
      out.write("			<a href=\"UserServlet\">X</a>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class='product-info'>\n");
      out.write("			<img src=");
      out.print(Img );
      out.write(" >\n");
      out.write("			<div class='product-detail'>\n");
      out.write("				<h2>Product Name: ");
      out.print(ProductName );
      out.write("</h2>\n");
      out.write("				<h5>Product Type:  ");
      out.print(ProductType );
      out.write("</h5>\n");
      out.write("				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n");
      out.write("				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, \n");
      out.write("				when an unknown printer took a galley of type and scrambled it to make a type specimen book. \n");
      out.write("				It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.\n");
      out.write("				 It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, \n");
      out.write("				 and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n");
      out.write("				 </p>\n");
      out.write("				 \n");
      out.write("				 <div >\n");
      out.write("				  	<h3>Price: $");
      out.print(price );
      out.write("</h3>\n");
      out.write("				  	<div class=\"buttons\">\n");
      out.write("					  	<form action=\"AddToCartServlet\" method=\"post\">\n");
      out.write("							<input type=\"hidden\" name=\"action\" value= \"AddToCart\">\n");
      out.write("							<button type=\"submit\" name=\"add\" value = ");
      out.print(PID);
      out.write(" class=\"addToCart\">Add to Cart</button>\n");
      out.write("						</form>\n");
      out.write("					  	<form action = \"UserServlet\" method = \"post\">\n");
      out.write("					  		<input type= \"hidden\" name = \"PID\" value = ");
      out.print(PID );
      out.write(">\n");
      out.write("					  		<input type= \"hidden\" name = \"action\" value = \"addReview\">\n");
      out.write("					  		<button type = \"submit\" class=\"addToCart\">Add a review</button>\n");
      out.write("					  	</form>\n");
      out.write("				  	</div>\n");
      out.write("				 </div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		<!----------  Review section -------->\n");
      out.write("		<div class=\"review-section\">\n");
      out.write("			<h1>Product's Reviews</h1>\n");
      out.write("			<table border=\"1\" width=\"500\" align=\"center\">\n");
      out.write("				<th>Review ID</th>\n");
      out.write("				<th>Product ID</th>\n");
      out.write("				<th>Author</th>\n");
      out.write("				<th>Product Name</th>\n");
      out.write("				<th>Description</th>\n");
      out.write("				<th>Star (From 1 to 5 Stars)</th>\n");
      out.write("	\n");
      out.write("				");
      out.write("\n");
      out.write("			</table>\n");
      out.write("	\n");
      out.write("			<!-- <h2>Add Review</h2>\n");
      out.write("			<form action=\"ReviewServlet\" method=\"post\">\n");
      out.write("				<input type=\"hidden\" name=\"action\" value=\"add\"> <label\n");
      out.write("					for=\"RID\">Review ID</label> <input type=\"text\" name=\"RID\" required><br>\n");
      out.write("				<label for=\"PID\">Product ID</label> <input type=\"text\" name=\"PID\"\n");
      out.write("					required><br> <label for=\"Author\">Author</label> <input\n");
      out.write("					type=\"text\" name=\"Author\" required><br> <label\n");
      out.write("					for=\"ProductName\">Product Name</label> <input type=\"text\"\n");
      out.write("					name=\"ProductName\" required><br> <label\n");
      out.write("					for=\"Description\">Description</label> <input type=\"text\"\n");
      out.write("					name=\"Description\" required><br> <label for=\"Star\">Star</label>\n");
      out.write("				<input type=\"number\" name=\"Star\" required><br>\n");
      out.write("				<button type=\"submit\">Add Review</button>\n");
      out.write("			</form> -->\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("		\n");
      out.write("	<script  type=\"text/javascript\">\n");
      out.write("	 	var emptyField = document.querySelector(\".emptyField\");\n");
      out.write("	 	\n");
      out.write("	 	\n");
      out.write("	 	console.log(productType);\n");
      out.write("	 	\n");
      out.write("		function validateForm() {\n");
      out.write("			var a = document.getElementById(\"description\").value;\n");
      out.write("		    \n");
      out.write("		    if ((a == null || a == \"\")) {\n");
      out.write("		    	emptyField.classList.add(\"active\");	\n");
      out.write("		    	return false;\n");
      out.write("		    }\n");
      out.write("		    else {\n");
      out.write("		    	return true;\n");
      out.write("		    }\n");
      out.write("		 }\n");
      out.write("		\n");
      out.write("		 function removeElert() {\n");
      out.write("			emptyField.classList.remove(\"active\");	\n");
      out.write("		 }\n");
      out.write("		\n");
      out.write("	</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
