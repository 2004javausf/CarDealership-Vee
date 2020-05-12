package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Offers;
import com.revature.beans.User;
import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.UserDAOImpl;

public class EmployeeServices {
	Validator v = new Validator();
	static Scanner in = new Scanner(System.in);
	static Scanner st = new Scanner(System.in);
	
	public void addEmployee() {
		String firstName;
		String lastName;
		String designation;
		String phoneNo;
		String emailID;
		String userName;
		String password;
		int userTypeID;
		boolean b = false;	
		
		System.out.print("Enter Employee's First Name: ");
		firstName=st.nextLine();
		System.out.print("Enter Employee's Last Name: ");
		lastName=st.nextLine();
		
		do {
			System.out.print("Phone Number: ");
			phoneNo=st.nextLine();
			b=v.validatePhone(phoneNo);
		} while(b == false);
			
		do {
			System.out.print("Email Id: ");
			emailID=st.nextLine();
			b=v.validateEmail(emailID);
		} while(b == false);

		System.out.print("Enter Username: ");
		userName=st.nextLine();
			
		do {
			System.out.print("Enter a password: ");
			password=st.nextLine();
			b = v.validatePassword(password);
		} while (b == false);
		
		System.out.print("Enter Employee's Designation: ");
		designation=st.nextLine();
			
		
	}
	
	public static void employeeLogin() {
		UserDAOImpl udi = new UserDAOImpl();
		String uName;
		String password;
		Menu menu = new Menu();
		List<User> userList = new ArrayList<User>();
		System.out.print("\nUsername: ");
		uName = st.nextLine();
		
		System.out.print("Password: ");
		password = st.nextLine();
		
		try {
			userList = udi.CheckLoginInfo(uName, password,2);
			if(userList.isEmpty()==true) {
				System.out.println("Username and/or Pasword Invalid!");	
				System.out.println("[1] CONTINUE AND TRY AGAIN \n[2] EXIT\n\nENTER THE NUMBER [1-2]: ");
				int choice=in.nextInt();
				switch(choice) {
					case 1:
						employeeLogin();
					default:
						menu.startMenu();
				}
			}
			else {
				
					menu.empTransMenu();
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addCar() {
		CarDAOImpl cdi = new CarDAOImpl();
		int cTypeID;
		String cMake;
		String cModel;
		int cYear;
		String cColor;
		long cMilage;
		double cPrice;
		try {
			
		System.out.print("Enter Car Make: ");
		cMake=st.nextLine();
		
		System.out.print("Enter Car Model: ");
		cModel=st.nextLine();
		
		System.out.print("Enter Car Make Year: ");
		cYear=in.nextInt();
		
		System.out.print("Enter Car Color: ");
		cColor=st.nextLine();
		
		System.out.print("Enter Car Milage: ");
		cMilage=in.nextLong();
		
		System.out.print("Enter Car Price: ");
		cPrice=in.nextDouble();
		
		
		cdi.getCarTypes();
		
		
		System.out.print("\nEnter Car Type : ");
		cTypeID=in.nextInt();
		
		cdi.addCar(cTypeID, cMake, cModel, cYear, cColor, cMilage, cPrice);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewPendingOffers() {
		CarDAOImpl cdi = new CarDAOImpl();
		int oid;
		Menu menu = new Menu();
		List<Offers> offersList = new ArrayList<Offers>();
		Offers o = new Offers();
		try {
			offersList=cdi.getPendingOffers();
			int i=0;
			long cid;
			do {
				o = offersList.get(i);
				cid=o.getCarID();
				cdi.getCarInfo(o.getCarID());
				System.out.println("\nNo.\tPrice\tCustonmer ID");
				int j=1;
				do {
					System.out.println("["+j+"]\t"+offersList.get(i).getOfferAmount()+"\t"+offersList.get(i).getCustomerID());
					i++;
					j++;
				}while(offersList.get(i).getCarID()==cid);
				
				System.out.println("Which Offer you want to accept for the above car?");
				System.out.print("Enter the number [1-"+j+"]: ");
				oid=in.nextInt();
				o = offersList.get(oid);
				cdi.acceptOffer(o.getOfferID(), o.getCarID(), o.getCustomerID());
				
			}while(i<offersList.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
