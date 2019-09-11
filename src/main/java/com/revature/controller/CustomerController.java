package com.revature.controller;



import org.apache.log4j.Logger;

import com.revature.service.DepositToAccount;
import com.revature.service.WithdrawFromAccount;
import com.revature.Main;
import com.revature.model.Customer;

public class CustomerController extends CustomerLogin {

	private static Logger customerAccountLogger = Logger.getLogger(CustomerController.class);
	
	//Input for PIN
	public static void customerPIN() {
		
		Customer pinNum = new Customer();
		Customer acctName = new Customer();

		
		System.out.println("Press enter PIN: ");
		int pinInput = bankScanner.nextInt(); 
		int failedPINCounter = 0;

		if (pinInput == pinNum.getPin()) {		
			System.out.println("-------------------------------------");
			System.out.println("Welcome " + acctName.getFirstName());
			System.out.println();
			menuOptionsForCustomerInput();
		} else if (pinInput != pinNum.getPin()) {
			System.out.println("Wrong PIN");
			failedPINCounter++;		
			customerAccountLogger.debug("Failed pin attempts: " + failedPINCounter);			
			}	
		customerPIN();	
		
		if (failedPINCounter > 3) {
		customerAccountLogger.fatal("Too many failed attempts");
		}
	}		
	
	//MENU OPTIONS FOR USER
	public static void menuOptionsForCustomerInput() {
		
		Customer balanceAmt = new Customer();
		
		System.out.println("Please choose an option:");
		System.out.println("1 - View Balance");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Exit");

		int customerInput = bankScanner.nextInt();
	
		switch (customerInput) {
		case 1:
			// balanceDisplay();
			System.out.println("Customer balance: " + balanceAmt.getBalance());
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 2:
			System.out.println("Withdraw");
			WithdrawFromAccount.withdraw(customerInput, balanceAmt.getBalance());
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 3:
			System.out.println("Deposit");
			DepositToAccount.depositToBalance(customerInput, balanceAmt.getBalance());
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			//break;
		case 4:
			System.out.println("Exiting");
			System.out.println("------------------------");
			logoutVerify();
		default:
			System.out.println("Input Not Recognized.");
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
		}

	}
	
	//LOGOUT METHOD
	private static void logoutVerify() {
		
		Customer pinNum = new Customer();
		
		System.out.println("Enter PIN to logout or Press '1' to return: ");
		int pinInput = bankScanner.nextInt(); 
		
		if(pinInput == pinNum.getPin()) {
			System.out.println("Logging off");
			System.out.println("------------------------");
			customerAccountLogger.info("Returning to main");
			Main.main(null);
		} else if (pinInput == 1){
			menuOptionsForCustomerInput();
		} else {
			System.out.println("Input Not Recognized");
			System.out.println("------------------------");
			logoutVerify();
		}
		
	}

	
}
