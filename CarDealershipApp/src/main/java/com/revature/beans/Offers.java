package com.revature.beans;

public class Offers {
	
	private long offerID;
	private  long carID;
	private long customerID;
	private double offerAmount;
	private String offerStatus;
	private double downPayment;
	private double loanAmount;
	private long loanID;
	private  int loanMonths;
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Offers(long offerID, long carID, long customerID, double offerAmount, String offerStatus, double downPayment,
			double loanAmount, int loanMonths) {
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



	public Offers(long offerID, long carID, long customerID, double offerAmount, String offerStatus, double downPayment,
			double loanAmount, long loanID, int loanMonths) {
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

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	
	public double getDownPayment() {
		return downPayment;
	}



	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}



	public double getLoanAmount() {
		return loanAmount;
	}



	public void setLoanAmount(double loanAmount) {
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
