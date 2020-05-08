package com.revature.beans;

public class Employee {
	
	private String fName;
	private String lName;
	private String designation;
	private CharSequence phoneNo;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String fName, String lName, String designation, CharSequence phoneNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.designation = designation;
		this.phoneNo = phoneNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public void setPhoneNo(CharSequence phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Employee [fName=" + fName + ", lName=" + lName + ", designation=" + designation + ", phoneNo=" + phoneNo
				+ "]";
	}
	
	

}
