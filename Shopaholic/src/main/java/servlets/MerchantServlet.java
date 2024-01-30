package servlets;
import shopaholicjava.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;


@MultipartConfig 
public class MerchantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		viewProducts(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
        	// Invalid action, redirect to the main page
            response.sendRedirect("MerchantServlet");
  
        } else if (action.equals("add")) {        	
            addProduct(request, response);
        }
        
        else if (action.equals("addPage")){
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addnewproduct.jsp");
            rd.forward(request, response);
        }
        
        else if (action.equals("Delete")) {
        	delete(request, response);
        }
       
        else {
        	update(request, response);
        }        
    }

    
    private void viewProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     	
    	try (Connection con = DatabaseConnection.getConnection();) {
         
    		String MID = (String) request.getSession().getAttribute("MID");         	
         	
            List<Product> products = new ArrayList<>();
              
           // Get all products associated with the merchant from the MerchantProducts table
              String query = "SELECT * FROM Products p " +
                             "JOIN MerchantProducts mp ON p.PID = mp.PID " +
                             "WHERE (mp.MID) = (?) ";
		
              try (PreparedStatement statement = con.prepareStatement(query)) {
                  statement.setString(1, MID);
                  ResultSet resultSet = statement.executeQuery();
                  
                  while (resultSet.next()) {
                      Product product = new Product();
                      product.setPID(resultSet.getString("PID"));            
                      product.setProductName(resultSet.getString("ProductName"));
                      product.setProductType(resultSet.getString("ProductType"));
                      String price = resultSet.getString("Price");
                      Float Price = Float.valueOf(price);
                      product.setPrice(Price);
                      product.setImg(resultSet.getString("Img"));
                      
                      products.add(product);
                  }
                  
               // Set the products as a request attribute to be displayed in the JSP
                  HttpSession session = request.getSession(true);
                  session.setAttribute("merchantdata",  products);
                  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/merchanthomepage.jsp");
//                  request.getSession().setAttribute("MID", MID);
                  rd.forward(request, response);
              }
              
          } catch (SQLException e) {
              e.printStackTrace();
              response.getWriter().println("Error occurred while fetching data from the database.");
          }
   
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String MID = (String) request.getSession().getAttribute("MID");
        String ProductName = request.getParameter("productName");
        String ProductType = request.getParameter("productType");
        String price = request.getParameter("price");
        Float Price = Float.parseFloat(price);
        Part File =  request.getPart("imageFile");
        String fileName = File.getSubmittedFileName();
        String imagePath = "/Users/huynhphuong/Desktop/Java-Developer/Shopaholic/src/main/webapp/images/"+fileName;

//		System.out.println(product.getPID());
        try (Connection con = DatabaseConnection.getConnection();) {
            // Insert the new product into the Products table
          	          	
            String insertQuery = "INSERT INTO Products (ProductName, ProductType, Price, Img) VALUES (?, ?,  ?, ?)";
            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                insertStatement.setString(1, ProductName);
                insertStatement.setString(2, ProductType);
                insertStatement.setString(3, price);
                insertStatement.setString(4, "images/"+fileName); 

                insertStatement.executeUpdate();

                // Adding product
                Product product = new Product();
                product.setProductName(ProductName);
                product.setProductType(ProductType); 
                product.setPrice(Price);
                product.setImg("images/"+fileName);
                
                // Load file into images folder
                try {
	                FileOutputStream fos = new FileOutputStream(imagePath);
	                InputStream in = File.getInputStream();
	               
	                byte[] data = new byte[in.available()];
	                in.read(data);
	                fos.write(data);
	                fos.flush();
	                fos.close(); 
                }
                catch (Exception e) {
                	e.printStackTrace();
                }
                
                // Get product ID
                PreparedStatement PID_statement = con.prepareStatement("Select PID from Products WHERE ProductName = ? AND ProductType = ?; ");
                
                PID_statement.setString(1, ProductName);
                PID_statement.setString(2, ProductType);
  
                ResultSet r = null;
				r = PID_statement.executeQuery();
				
				while(r.next()){
					String PID = r.getString("PID");
					product.setPID(PID);
				}
		
				r.close();
				
              
			
                 // Insert the product into the MerchantProducts table to associate it with the merchant
                String linkQuery = "INSERT INTO MerchantProducts (MID, PID) VALUES (?, ?)";
                try (PreparedStatement linkStatement = con.prepareStatement(linkQuery)) {
                    linkStatement.setString(1, MID);
                    linkStatement.setString(2, product.getPID());
                    linkStatement.executeUpdate();
                }
           
            }

            // Redirect back to the main page to view all products
            response.sendRedirect("MerchantServlet");
            
           
        } catch (SQLException e) {
        	System.out.println(e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addproducterror.jsp");
			dispatcher.forward(request, response);
        }
    }

	protected void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PID = (String)request.getSession().getAttribute("PID");
		System.out.print(PID);
		
		try (Connection con = DatabaseConnection.getConnection();){		
		  	String statement = "Delete From Products WHERE PID = ?; ";
			PreparedStatement update = con.prepareStatement(statement);
			
	
			update.setString(1, PID);
			update.executeUpdate();
			

         
            response.sendRedirect("MerchantServlet");
	  	}
	  	
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	
		
	protected void update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String PID = (String)request.getSession().getAttribute("PID");
	  	String productType = request.getParameter("productType");
	  	String productName = request.getParameter("productName");
	  	String price = request.getParameter("price");
	  	
	  	Part File =  request.getPart("imageFile");
        String fileName = File.getSubmittedFileName();
        String imagePath = "/Users/huynhphuong/Desktop/Java-Developer/Shopaholic/src/main/webapp/images/"+fileName;
	  	
//	  	String imageFile = request.getParameter("imageFile");

	  	if (fileName.isEmpty()) {
	  		fileName = request.getParameter("image");
	  	}
	  	fileName = "images/" + fileName;
	  	
	  	try (Connection con = DatabaseConnection.getConnection();){		
		  	String statement = "Update Products SET ProductName = ?,ProductType = ?, Price = ?, Img = ? WHERE PID = ?; ";
			PreparedStatement update = con.prepareStatement(statement);
			
			update.setString(1, productName);
			update.setString(2, productType);
			update.setString(3, price);
			update.setString(4, fileName);
			update.setString(5, PID);
			update.executeUpdate();
			

            // Load file into images folder
            try {
                FileOutputStream fos = new FileOutputStream(imagePath);
                InputStream in = File.getInputStream();
                
                
                byte[] data = new byte[in.available()];
                in.read(data);
                fos.write(data);
                fos.flush();
                fos.close();
                
                
            }
            catch (Exception e) {
            	System.out.println(e);
            	e.printStackTrace();
            }
            response.sendRedirect("MerchantServlet");
	  	}
	  	
		catch(Exception e) {
		e.printStackTrace();
		}
	}
    
}
