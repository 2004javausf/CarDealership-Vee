package com.revature.beans;

public class CarLoan {
	
	private long carLoanID;
	private long carID;
	private long customerID;
	private double loanAmount;
	private double loanInterest;
	private double TotalAmount;
	private int loanMonths;
	private double monthlyPayment;
	private double loanPaid;
	private int paymmentsLeft;
	private double loanBalance;
	
	public CarLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarLoan(long carLoanID, long carID, long customerID, double loanAmount, double loanInterest,
			double totalAmount, int loanMonths, double monthlyPayment, double loanPaid, int paymmentsLeft,
			double loanBalance) {
		super();
		this.carLoanID = carLoanID;
		this.carID = carID;
		this.customerID = customerID;
		this.loanAmount = loanAmount;
		this.loanInterest = loanInterest;
		TotalAmount = totalAmount;
		this.loanMonths = loanMonths;
		this.monthlyPayment = monthlyPayment;
		this.loanPaid = loanPaid;
		this.paymmentsLeft = paymmentsLeft;
		this.loanBalance = loanBalance;
	}

	public long getCarLoanID() {
		return carLoanID;
	}

	public void setCarLoanID(long carLoanID) {
		this.carLoanID = carLoanID;
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

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(double loanInterest) {
		this.loanInterest = loanInterest;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public int getLoanMonths() {
		return loanMonths;
	}

	public void setLoanMonths(int loanMonths) {
		this.loanMonths = loanMonths;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getLoanPaid() {
		return loanPaid;
	}

	public void setLoanPaid(double loanPaid) {
		this.loanPaid = loanPaid;
	}

	public int getPaymmentsLeft() {
		return paymmentsLeft;
	}

	public void setPaymmentsLeft(int paymmentsLeft) {
		this.paymmentsLeft = paymmentsLeft;
	}

	public double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}
	
	

}
