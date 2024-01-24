package shopaholicjava;

import java.time.LocalDateTime;

public class User {

	private String UID;
	private String FirstName;
	private String LastName; 
	private String ShippingAddress = "123 Post St. Los Angeles, CA 90008";
	private String UserName;
	private String Email;
	private String UserPassword;
	private String JoinDate;
	
	
	public String getUID() {
		return UID;
	}
	
	public void setUID(String uID) {
		UID = uID;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserEmail() {
		return Email;
	}
	public void setUserEmail(String email) {
		Email = email;
	}
	public String getShippingAddress() {
		return ShippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(String now) {
		JoinDate = now;
	}
	
	@Override
	public String toString() {
		return "User [FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName + ", UserPassword=" + UserPassword + "]";
	}
}
