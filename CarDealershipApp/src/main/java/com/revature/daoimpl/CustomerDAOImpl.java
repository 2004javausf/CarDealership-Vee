package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public long getCustomerID(long userID) throws SQLException {
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE USER_ID = "+userID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Customer c = null;
		while(rs.next()) {
			c=new Customer(rs.getLong(1));
		}
		
		return c.getCustomerID();
	}

	public void addCustomer(String firstName, String lastName, int creditScore, String phoneNumber, String emailID,
			String userName, String password, int userTypeID) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "{ call ADD_CUSTOMER(?,?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		
		call.setString(1, firstName);
		call.setString(2,lastName);
		call.setInt(3,creditScore);
		call.setString(4,userName);
		call.setString(5,password);	
		call.setString(6,emailID);
		call.setString(7,phoneNumber);
		call.setInt(8, userTypeID);
		
		call.execute();
		
	}

	public int getCreditScore(long customerID) throws SQLException {
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CREDIT_SCORE FROM CUSTOMER WHERE CUSTOMER_ID = "+customerID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Customer c = null;
		while(rs.next()) {
			c=new Customer(rs.getInt(1));
		}
		
		return c.getCreditScore();
	}

}
