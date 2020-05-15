package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.daoimpl.CarDAOImpl;

class CarDAOImplTest {

	CarDAOImpl carDI = new CarDAOImpl();
	
	@Test
	void monthlyPaymentTest() {
		
		try {
		
			float mPayment;
			float lAmount = (float) 15000;
			float iRate = (float) 12.2;
			int lMonths = 48;
		
			mPayment = carDI.monthlyPayment(lAmount, iRate, lMonths);
			
			//expected, actual
			assertEquals(465, mPayment);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
