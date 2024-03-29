package servlets;
import shopaholicjava.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edituser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cancelButton = request.getParameter("Cancel");
		
		//If CANCEL button is clicked, go back to homepage
        if ("Cancel".equals(cancelButton)) {
        	this.cancel(request, response);
        }
        //Else, continue to change info
        else {
    		String UID = request.getParameter("UID");
    		String FirstName = request.getParameter("FirstName");
    		String LastName = request.getParameter("LastName");
    		String UserName = request.getParameter("UserName");
    		String UserPassword = request.getParameter("UserPassword");
    		
    		try (Connection con = DatabaseConnection.getConnection();){
    			PreparedStatement pst = con.prepareStatement("UPDATE MemberUsers SET FirstName = ?, LastName = ?, UserName = ?, UserPassword = ? WHERE UID = ?;");
    			pst.setString(1, FirstName);
    			pst.setString(2, LastName);
    			pst.setString(3, UserName);
    			pst.setString(4, UserPassword);
    			pst.setString(5, UID);
    			pst.executeUpdate();
//    			System.out.println("Executed update query");
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		response.sendRedirect("AdminServlet");
        }

	}
	 
	protected void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AdminServlet");
	}

}
