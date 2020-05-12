package com.revature.beans;

public class Customer {
	
	private long customerID;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String emailID;
	private long userID;
	private String userName;
	private String password;
	private int creditScore;
	private int userTypeID;
	private String userType;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long customerID) {
		super();
		this.customerID = customerID;
	}

	

	public Customer(long customerID, String firstName, String lastName, String phoneNo, String emailID, long userID,
			String userName, String password, int creditScore, int userTypeID, String userType) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.emailID = emailID;
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.creditScore = creditScore;
		this.userTypeID = userTypeID;
		this.userType = userType;
	}

	public long getCustomerID() {
		return customerID;
	}


	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CharSequence getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getCreditScore() {
		return creditScore;
	}


	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNo=" + phoneNo + ", emailID=" + emailID + ", userID=" + userID + ", userName=" + userName
				+ ", password=" + password + ", creditScore=" + creditScore + ", userTypeID=" + userTypeID
				+ ", userType=" + userType + "]";
	}

	
	


	

	

}
