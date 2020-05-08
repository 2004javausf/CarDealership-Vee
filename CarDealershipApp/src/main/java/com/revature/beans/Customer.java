package com.revature.beans;

public class Customer {
	
	private String fName;
	private String lName;
	private String street;
	private String city;
	private String province;
	private int zipCode;
	private CharSequence phoneNo;
	private int creditScore;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String fName, String lName, String street, String city, String province, int zipCode,
			CharSequence phoneNo, int creditScore) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.creditScore = creditScore;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public CharSequence getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(CharSequence phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "Car [fName=" + fName + ", lName=" + lName + ", street=" + street + ", city=" + city + ", province="
				+ province + ", zipCode=" + zipCode + ", phoneNo=" + phoneNo + ", creditScore=" + creditScore + "]";
	}
	

}
