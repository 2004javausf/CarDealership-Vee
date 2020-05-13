package com.revature.beans;

public class CarLoan {
	
	private long carLoanID;
	private long carID;
	private long customerID;
	private float loanAmount;
	private float loanInterest;
	private float TotalAmount;
	private int loanMonths;
	private float monthlyPayment;
	private float loanPaid;
	private int paymmentsLeft;
	private float loanBalance;
	
	public CarLoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CarLoan(long carLoanID) {
		super();
		this.carLoanID = carLoanID;
	}


	public CarLoan(float loanAmount, float loanPaid, int paymmentsLeft, float loanBalance) {
		super();
		this.loanAmount = loanAmount;
		this.loanPaid = loanPaid;
		this.paymmentsLeft = paymmentsLeft;
		this.loanBalance = loanBalance;
	}



	public CarLoan(long carLoanID, float monthlyPayment, float loanBalance) {
		super();
		this.carLoanID = carLoanID;
		this.monthlyPayment = monthlyPayment;
		this.loanBalance = loanBalance;
	}



	public CarLoan(long carLoanID, long carID, long customerID, float loanAmount, float loanInterest,
			float totalAmount, int loanMonths, float monthlyPayment, float loanPaid, int paymmentsLeft,
			float loanBalance) {
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

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(float loanInterest) {
		this.loanInterest = loanInterest;
	}

	public float getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		TotalAmount = totalAmount;
	}

	public int getLoanMonths() {
		return loanMonths;
	}

	public void setLoanMonths(int loanMonths) {
		this.loanMonths = loanMonths;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public float getLoanPaid() {
		return loanPaid;
	}

	public void setLoanPaid(float loanPaid) {
		this.loanPaid = loanPaid;
	}

	public int getPaymmentsLeft() {
		return paymmentsLeft;
	}

	public void setPaymmentsLeft(int paymmentsLeft) {
		this.paymmentsLeft = paymmentsLeft;
	}

	public float getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(float loanBalance) {
		this.loanBalance = loanBalance;
	}
	
	

}
