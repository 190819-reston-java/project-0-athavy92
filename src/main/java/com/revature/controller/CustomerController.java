package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.service.DepositToAccount;
import com.revature.service.WithdrawFromAccount;
import com.revature.Main;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;
import com.revature.repository.BankDAOMethods;
import com.revature.repository.BankData;


public class CustomerController extends CustomerLogin {

	private static Logger customerAccountLogger = Logger.getLogger(CustomerController.class);
	
	//MENU OPTIONS FOR USER
	public void menuOptionsForCustomerInput(Customer accountHolder) {
		

		System.out.println("Please choose an option:");
		System.out.println("1 - View Balance");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Exit");
		
		String customerInput = bankScanner.next();
		
		WithdrawFromAccount userWithdraw = new WithdrawFromAccount();
		DepositToAccount userDeposit = new DepositToAccount();
	
		switch (customerInput) {
		case "1":
			// balanceDisplay();
			System.out.println("Customer balance: " + accountHolder.getBalance());
			System.out.println("------------------------");
			menuOptionsForCustomerInput(accountHolder);
			//break;
		case "2":
			System.out.println("Withdraw");
			userWithdraw.withdraw(accountHolder);
			System.out.println("------------------------");
			//break;
		case "3":
			System.out.println("Deposit");
			userDeposit.deposit(accountHolder);
			System.out.println("------------------------");
			//break;
		case "4":
			System.out.println("Exiting");
			System.out.println("------------------------");
			logoutVerify();
		default:
			System.out.println("Input Not Recognized.");
			System.out.println("------------------------");
			menuOptionsForCustomerInput(accountHolder);
		}

	}
		
	
	
	//LOGOUT METHOD
	private void logoutVerify() {
				
//		System.out.println("Enter PIN to logout or Press '1' to return: ");
//		int pinInput = bankScanner.nextInt(); 
//		
//		if(pinInput == user.getPinNumber()) {
//			System.out.println("Logging off");
//			System.out.println("------------------------");
//			customerAccountLogger.info("Returning to main");
//			Main.main(null);
//		} else if (pinInput == 1){
//			//menuOptionsForCustomerInput(accountHolder);
//		} else {
//			System.out.println("Input Not Recognized");
//			System.out.println("------------------------");
//			logoutVerify();
//		}
		
	}

	
}
