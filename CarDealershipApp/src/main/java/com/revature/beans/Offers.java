package com.revature.beans;

public class Offers {
	
	private long offerID;
	private  long carID;
	private long customerID;
	private double offerAmount;
	private String offerStatus;
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(long offerID, long carID, long customerID, double offerAmount, String offerStatus) {
		super();
		this.offerID = offerID;
		this.carID = carID;
		this.customerID = customerID;
		this.offerAmount = offerAmount;
		this.offerStatus = offerStatus;
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

	@Override
	public String toString() {
		return "Offers [offerID=" + offerID + ", carID=" + carID + ", customerID=" + customerID + ", offerAmount="
				+ offerAmount + ", offerStatus=" + offerStatus + "]";
	}
	
	

}
