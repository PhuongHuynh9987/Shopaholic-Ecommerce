package shopaholicjava;

import java.sql.Blob;

//import com.mysql.cj.jdbc.Blob;

public class Product {
	
	private String PID;
	private String ProductName;
	private Float Price;
	private String ProductType;
	private String Img;
	private String ProductDescription;
	private boolean Availability;
	
	public String getPID() {
		return PID;
	}
	 
	public void setPID(String pID) {
		PID = pID;
	}
	
	public String getProductName() {
		return ProductName;
	}
	
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	public Float getPrice() {
		return Price;
	}
	
	public void setPrice(Float price) {
		Price = price;
	}
	
	public String getImg() {
		return Img;
	}
	
	public void setImg(String img) {
		Img = img;
	}

	public String getProductDescription() {
		return ProductDescription;
	}
	
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	
	public boolean isAvailability() {
		return Availability;
	}
	
	public void setAvailability(boolean availability) {
		Availability = availability;
	}
	
	public String getProductType() {
		return ProductType;
	}
	
	public void setProductType(String productType) {
		ProductType = productType;
	}

	@Override
	public String toString() {
		return "Product [PID=" + PID + ", ProductName=" + ProductName + ", Price=" + Price + ", ProductType="
				+ ProductType + ", Img=" +Img + "]";
	}
}
