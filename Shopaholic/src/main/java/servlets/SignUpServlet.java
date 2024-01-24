package servlets;
import shopaholicjava.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */

//@WebServlet("/SignUpServlet")

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/webapp/createaccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String UserName = request.getParameter("UserName");
		String Email = request.getParameter("email");
		String UserPassword = request.getParameter("password");
		String UserType = request.getParameter("UserType");

		User user = new User();
		Cart cart = new Cart();
		Merchant merchant = new Merchant();
		if(UserType.equals("User")) {
			LocalDateTime now = LocalDateTime.now();  
			user.setFirstName(FirstName);
			user.setLastName(LastName);
			user.setUserName(UserName);
			user.setUserEmail(Email);
			user.setUserPassword(UserPassword);
			user.setJoinDate(now.toString());
		}
		
		else if(UserType.equals("Merchant")) {
			LocalDateTime now = LocalDateTime.now();  
			merchant.setFirstName(FirstName);
			merchant.setLastName(LastName);
			merchant.setUserName(UserName);
			merchant.setUserEmail(Email);
			merchant.setUserPassword(UserPassword);
			merchant.setJoinDate(now.toString());
		}
		
		boolean approved = true;
		try (Connection con = DatabaseConnection.getConnection();
			PreparedStatement userpst = 
					con.prepareStatement("INSERT INTO MemberUsers (FirstName, LastName, UserName,Email, UserPassword, JoinDate) VALUES ( ?, ?, ?, ?, ?,?);");
			PreparedStatement cartpst = 
					con.prepareStatement("INSERT INTO Cart (UID) VALUES(?)");
			PreparedStatement merchantpst = 
					con.prepareStatement("INSERT INTO Merchants (FirstName, LastName, UserName, Email, UserPassword, JoinDate) VALUES ( ?, ?, ?, ?,?,?);");
			PreparedStatement uid = con.prepareStatement("SELECT UID FROM MemberUsers WHERE (UserName) = (?) AND (Email) = (?);");
			PreparedStatement mid = con.prepareStatement("SELECT MID FROM Merchants WHERE (UserName) = (?) AND (Email) = (?);");
			PreparedStatement cid = con.prepareStatement("SELECT CID FROM Cart WHERE UID = ?;");
			){

			int resultSet = 0;
			if(UserType.equals("User")) {
				userpst.setString(1, user.getFirstName());
				userpst.setString(2, user.getLastName());
				userpst.setString(3, user.getUserName());
				userpst.setString(4, user.getUserEmail());
				userpst.setString(5, user.getUserPassword());
				userpst.setString(6, user.getJoinDate());				
					
				//Check if information is empty
				if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() 
						|| user.getUserName().isEmpty() ||user.getUserEmail().isEmpty()  
						|| user.getUserPassword().isEmpty() || user.getJoinDate().isEmpty()) {
					approved = false;	
				}
				
				
				else {
					//Check for duplicate user account information
					try {		
						// Get and set user ID
						resultSet = userpst.executeUpdate();  //this will excute the insertion query first
		
						ResultSet rs = null;        		 //then we will have the information to update cart
						uid.setString(1, user.getUserName());
						uid.setString(2, user.getUserEmail());
						rs = uid.executeQuery();
						while (rs.next()) {
							String UID = rs.getString("UID");
							user.setUID(UID);
						}

						rs.close();
						// get and set card ID
						cartpst.setString(1, user.getUID().toString());
						cartpst.executeUpdate();
						
						ResultSet r = null;        		 //then we will have the information to update cart
						cid.setString(1, user.getUID());
						r = cid.executeQuery();
						System.out.println(r.next());
						while (r.next() == true) {
							String CID = rs.getString("CID");
							cart.setCartId(CID);
						}
						
						r.close();
							
						HttpSession session = request.getSession(true);
						session.setAttribute("UID", user.getUID());
						session.setAttribute("UserName", user.getUserName());
						session.setAttribute("CID", cart.getCartId());
						
					}
					catch(SQLException e) {
						approved = false;
					}
				}
			}
			else if(UserType.equals("Merchant")) {
				merchantpst.setString(1, merchant.getFirstName());
				merchantpst.setString(2, merchant.getLastName());
				merchantpst.setString(3, merchant.getUserName());
				merchantpst.setString(4, merchant.getUserEmail());
				merchantpst.setString(5, merchant.getUserPassword());
				merchantpst.setString(6, merchant.getJoinDate());	
				
				
				
//				session.setAttribute(ID, merchant.getMID());
//				session.setAttribute(FirstName, merchant.getFirstName());
//				session.setAttribute(LastName, merchant.getLastName());
//				session.setAttribute(UserName, merchant.getUserName());
//				session.setAttribute(UserPassword, merchant.getUserPassword());
								
				//Check if information is empty
				if(merchant.getFirstName().isEmpty() || merchant.getLastName().isEmpty()
						|| merchant.getUserName().isEmpty() || merchant.getUserPassword().isEmpty()) {
					approved = false;
				}
				else {
					//Check for duplicate user account information
					try {						
						resultSet = merchantpst.executeUpdate();
						
						ResultSet rs = null;        		 //then we will have the information to update cart
						mid.setString(1, merchant.getUserName());
						mid.setString(2, merchant.getUserEmail());
						rs = mid.executeQuery();
						while (rs.next()) {
							String MID = rs.getString("MID");
							merchant.setMID(MID);
						}
						System.out.println(merchant.getMID());
						rs.close();
						
						HttpSession session = request.getSession();
						session.setAttribute("MerchantName", merchant.getUserName());
						session.setAttribute("MID", merchant.getMID());
					}
					catch(SQLException e) {
						System.out.print(e);
						approved = false;
					}
				}
			} 
			
			//Determine if new account information is approved or not
			if(approved == false) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/createaccounterror.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(approved == true) {
				if(UserType.equals("User")) {
					response.sendRedirect("UserServlet");
				}
				else if(UserType.equals("Merchant")) {
					response.sendRedirect("MerchantServlet");
				}
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
