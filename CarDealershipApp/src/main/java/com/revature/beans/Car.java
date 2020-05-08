package com.revature.beans;

public class Car {
	
	private String make;
	private String model;
	private int year;
	private String color;
	private int milage;
	private long price;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(String make, String model, int year, String color, int milage, long price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.milage = milage;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", color=" + color + ", milage=" + milage
				+ ", price=" + price + "]";
	}
	
	
	

}
