package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offers;

public interface CarDAO {
	
	public List<Car> getCars() throws SQLException;
	
	public List<Car> getOwnedCars(long customerID) throws SQLException;
	
	public void getCarTypes() throws SQLException;
	
	public void addCar(int cTypeID,String cMake,String cModel,int cYear,String cColor,long cMilage,double cPrice)throws SQLException;

	public void addOffer(long carID,long customerID,double offerAmount,double downPayment,double loanAmount,int loanMonths) throws SQLException;
	public List<Offers> getPendingOffers() throws SQLException;
	
	public void getCarInfo(long carID) throws SQLException;
	
	public void acceptOffer(long offerID, long carID, long customerID,double offerAmount,double downPayment,double loanAmount,int months,double interestRate,double mPayments) throws SQLException;

	public void doLoanPayment(long carID) throws SQLException;
	
	public void removeCar(long carID) throws SQLException;
	
	public void viewPayments(long carID) throws SQLException;
	
	public void viewRemainingPayments(long customerID) throws SQLException;
	
}
