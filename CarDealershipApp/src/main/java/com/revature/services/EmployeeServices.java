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
		CarDAOImpl carDI = new CarDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl(); 
		int oid;
		int creditScore;
		double interestRate;
		double monthlyPayments;
		Menu menu = new Menu();
		List<Offers> offersList = new ArrayList<Offers>();
		Offers o = new Offers();
		
		try {
			offersList=carDI.getPendingOffers();
			int i=0;
			long cid;
			boolean b=false;
			do {
				o = offersList.get(i);
				cid=o.getCarID();
				carDI.getCarInfo(o.getCarID());
				System.out.println("\nNo.\tPrice\tCustonmer ID");
				int j=1;
				do {
					System.out.println("["+j+"]\t"+offersList.get(i).getOfferAmount()+"\t"+offersList.get(i).getCustomerID());
					i++;
					j++;
					if(i<offersList.size()) {
						b=(offersList.get(i).getCarID()==cid);
					}
				}while( b == true);
				
				System.out.println("Do you want to accept any offer from above list? \n [1] YES\n[2] NO \n Enter the number [1-2]: ");
				int choice=in.nextInt();
				
				switch(choice) {
				
				case 1:
					System.out.println("Which Offer you want to accept for the above car?");
					System.out.print("Enter the number [1-"+(j-1)+"]: ");
					oid=in.nextInt();
					o = offersList.get(oid-1);
									
					creditScore=cdi.getCreditScore(o.getCustomerID());
					
					if(creditScore<=300) 
						interestRate = 14.70;
					else if(creditScore>300 && creditScore<=500)
						interestRate = 12.20;
					else if(creditScore>500 && creditScore<=650)
						interestRate = 8.12;
					else if(creditScore>650 && creditScore<=800)
						interestRate = 5.17;
					else
						interestRate = 4.23;
					
					monthlyPayments=monthlyPayment(o.getLoanAmount(),interestRate,o.getLoanMonths());
					carDI.acceptOffer(o.getOfferID(), o.getCarID(), o.getCustomerID(),o.getOfferAmount(),o.getDownPayment(),o.getLoanAmount(),o.getLoanMonths(),interestRate,monthlyPayments);
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
	
	public static double monthlyPayment(double loanAmount,double interestRate,int months) {
		int y = months/12;
		double mPayment;
		mPayment = (loanAmount+((loanAmount*interestRate*y)/100))/(months);
		mPayment=Math.round((mPayment*100.0)/100.0);
		return mPayment;
	}
	
	public static void removeCar() {
		
		CarDAOImpl carDI = new CarDAOImpl();
		long carID;
		
		System.out.print("Enter CAR ID for the car you want to remove: ");
		carID=in.nextLong();
		
		try {
			carDI.removeCar(carID);
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
