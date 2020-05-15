package com.revature.beans;

public class User {
	
	private long userID;
	private String userName;
	private String password;
	private String emailID;
	private int userTypeID;
	private String phoneNo;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(long userID, String userName, String password, String emailID, int userTypeID, String phoneNo) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.emailID = emailID;
		this.userTypeID = userTypeID;
		this.phoneNo = phoneNo;
	}



	public String getPhoneNo() {
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

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}
	
	
}
