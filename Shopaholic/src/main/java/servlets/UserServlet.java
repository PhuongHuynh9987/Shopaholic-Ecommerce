package servlets;
import shopaholicjava.*;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("UID");
		String UID = (String) request.getSession(false).getAttribute("UID");
		String UserName = (String) request.getSession(false).getAttribute("UserName");
		String CID = (String) request.getSession(false).getAttribute("CID");
		
		
		try {
			ArrayList<Product> products = new ArrayList<Product>();
			try (Connection con = DatabaseConnection.getConnection();
					Statement s = con.createStatement();
					ResultSet resultSet = s.executeQuery("SELECT * FROM Products");){
				
				if(resultSet.equals(null)) {
					System.out.println("resultSet is null");
				}
				
				while(resultSet.next()) {
					Product product = new Product();
					String PID = resultSet.getString("PID");
					String ProductName = resultSet.getString("ProductName");
					String Price = resultSet.getString("Price");
					String ProductType = resultSet.getString("ProductType");
					String Img = resultSet.getString("Img");
					
					product.setPID(PID);
					product.setProductName(ProductName);
					product.setProductType(ProductType);
					product.setPrice(Price);
					product.setImg(Img);
					products.add(product);
				
				} 
				
				request.setAttribute("UID", UID);
				request.setAttribute("UserName", UserName);			
				request.setAttribute("CID", CID);
				request.setAttribute("productdata", products);
			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/userhomepage.jsp");
				rd.forward(request, response);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
