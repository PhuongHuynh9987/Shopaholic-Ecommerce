package servlets;
import shopaholicjava.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public EditCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {	
    	getCartItems(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = request.getParameter("action");
		
		if (delete.equals("delete")){
			deleteCartItems(request, response);
			response.sendRedirect("EditCartServlet");
		}
		else {
			getCartItems(request, response);
		}
	
	}
	
	private void deleteCartItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CID =(String) request.getSession().getAttribute("CID");
		
		String PID = request.getParameter("PID");
		String deleteQuery = "Delete From CartProducts where CID =? AND PID = ?";
		
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(deleteQuery);) {
			statement.setString(1, CID);
			statement.setString(2, PID);
			
            statement.executeUpdate();
            
		} catch (SQLException e) {
			System.out.print(e);
            e.printStackTrace();
        }
		
	}

	private void getCartItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String CID =(String) request.getSession().getAttribute("CID");
    	ArrayList<CartProduct> cartItems = new ArrayList<CartProduct>();

        String selectQuery = "SELECT * FROM CartProducts WHERE CID = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(selectQuery);) {
			statement.setString(1, CID);
            ResultSet resultSet = statement.executeQuery();
            Float total = (float) 0.0;
            while (resultSet.next()) {
                String PID = resultSet.getString("PID");
                String ProductName = resultSet.getString("ProductName");
                String ProductType = resultSet.getString("ProductType");
                String image = resultSet.getString("Img");
                String Price = resultSet.getString("TotalPrice");
                Float price = Float.valueOf(Price);
               
                int quantity = resultSet.getInt("Quantity");
                
            	CartProduct cart = new CartProduct();
            	cart.setProductId(PID);
            	cart.setQuantity(quantity);
            	cart.setPrice(price);
            	cart.setProductName(ProductName);
            	cart.setProductType(ProductType);
            	cart.setImg(image);
            	
            	total = total+price;
            	cartItems.add(cart);
            }

            request.setAttribute("cartdata", cartItems);
            request.setAttribute("total", total);
            
           
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cart.jsp");
			rd.forward(request, response);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
    }


}
