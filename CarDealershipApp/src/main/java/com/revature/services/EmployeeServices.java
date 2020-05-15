package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Offers;
import com.revature.beans.User;
import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.util.LogThis;

public class EmployeeServices {
	Validator v = new Validator();
	static Scanner in = new Scanner(System.in);
	static Scanner st = new Scanner(System.in);
	static String uName;
	
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
		
		String password;
		Menu menu = new Menu();
		List<User> userList = new ArrayList<User>();
		System.out.print("\nUsername: ");
		uName = st.nextLine();
		
		System.out.print("Password: ");
		password = st.nextLine();
		
		try {
			userList = udi.CheckLoginInfo(uName, password,2);
			//LogThis.LogIt("info", "User name or Password invalid!!!!");
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
					LogThis.LogIt("info", uName+" signed in successfully!!!");
					System.out.println("Login Sucessfull");
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
		float cPrice;
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
		cPrice=in.nextFloat();
		
		
		cdi.getCarTypes();
		
		
		System.out.print("\nEnter Car Type : ");
		cTypeID=in.nextInt();
		
		cdi.addCar(cTypeID, cMake, cModel, cYear, cColor, cMilage, cPrice);
		System.out.println("Car added successfully!!!!");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewPendingOffers() {
		CarDAOImpl carDI = new CarDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl(); 
		int oid;
		int creditScore;
		float interestRate;
		float monthlyPayments;
		Menu menu = new Menu();
		List<Offers> offersList = new ArrayList<Offers>();
		Offers o = new Offers();
		
		try {
			offersList=carDI.getPendingOffers();
			int i=0;
			int t;
			long cid;
			boolean b=false;
			do {
				t=i;
				o = offersList.get(i);
				cid=o.getCarID();
				carDI.getCarInfo(o.getCarID());
				System.out.println("\nNo.\tPrice\t\tCustomer ID");
				int j=1;
				do {
					System.out.println("["+j+"]\t"+offersList.get(i).getOfferAmount()+"\t\t"+offersList.get(i).getCustomerID());
					i++;
					j++;
					if(i<offersList.size()) {
						b=(offersList.get(i).getCarID()==cid);
					}
					else 
						b=false;
				}while( b == true);
				
				System.out.println("\n\nDo you want to accept any offer from above list? \n[1] YES\n[2] NO \n Enter the number [1-2]: ");
				int choice=in.nextInt();
				
				switch(choice) {
				
				case 1:
					System.out.println("\n\nWhich Offer you want to accept for the above car?");
					System.out.print("Enter the number [1-"+(j-1)+"]: ");
					oid=in.nextInt();
					o = offersList.get((oid+t)-1);
									
					creditScore=cdi.getCreditScore(o.getCustomerID());
					
					if(creditScore<=300) 
						interestRate = (float) 14.70;
					else if(creditScore>300 && creditScore<=500)
						interestRate = (float) 12.20;
					else if(creditScore>500 && creditScore<=650)
						interestRate = (float) 8.12;
					else if(creditScore>650 && creditScore<=800)
						interestRate = (float) 5.17;
					else
						interestRate = (float) 4.23;
					System.out.println(o.getLoanAmount()+"\t\t"+interestRate+o.getLoanMonths());
					monthlyPayments=carDI.monthlyPayment(o.getLoanAmount(),interestRate,o.getLoanMonths());
					carDI.acceptOffer(o.getOfferID(), o.getCarID(), o.getCustomerID(),o.getOfferAmount(),o.getDownPayment(),o.getLoanAmount(),o.getLoanMonths(),interestRate,monthlyPayments);
					System.out.println("Car offer accepted successfully!!!!");
					break;
					
				case 2:
					break;
				}
			}while(i<offersList.size());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void removeCar() {
		
		try {
			
			CarDAOImpl carDI = new CarDAOImpl();
			long carID;
			int count;
			count=carDI.isCarLotEmpty();
			if(count==0) {
				System.out.println("Car Lot is Empty");
			}
			else {
				System.out.print("Enter CAR ID for the car you want to remove: ");
				carID=in.nextLong();
		
				carDI.removeCar(carID);
				System.out.println("Car removed from lot successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void viewAllPayments() {
		
		CarDAOImpl carDI = new CarDAOImpl();
		long carID;
		
		System.out.print("Enter CAR ID for the car you want to view Payments: ");
		carID=in.nextLong();
		
		try {
			carDI.viewPayments(carID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
