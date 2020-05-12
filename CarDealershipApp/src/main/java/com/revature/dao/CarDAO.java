package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offers;

public interface CarDAO {
	
	public List<Car> getCars() throws SQLException;
	
	public List<Car> getOwnedCars(long CutomerID) throws SQLException;
	
	public void getCarTypes() throws SQLException;
	
	public void addCar(int cTypeID,String cMake,String cModel,int cYear,String cColor,long cMilage,double cPrice)throws SQLException;

	public List<Offers> getPendingOffers() throws SQLException;
	
	public void getCarInfo(long carID) throws SQLException;
	
	public void acceptOffer(long offerId, long carID, long customerID) throws SQLException;


}
