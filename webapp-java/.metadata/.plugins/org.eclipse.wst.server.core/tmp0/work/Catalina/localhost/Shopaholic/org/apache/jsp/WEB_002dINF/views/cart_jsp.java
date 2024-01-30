/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-01-29 23:13:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import shopaholicjava.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta name = \"viewport\" \n");
      out.write("	content = \"width = device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("<meta name=\"author\" content = \"\" />\n");
      out.write("\n");
      out.write("<!-- Favicon -->\n");
      out.write("<link rel = \"icon\" type = \"image/x-icon\" href = \"asset/favicon.ico\"/>\n");
      out.write("<!-- Font Awesome icons (free version) -->\n");
      out.write("<script src=\"https://use.fontawesome.com/releases/v5.15.4/js/all.js\" crossorigin = \"anonymous\"></script>\n");
      out.write("<!--Google fonts  -->\n");
      out.write("<link href = \"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type = text/css />\n");
      out.write("<!-- Core theme CSS (bootstrap) -->	\n");
      out.write("<link href = \"style.css\" rel=\"stylesheet\"/>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>Shopping Cart</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class='body'>\n");
      out.write("		<div class='shopping-cart'>\n");
      out.write("			<div class = \"top\">\n");
      out.write("				<h3>Cart</h3>\n");
      out.write("				<div>\n");
      out.write("					<form action=\"UserServlet\">\n");
      out.write("						<button type=\"submit\" class=\"cartCancel\">X</button>\n");
      out.write("					</form>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("			<hr>\n");
      out.write("			\n");
      out.write("		");
ArrayList<CartProduct> products = (ArrayList<CartProduct>) request.getAttribute("cartdata");
		
		  Iterator<CartProduct> items = products.iterator();
		  
		  while (items.hasNext()){
			  CartProduct item = items.next();
			  String PID = item.getProductId();
			  Float price= item.getPrice();
			  String Price = price.toString();

			  Float total = (Float)request.getAttribute("total");
			  String Total = total.toString();
			
      out.write("\n");
      out.write("			<div class='items'>\n");
      out.write("				<div class=\"image\">\n");
      out.write("					<img src=");
      out.print(item.getImg());
      out.write(">\n");
      out.write("				\n");
      out.write("				</div>\n");
      out.write("				<div class='left'>\n");
      out.write("					\n");
      out.write("					<h3>");
      out.print(item.getProductName());
      out.write("</h3>\n");
      out.write("					<h5>Quantity: ");
      out.print(item.getQuantity() );
      out.write("</h5>\n");
      out.write("				</div>\n");
      out.write("				<div class='right'>\n");
      out.write("					<form action = \"EditCartServlet\" method = \"post\" >\n");
      out.write("						<input type= \"hidden\" name = \"action\" value = \"delete\"> \n");
      out.write("						<button type =\"submit\" name = \"PID\" value = ");
      out.print(PID);
      out.write(" class=\"cartCancel\">X</button>\n");
      out.write("					</form>\n");
      out.write("					<h3>Subtotal: $ ");
      out.print(Price );
      out.write("</h3>\n");
      out.write("				</div>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("			<hr>\n");
      out.write("			<div style=\"text-align: right\">\n");
      out.write("				<h3>Total: $ ");
      out.print( (Float)request.getAttribute("total") );
      out.write("</h3>\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	\n");
      out.write("	\n");
      out.write("\n");
      out.write("	\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
