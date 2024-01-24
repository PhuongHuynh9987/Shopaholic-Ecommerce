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
            // Default action: view all products associated with the merchant
//            viewProducts(request, response);
            
        } else if (action.equals("add")) {        	
            addProduct(request, response);
        }
        
        else if (action.equals("addPage")){
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addNewProduct.jsp");
            rd.forward(request, response);
        }
        else {
            // Invalid action, redirect to the main page
            response.sendRedirect("MerchantServlet");
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
                      product.setPrice(resultSet.getString("Price"));
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
        String Price = request.getParameter("price");
        Part File =  request.getPart("imageFile");
        String fileName = File.getSubmittedFileName();
        String imagePath = "/Users/huynhphuong/Desktop/Java-Developer/Shopaholic/src/main/webapp/images/"+fileName;

        try (Connection con = DatabaseConnection.getConnection();) {
            // Insert the new product into the Products table
          	          	
            String insertQuery = "INSERT INTO Products (ProductName, ProductType, Price, Img) VALUES (?, ?,  ?, ?)";
            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                insertStatement.setString(1, ProductName);
                insertStatement.setString(2, ProductType);
                insertStatement.setString(3, Price);
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
					System.out.println(fos); 
	                fos.flush();
	                fos.close();
	                
	                
                }
                catch (Exception e) {
                	System.out.println(e);
                	e.printStackTrace();
                }

//                try{
//                    in = new FileInputStream(new File("C:\\Users\\ganesh.r\\Desktop\\My Stuff\\dp.jpeg"));
//                    out = new FileOutputStream("TestImage.jpeg");
//                    while((cursor = in.read())!=-1){
//                        out.write(cursor);
//                    }
//                }
//                finally{
//                    if(in!=null){
//                        in.close();
//                    }
//                    if(out!=null){
//                        out.close();
//                    }
//                    System.out.println("Read and Write complete");
//                }
//            
//                 
                
                // Get product ID
                PreparedStatement PID_statement = con.prepareStatement("Select PID from Products WHERE ProductName = ? AND ProductType = ? AND Price = ?;");
               
                PID_statement.setString(1, ProductName);
                PID_statement.setString(2, ProductType);
                PID_statement.setString(3, Price);
  
                ResultSet r = null;
				r = PID_statement.executeQuery();
				
				while(r.next()){
					String PID = r.getString("PID");
					product.setPID(PID);
				}
				r.close();
				

				
                // work on transforimg image file to display
//                PreparedStatement stm = con.prepareStatement("Select Img from Products where PID = ?");
//                
//                stm.setString(1, product.getPID());
//                
//                ResultSet rs = stm.executeQuery();
//               
//                if(rs.next()) {
//                	image = rs.getString(1);
//                }
            
                
                
//                byte[] imgData = null;
//                imgData = image.getBytes(1,(int)image.length());
//                String base64Image = Base64.getEncoder().encodeToString(imgData);
//                response.setContentType("image/png");  
//                product.setImg(base64Image);
               
//                rs.close();
              
			
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
    
}
