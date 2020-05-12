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

		System.out.print("Desire Username: ");
		userName=st.nextLine();
			
		do {
			System.out.print("Password: ");
			password=st.nextLine();
			b = v.validatePassword(password);
		} while (b == false);
		
		System.out.print("Credit Score [0-1000]: ");
		creditScore=in.nextInt();
		
		
		cdi.addCustomer(firstName,lastName,creditScore,phoneNo,emailID,userName,password,1);
			
			
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
					menu.custTransMenu();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewCars() {
		CarDAOImpl carDI = new CarDAOImpl();
		List<Car> carList = new ArrayList<Car>();
		Car c = null;
		
		try {
			carList = carDI.getCars();
			for(int i=0; i<carList.size();i++) {
				c = carList.get(i);
				System.out.println(c);
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
			carList = carDI.getCars();
			for(int i=0; i<carList.size();i++) {
				c = carList.get(i);
				System.out.println("["+(i+1)+"]\t"+c.getCarMake()+"\t"+c.getCarModel()+"\t"+c.getCarYear()+"\t"+c.getCarColor()+"\t"+c.getCarTypeDesc());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
