package com.revature.services;


import java.util.Scanner;

public class Menu {

	static Scanner in = new Scanner(System.in);
	
	
	

	public void startMenu() {
		
		int choice = 0;
		do {
			System.out.print(" --------------------------------------------------------------"+
						   "\n|                  WELCOME TO DRIVEEASY AUTO                   |"+
						   "\n --------------------------------------------------------------" 
							+ "\n\n"
							+ "\n[1] CUSTOMER" + "\n[2] EMPLOYEE" + "\n[3] EXIT"+"\nENTER THE NUMBER [1-3]: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				custMainMenu();
				break;

			case 2:
				EmployeeServices.employeeLogin();
				break;
			default:
				System.out.println("THANK YOU... VISIT AGAIN");
				System.exit(0);
				break;

			}

		} while (choice != 3);

	}
	
	public void custMainMenu() {
		Scanner st = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("\n==================\n      Menu   \n=================="+ "\n[1] REGISTER" + "\n[2] SIGN IN" + "\n[3] PREVIOUS MENU"+"\n\nEnter the number [1-3]: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				System.out.println("NEW USER REGISTRATION");
				CustomerServices.addCustomer();
				break;

			case 2:
				CustomerServices.customerLogin();
				break;
				
			default:
				System.out.println("Return to the Main Menu");
				startMenu();
				break;

			}

		} while (choice != 3);		
	}
	
	public void custTransMenu() {
		
		long ta;

		
		
		int choice = 0;
		do {
			System.out.println("\n==================\n      Menu   \n=================="+ "\n[1] VIEW CARS" + "\n[2] VIEW CAR(S) YOU OWNED" 
					+ "\n[3] DO PAYMENT" + "\n[4] VIEW PAYMENTS" + "\n[5] VIEW REMAINING PAYMENTS"+ "\n[6] SIGN OUT"
					+ "\nENTER THE NUMBER [1-6]: ");
			choice = in.nextInt();
			
			switch (choice) {
			
			case 1:
				CustomerServices.viewCars();
				break;
			
			case 2:
				CustomerServices.viewOwnedCars();
				break;
			case 3:
				//call
				break;
			case 4:
				//call
				break;
			case 5:
				//call
				break;
			
			default:
				System.out.println("Signed Out Successfully!!!");
				startMenu();
				break;
			
			}

		} while (choice < 6);		
	}
	
	
	public void empTransMenu() {
		
		long ta;
		
		
		int choice = 0;
		do {
			System.out.println("\n==================\n      Menu   \n=================="+ "\n[1] ADD NEW CAR" + "\n[2] REMOVE CAR FROM LOT" + "\n[3] VIEW PENDING OFFERS" 
								+ "\n[4] VIEW ALL REMAINING PAYMENTS "+ "\n[5]VIEW ALL MONTHLY PAYMENTS" + "\n[6] SIGN OUT"
								+"\nEnter the number [1-6]: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				EmployeeServices.addCar();
				break;

			case 2:
				//call remove car
				break;
			case 3:
				EmployeeServices.viewPendingOffers();
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
								
				
				break;
			
			default:
				
				break;
			}

		}while (choice < 6);
	
	
	}
	

}
