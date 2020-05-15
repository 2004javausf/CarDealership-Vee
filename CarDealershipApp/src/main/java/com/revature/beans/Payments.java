package com.revature.beans;

public class Payments {
	
	private long paymentID;
	private long carLoanID;
	private float paymentAmount;
	private String paymentDate;
	
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(long paymentID, long carLoanID, float paymentAmount, String paymentDate) {
		super();
		this.paymentID = paymentID;
		this.carLoanID = carLoanID;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public long getCarLoanID() {
		return carLoanID;
	}

	public void setCarLoanID(long carLoanID) {
		this.carLoanID = carLoanID;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	

}
