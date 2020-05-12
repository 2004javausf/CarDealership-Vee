package com.revature.beans;

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String designation;
	private String phoneNo;
	private String emailID;
	private long userID;
	private String userName;
	private String password;
	private int userTypeID;
	private String userType;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID, String firstName, String lastName, String phoneNo, String designation,
			String emailID, long userID, String userName, String password, int userTypeID, String userType) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.phoneNo = phoneNo;
		this.emailID = emailID;
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.userTypeID = userTypeID;
		this.userType = userType;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", phoneNo=" + phoneNo + ", emailID=" + emailID + ", userID="
				+ userID + ", userName=" + userName + ", password=" + password + ", userTypeID=" + userTypeID
				+ ", userType=" + userType + "]";
	}

		
	
	

}
