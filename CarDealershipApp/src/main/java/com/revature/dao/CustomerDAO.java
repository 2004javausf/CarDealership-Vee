package com.revature.dao;

import java.sql.SQLException;
import java.util.List;


public interface CustomerDAO {
	
	public void addCustomer(String firstName,String lastName,int creditScore,String phoneNo,String emailID,String userName,String password,int userTypeID) throws SQLException;
	
	public long getCustomerID(long userID) throws SQLException;
	
	public int getCreditScore(long customerID) throws SQLException;
	

}
