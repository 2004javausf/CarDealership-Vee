package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.CarLoan;
import com.revature.beans.Offers;
import com.revature.beans.Payments;
import com.revature.dao.CarDAO;
import com.revature.util.ConnFactory;

public class CarDAOImpl implements CarDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<Car> getCars() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CAR.CAR_ID,CAR.CAR_MAKE,CAR.CAR_MODEL,CAR.CAR_YEAR,CAR.CAR_COLOR,CAR.CAR_MILAGE,CAR.CAR_PRICE,CAR_TYPE.CAR_TYPE_ID,CAR_TYPE.CAR_TYPE_DESC " + 
				"FROM CAR " + 
				"JOIN CAR_TYPE ON CAR.CAR_TYPE_ID=CAR_TYPE.CAR_TYPE_ID " + 
				"JOIN CAR_LOT ON CAR.CAR_ID = CAR_LOT.CAR_ID";
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null;
		while(rs.next()) {
			c=new Car(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getFloat(7),rs.getInt(8),rs.getString(9));
			carList.add(c);
		}
			
		return carList;
		
	}
	
	public List<Car> getOwnedCars(long customerID) throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		
		sql = "SELECT CAR.CAR_ID,CAR.CAR_MAKE,CAR.CAR_MODEL,CAR.CAR_YEAR,CAR.CAR_COLOR,CAR_TYPE.CAR_TYPE_DESC FROM CAR" + 
				"JOIN CAR_TYPE" + 
				"ON CAR.CAR_TYPE_ID=CAR_TYPE.CAR_TYPE_ID" + 
				"WHERE CAR.CAR_STATUS='OWNED' AND CAR.CUSTOMER_ID="+customerID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null;
		while(rs.next()) {
			c=new Car(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
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
	
	
	public void addCar(int cTypeID,String cMake,String cModel,int cYear,String cColor,long cMilage,float cPrice)throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "{ call ADD_CAR(?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, cTypeID);
		call.setString(2, cMake);
		call.setString(3,cModel);
		call.setInt(4,cYear);
		call.setString(5, cColor);
		call.setLong(6,cMilage);
		call.setFloat(7,cPrice);
		
		call.execute();
		
	}

	public List<Offers> getPendingOffers() throws SQLException {
		
		List<Offers> offersList = new ArrayList<Offers>();
		String st = "PENDING";
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT * FROM OFFERS WHERE OFFER_STATUS = '"+st+"' ORDER BY CAR_ID";
		
		ResultSet rs = stmt.executeQuery(sql);
		Offers o = null;
		while(rs.next()) {
			o=new Offers(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6),rs.getFloat(7),rs.getInt(8));
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
			c=new Car(rs.getLong(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getFloat(7),rs.getString(8));
			System.out.println(c.getCarID()+"\t"+c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+c.getCarMilage()+"\t"+c.getCarPrice()+"\t"+c.getCarTypeDesc());
		}
		System.out.println("======================================================================================================================================================================================================================================================================");
		
	}

	public void acceptOffer(long offerID, long carID, long customerID,float offerAmount,float downPayment,float loanAmount,int months,float interestRate,float mPayments) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "{ call ACCEPT_OFFER(?,?,?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setLong(1, offerID);
		call.setLong(2, carID);
		call.setLong(3, customerID);
		call.setInt(4, months);
		call.setFloat(5, (float)Math.round((offerAmount*100.0)/100.0));
		call.setFloat(6, (float)Math.round((downPayment*100.0)/100.0));
		call.setFloat(7, (float)Math.round((loanAmount*100.0)/100.0));
		call.setFloat(8, interestRate);
		call.setFloat(9, (float)Math.round((mPayments*100.0)/100.0));
		
		call.execute();
		
	}

	public void doLoanPayment(long carID) throws SQLException {
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CAR_LOAN_ID,LOAN_MNTHLY_PAYMENT,LOAN_BALANCE FROM CAR_LOAN"+
		"WHERE CAR_ID="+carID;
		
		ResultSet rs = stmt.executeQuery(sql);
		CarLoan cl = null; 
		while(rs.next()) {
			cl=new CarLoan(rs.getLong(1),rs.getFloat(2),rs.getFloat(3));	
		}
		
		if(cl.getLoanBalance()==0) {
			System.out.println("Loan for this Car is paid-off");
		}
		else {
			
			sql = "{ call DO_PAYMENT(?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setLong(1, cl.getCarLoanID());		
			call.setFloat(2,cl.getMonthlyPayment());
			
			call.execute();
			
			System.out.println("Loan payment Successful!!!");
		}
	}

	public void addOffer(long carID, long customerID, float offerAmount, float downPayment, float loanAmount,
			int loanMonths) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS (CAR_ID,CUSTOMER_ID,OFFER_AMOUNT,OFFER_STATUS,DOWN_PAYMENT,LOAN_AMOUNT,LOAN_MONTHS) "
				+ "VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, carID);
		ps.setLong(2, customerID);
		ps.setFloat(3, offerAmount);
		ps.setString(4, "PENDING");
		ps.setFloat(5, downPayment);
		ps.setFloat(6, loanAmount);
		ps.setInt(7, loanMonths);
		
		ps.executeUpdate();
		
	}

	public void removeCar(long carID) throws SQLException {
		List<Offers> offersList = new ArrayList<Offers>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT * FROM OFFERS WHERE CAR_ID="+carID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Offers o = null;
		while(rs.next()) {
			o=new Offers(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6),rs.getFloat(7),rs.getInt(8));
			offersList.add(o);
		}
		int count=0;
		for(int i=0;i<offersList.size();i++) {
			if(offersList.get(i).getOfferStatus().equalsIgnoreCase("PENDING")) {
				count++;
			}
		}
		
		if(count==0) {
			
			sql = "DELETE FROM CAR_LOT WHERE CAR_ID="+carID;
			stmt.executeUpdate(sql);
		}
		else {
			System.out.println("This car has pending offers clear that out before you remove this car from lot.");
		}
	}

	public void viewPayments(long carID) throws SQLException {
		
		List<Payments> pList = new ArrayList<Payments>();
		
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT * FROM CAR_LOAN WHERE CAR_ID="+carID;
		
		ResultSet rs = stmt.executeQuery(sql);
		CarLoan cl = null;
		while(rs.next()) {
			cl=new CarLoan(rs.getLong(1));
		}
		
		sql = "SELECT * FROM PAYMENTS WHERE CAR_LOAN_ID="+cl.getCarLoanID();
		
		rs = stmt.executeQuery(sql);
		Payments p = null;
		while(rs.next()) {
			p=new Payments(rs.getLong(1),rs.getLong(2),rs.getFloat(3),rs.getString(4));
			pList.add(p);
		}
		System.out.println("PAYMENT ID\tLOAN_ID\tAMOUNT\tDATE");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<pList.size();i++) {
			System.out.println(pList.get(i).getPaymentID()+"\t"
					+pList.get(i).getCarLoanID()+"\t"
					+pList.get(i).getPaymentAmount()+"\t"
					+pList.get(i).getPaymentDate());
		}
		
	}

	public void viewRemainingPayments(long customerID) throws SQLException {
		Connection conn=cf.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql=null;
		
		sql = "SELECT CAR.CAR_MAKE,CAR.CAR_MODEL,CAR.CAR_YEAR,CAR.CAR_COLOR,CAR_LOAN.LOAN_AMOUNT,CAR_LOAN.LOAN_PAID,CAR_LOAN.LOAN_BALANCE,CAR_LOAN.LOAN_PAYMENT_LEFT FROM CAR " + 
			  "JOIN CAR_LOAN " + 
			  "ON CAR.CAR_ID=CAR_LOAN.CAR_ID " + 
			  "WHERE CAR.CUSTOMER_ID="+customerID;
		
		ResultSet rs = stmt.executeQuery(sql);
		Car c = null; 
		CarLoan cl=null;
		System.out.println("Make\tModel\tYear\tColor\tLoan Amount\tPaid\tBalance\tPaymentsLeft");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			c=new Car(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getString(4));
			cl=new CarLoan(rs.getFloat(5),rs.getFloat(6),rs.getInt(8),rs.getFloat(7));
			System.out.println(c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+cl.getLoanAmount()+"\t"+cl.getLoanPaid()+"\t"+cl.getLoanBalance()+"\t"+cl.getPaymmentsLeft());
		}
		
	}

	
	
	
	
	
	
	
	

}
