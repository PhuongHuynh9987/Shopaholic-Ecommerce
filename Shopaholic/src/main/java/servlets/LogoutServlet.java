package servlets;
import shopaholicjava.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
//@WebServlet("/LogoutServlet")

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
	} 

	/**
	 * @see HttpServlet#getPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  = request.getSession();
		session.invalidate();
		
		String UserType= request.getParameter("UserType");
		
		if (UserType.equals("User")) {
			response.sendRedirect("login.jsp");
		}
		else {
			response.sendRedirect("merchantlogin.jsp");
		}
		
		
		
	}

}