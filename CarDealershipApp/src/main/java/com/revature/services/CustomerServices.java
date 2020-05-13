package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.User;
import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.util.LogThis;

public class CustomerServices {
	
	
	static Validator v = new Validator();
	static Scanner in = new Scanner(System.in);
	static Scanner st = new Scanner(System.in);
	static long customerID;
	
	public static void addCustomer() {
		
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		
		String firstName;
		String lastName;
		int creditScore;
		String phoneNo;
		String emailID;
		String userName;
		String password;
		
		boolean b = false;	
		try {
		System.out.print("First Name: ");
		firstName=st.nextLine();
		System.out.print("Last Name: ");
		lastName=st.nextLine();
		
		
			System.out.print("Phone Number: ");
			phoneNo=st.nextLine();
			b=v.validatePhone(phoneNo);
		
			
		do {
			System.out.print("Email Id: ");
			emailID=st.nextLine();
			b=v.validateEmail(emailID);
		} while(b == false);

		System.out.print("Desire Username: ");
		userName=st.nextLine();
			
		do {
			System.out.println("Password criteria:\n"
			+"Valid Passwords\n" + 
			"Between 8 and 40 characters long.\n" + 
			"Contain at least one digit.\n" + 
			"Contain at least one lower case character.\n" + 
			"Contain at least one upper case character.\n" + 
			"Contain at least one special character from [ @ # $ % ! . ].\n");
			System.out.print("Password: ");
			password=st.nextLine();
			b = v.validatePassword(password);
		} while (b == false);
		
		System.out.print("Credit Score [0-1000]: ");
		creditScore=in.nextInt();
		
		
		cdi.addCustomer(firstName,lastName,creditScore,phoneNo,emailID,userName,password,1);
		LogThis.LogIt("info", "CUstomer "+firstName+" "+lastName+" added successfully!!!");
			System.out.println("CUstomer "+firstName+" "+lastName+" added successfully!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void customerLogin() {
		
		UserDAOImpl udi = new UserDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		
		String uName;
		String password;
		Menu menu = new Menu();
		List<User> userList = new ArrayList<User>();
		User u = new User();
		System.out.print("\nUsername: ");
		uName = st.nextLine();
		
		System.out.print("Password: ");
		password = st.nextLine();
		
		try {
			userList = udi.CheckLoginInfo(uName, password,1);
			if(userList.isEmpty()==true) {
				//LogThis.LogIt("info", "User name or Password invalid!!!!");
				System.out.println("Username or Pasword Invalid! Try Again.");	
				System.out.println("[1] CONTINUE \n[2] EXIT\n\nENTER THE NUMBER [1-2]: ");
				int choice=in.nextInt();
				switch(choice) {
					case 1:
						customerLogin();
					default:
						menu.startMenu();
				}
			}
			else {
					
					customerID = cdi.getCustomerID(userList.get(0).getUserID());
					LogThis.LogIt("info", uName+"signed in successfully!!!");
					//System.out.println("Login Sucessfull");
					menu.custTransMenu();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewCars() {
		CarDAOImpl carDI = new CarDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		Menu m=new Menu();
		List<Car> carList = new ArrayList<Car>();
		Car c = null;
		
		try {
			carList = carDI.getCars();
			for(int i=0; i<carList.size();i++) {
				int choice;
				c = carList.get(i);
				System.out.println(c);
				
				System.out.print("\n[1] PLACE AN OFFER \n[2]SHOW NEXT CAR \n[3] GO BACK TO MENU"
						+"\n\nENTER THE NUMBER [1-3]: ");
				choice=in.nextInt();
				
				switch(choice) {
				case 1:		
					float offerAmount;
					float downPayment=0;
					float loanAmount;
					int loanMonths;
					int creditScore;
					float interestRate;
	
					
					System.out.print("OFFER PRICE: ");
					offerAmount=in.nextFloat();
					
					System.out.print("DOWN PAYMENT: ");
					downPayment=in.nextFloat();
					
					loanAmount=offerAmount-downPayment;
					creditScore = cdi.getCreditScore(customerID);
					System.out.println("As per your creditScore, offered price and down payment");
					
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
					float y;
					System.out.println("Your loan amount will be $"+loanAmount);
					System.out.println("MONTHS \tINTEREST \t MoONTHLY PAYMENTS ");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					for(int x=1; x<=6;x++) {
						y=(loanAmount+((loanAmount*interestRate*x)/100))/(x*12);
						
						System.out.println((x*12)+"\t"+interestRate+"\t"+y);
					}
					
					System.out.print("\n How many months you prefers for you loan payment: ");
					loanMonths=in.nextInt();
					
					carDI.addOffer(c.getCarID(), customerID, offerAmount, downPayment, loanAmount, loanMonths);
					break;
				case 2:
					break;
				case 3:
					m.custTransMenu();
					break;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewOwnedCars() {
		CarDAOImpl carDI = new CarDAOImpl();
		List<Car> carList = new ArrayList<Car>();
		Car c = null;
		
		try {
			carList = carDI.getOwnedCars(customerID);
			for(int i=0; i<carList.size();i++) {
				c = carList.get(i);
				System.out.println("["+(i+1)+"]\t"+c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+c.getCarTypeDesc());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void doPayment() {
		CarDAOImpl carDI = new CarDAOImpl();
		List<Car> carList = new ArrayList<Car>();
		Car c = null;
		int j=0;
		try {
			carList = carDI.getOwnedCars(customerID);
			for(int i=0; i<carList.size();i++) {
				j=i+1;
				c = carList.get(i);
				System.out.println("["+j+"]\t"+c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+c.getCarTypeDesc());
			}
			
			System.out.print("\nFor which car you want to do payment? Enter number [1-"+j+"]: ");
			j=in.nextInt();
			
			carDI.doLoanPayment(carList.get(j-1).getCarID());			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void viewRemainingPayments() {
		
		CarDAOImpl carDI = new CarDAOImpl();
		
		try {
			carDI.viewRemainingPayments(customerID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
