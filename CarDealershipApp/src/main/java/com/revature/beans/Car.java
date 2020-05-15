package com.revature.beans;

public class Car {
	
	private long carID;
	private String carMake;
	private String carModel;
	private int carYear;
	private String carColor;
	private int carMilage;
	private float carPrice;
	private String carStatus;
	private long customerID;
	private int carTypeID;
	private String carTypeDesc;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Car(long carID) {
		super();
		this.carID = carID;
	}



	public Car(int carTypeID, String carTypeDesc) {
		super();
		this.carTypeID = carTypeID;
		this.carTypeDesc = carTypeDesc;
	}
	
	public Car(String carMake, String carModel, int carYear, String carColor) {
		super();
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
	}

	public Car(long carID, String carMake, String carModel, int carYear, String carColor, String carTypeDesc) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carTypeDesc = carTypeDesc;
	}

	public Car(long carID, String carMake, String carModel, int carYear, String carColor, int carMilage,
			float carPrice, String carTypeDesc) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carMilage = carMilage;
		this.carPrice = carPrice;
		this.carTypeDesc = carTypeDesc;
	}

	public Car(long carID, String carMake, String carModel, int carYear, String carColor, int carMilage,
			float carPrice, String carStatus, long customerID, int carTypeID, String carTypeDesc) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carMilage = carMilage;
		this.carPrice = carPrice;
		this.carStatus = carStatus;
		this.customerID = customerID;
		this.carTypeID = carTypeID;
		this.carTypeDesc = carTypeDesc;
	}

	public Car(long carID, String carMake, String carModel, int carYear, String carColor, int carMilage,
			float carPrice, String carStatus, int carTypeID, String carTypeDesc) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carMilage = carMilage;
		this.carPrice = carPrice;
		this.carStatus = carStatus;
		this.carTypeID = carTypeID;
		this.carTypeDesc = carTypeDesc;
	}
	
	public Car(long carID, String carMake, String carModel, int carYear, String carColor, int carMilage,
			float carPrice, int carTypeID, String carTypeDesc) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carMilage = carMilage;
		this.carPrice = carPrice;
		this.carTypeID = carTypeID;
		this.carTypeDesc = carTypeDesc;
	}
	
	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarMilage() {
		return carMilage;
	}

	public void setCarMilage(int carMilage) {
		this.carMilage = carMilage;
	}

	public float getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	public int getCarTypeID() {
		return carTypeID;
	}

	public void setCarTypeID(int carTypeID) {
		this.carTypeID = carTypeID;
	}
	

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCarTypeDesc() {
		return carTypeDesc;
	}

	public void setCarTypeDesc(String carTypeDesc) {
		this.carTypeDesc = carTypeDesc;
	}

	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carMake=" + carMake + ", carModel=" + carModel + ", CarYear=" + carYear
				+ ", carColor=" + carColor + ", carMilage=" + carMilage + ", carPrice=" + carPrice + ", carStatus="
				+ carStatus + ", carTypeID=" + carTypeID + ", carTypeDesc=" + carTypeDesc + "]";
	}

	
	
	
	
	
	

}
