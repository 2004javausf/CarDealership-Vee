package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offers;
import com.revature.dao.CarDAO;
import com.revature.util.ConnFactory;

public class CarDAOImpl implements CarDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<Car> getCars() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CAR.CAR_ID,CAR.CAR_MAKE,CAR.CAR_MODEL,CAR.CAR_YEAR,CAR.CAR_COLOR,CAR.CAR_MILAGE,CAR.CAR_PRICE," + 
				"CAR_TYPE.CAR_TYPE_ID,CAR_TYPE.CAR_TYPE_DESC FROM CAR" + 
				"JOIN CAR_TYPE" + 
				"ON CAR.CAR_TYPE_ID=CAR_TYPE.CAR_TYPE_ID" + 
				"JOIN CAR_LOT ON CAR.CAR_ID = CAR_LOT.CAR_ID;";
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null;
		while(rs.next()) {
			c=new Car(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8),rs.getString(9));
			carList.add(c);
		}
			
		return carList;
		
	}
	
	public void getCarTypes() throws SQLException {
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT * FROM CAR_TYPE";
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null;
		while(rs.next()) {
			c=new Car(rs.getInt(1),rs.getString(2));
			System.out.println("["+c.getCarTypeID()+"] "+c.getCarTypeDesc());
		}
		
		
	}
	
	
	public void addCar(int cTypeID,String cMake,String cModel,int cYear,String cColor,long cMilage,double cPrice)throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "{ call ADD_CAR(?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, cTypeID);
		call.setString(2, cMake);
		call.setString(3,cModel);
		call.setInt(4,cYear);
		call.setString(5, cColor);
		call.setLong(6,cMilage);
		call.setDouble(7,cPrice);
		
		call.execute();
		
	}

	public List<Offers> getPendingOffers() throws SQLException {
		
		List<Offers> offersList = new ArrayList<Offers>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT * FROM CAR_OFFERS ORDER BY CAR_ID WHERE OFFER_STATUS = 'PENDING'";
		
		ResultSet rs = stmt.executeQuery(sql);
		Offers o = null;
		while(rs.next()) {
			o=new Offers(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getDouble(4),rs.getString(5));
			offersList.add(o);
		}
		
		return offersList;
	}

	public void getCarInfo(long carID) throws SQLException {
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CAR.CAR_ID,CAR.CAR_MAKE,CAR.CAR_MODEL,CAR.CAR_YEAR,CAR.CAR_COLOR,CAR.CAR_MILAGE,CAR.CAR_PRICE," + 
			  "CAR_TYPE.CAR_TYPE_DESC FROM CAR " + 
			  "JOIN CAR_TYPE " + 
			  "ON CAR.CAR_TYPE_ID=CAR_TYPE.CAR_TYPE_ID " + 
			  "WHERE CAR.CAR_ID="+carID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null; 
		while(rs.next()) {
			c=new Car(rs.getLong(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getString(8));
			System.out.println(c.getCarID()+"\t"+c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+c.getCarMilage()+"\t"+c.getCarPrice()+"\t"+c.getCarTypeDesc());
			System.out.println("======================================================================================================================================================================================================================================================================");
		}
		
	}

	public void acceptOffer(long offerId, long carID, long customerID) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
