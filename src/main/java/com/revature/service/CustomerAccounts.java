package com.revature.service;


import java.util.InputMismatchException;
import com.revature.service.CustomerAccounts;
import com.revature.Main;
import com.revature.controller.CustomerLogin;
import com.revature.controller.MainMenu;

public class CustomerAccounts extends CustomerLogin {
	
	
	
	//Will work on the below code later
	private static float balanceUser1 = (float) 5000.00;
	private static int pinNumber = 8939;
	private static String accountHolderName = "Alec";
	
	public static void customerPIN() {
		System.out.println("Press enter PIN: ");

		int pinInput = bankScanner.nextInt(); 
					
		  
		if (pinInput == pinNumber) {		
			System.out.println("Welcome " + accountHolderName.toUpperCase());
			CustomerAccounts.menuOptionsForCustomerInput();
		} else if (pinInput != pinNumber) {
			int failedPINCounter = 0;
			System.out.println("Wrong PIN");
			failedPINCounter++;
			loginLogger.debug("Failed pin attempts: " + failedPINCounter);
			if (failedPINCounter > 3) {
				loginLogger.fatal("Too many failed attempts");
			}
		customerPIN();
		}		

		
	}
	//Getters and setters for balance
	public static float getBalanceUser1() {
		return balanceUser1;
	}
	public static void setBalanceUser1(float balanceUser1) {
		CustomerAccounts.balanceUser1 = balanceUser1;
	}

	public static void menuOptionsForCustomerInput() {
		System.out.println("Please choose an option:");
		System.out.println("1 View Balance");
		System.out.println("2 Withdraw");
		System.out.println("3 Deposit");
		System.out.println("4 Exit");

		int customerInput = bankScanner.nextInt();
	
		switch (customerInput) {
		case 1:
			// balanceDisplay();
			System.out.println("Customer balance: " + getBalanceUser1());
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 2:
			System.out.println("Withdraw");
			WithdrawFromCustomerAccount.withdrawFromBalance();
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 3:
			System.out.println("Deposit");
			DepositToAccount.depositToBalance();
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 4:
			System.out.println("Exiting");
			logoutVerify();
		default:
			if (customerInput < 1 || customerInput > 4) {
				System.out.println("Not recognized.");
				menuOptionsForCustomerInput();
			}
		}

	}

	//WITHDRAW CODE WAS HERE

	//DEPOSIT CODE WAS HERE
	private static void logoutVerify() {
		System.out.println("Enter PIN to logout or Press '1' to return: ");
		int pinInput = bankScanner.nextInt(); 
		
		if(pinInput == pinNumber) {
			System.out.println("Logging off");
			Main.main(null);
		} else if (pinInput == 1){
			menuOptionsForCustomerInput();
		} else {
			System.out.println("Input Not Recognized");
			logoutVerify();
		}

		//switch(pinInput) {
		//case 8939:
		//	System.out.println("Logging off");
		//	Main.main(null);
		//case 1:
		//	menuOptionsForCustomerInput();
		//default:
		//	if(pinInput != 8939 || pinInput != 1) {
		//		System.out.println("Input Not Recognized");
		//		logoutVerify();
		//	}
		
		
		
	}


	
}
