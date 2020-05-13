package com.revature.beans;

public class Offers {
	
	private long offerID;
	private  long carID;
	private long customerID;
	private float offerAmount;
	private String offerStatus;
	private float downPayment;
	private float loanAmount;
	private long loanID;
	private  int loanMonths;
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Offers(long offerID, long carID, long customerID, float offerAmount, String offerStatus, float downPayment,
			float loanAmount, int loanMonths) {
		super();
		this.offerID = offerID;
		this.carID = carID;
		this.customerID = customerID;
		this.offerAmount = offerAmount;
		this.offerStatus = offerStatus;
		this.downPayment = downPayment;
		this.loanAmount = loanAmount;
		this.loanMonths = loanMonths;
	}



	public Offers(long offerID, long carID, long customerID, float offerAmount, String offerStatus, float downPayment,
			float loanAmount, long loanID, int loanMonths) {
		super();
		this.offerID = offerID;
		this.carID = carID;
		this.customerID = customerID;
		this.offerAmount = offerAmount;
		this.offerStatus = offerStatus;
		this.downPayment = downPayment;
		this.loanAmount = loanAmount;
		this.loanID = loanID;
		this.loanMonths = loanMonths;
	}


	public long getOfferID() {
		return offerID;
	}

	public void setOfferID(long offerID) {
		this.offerID = offerID;
	}

	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public float getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(float offerAmount) {
		this.offerAmount = offerAmount;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	
	public float getDownPayment() {
		return downPayment;
	}



	public void setDownPayment(float downPayment) {
		this.downPayment = downPayment;
	}



	public float getLoanAmount() {
		return loanAmount;
	}



	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}



	public long getLoanID() {
		return loanID;
	}



	public void setLoanID(long loanID) {
		this.loanID = loanID;
	}



	public int getLoanMonths() {
		return loanMonths;
	}



	public void setLoanMonths(int loanMonths) {
		this.loanMonths = loanMonths;
	}

	@Override
	public String toString() {
		return "Offers [offerID=" + offerID + ", carID=" + carID + ", customerID=" + customerID + ", offerAmount="
				+ offerAmount + ", offerStatus=" + offerStatus + "]";
	}
	
	

}
