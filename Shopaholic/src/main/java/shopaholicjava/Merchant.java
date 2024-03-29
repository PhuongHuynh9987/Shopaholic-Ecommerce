package shopaholicjava;

public class Merchant {

	private String MID;
	private String FirstName;
	private String LastName; 
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	private String JoinDate;
	
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String setUserName() {
		return UserName;
	}
	
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	
	public String getUserEmail() {
		return UserEmail;
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
		return "User [UID=" + MID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName + ", UserPassword=" + UserPassword + "]";
	}

	
}
