package com.revature.service;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.revature.service.CustomerAccounts;
import com.revature.Main;
import com.revature.controller.CustomerLogin;

public class CustomerAccounts extends CustomerLogin {
	private static float balanceUser1 = (float) 5000.00;

	private static Scanner numPad = new Scanner(System.in);

	public static void menuOptionsForCustomerInput() {
		System.out.println("Please choose an option:");
		System.out.println("1 View Balance");
		System.out.println("2 Withdraw");
		System.out.println("3 Deposit");
		System.out.println("4 Exit");

		int customerInput = numPad.nextInt();

		switch (customerInput) {
		case 1:
			// balanceDisplay();
			System.out.println("Customer balance: " + balanceUser1);
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			break;
		case 2:
			System.out.println("Withdraw");
			withdrawFromBalance();
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			break;
		case 3:
			System.out.println("Deposit");
			depositToBalance();
			System.out.println("------------------------");
			menuOptionsForCustomerInput();
			break;
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

	private static void withdrawFromBalance() {
		System.out.println("Enter amount to withdraw: ");
		float withdrawAmount = numPad.nextFloat();

		float balanceAfterWithdraw = balanceUser1 - withdrawAmount;

		System.out.println(balanceAfterWithdraw);

		balanceUser1 = balanceAfterWithdraw;

		// Will replace with Exception to stop withdrawing from balance
		if (balanceUser1 < 0) {
			System.out.println("Cannot withdraw. No funds available");
		}
	}

	private static void depositToBalance() {
		System.out.println("Enter amount to deposit: ");
		float depositAmount = numPad.nextFloat();
		float balanceAfterDeposit = balanceUser1 + depositAmount;
		System.out.println(balanceAfterDeposit);
		balanceUser1 = balanceAfterDeposit;

	}
	private static void logoutVerify() {
		System.out.println("Enter PIN to logout or Press '1' to return: ");

		int pinInput = numPad.nextInt(); 
		
		switch(pinInput) {
		case 8939:
			System.out.println("Logging off");
			Main.main(null);
		case 1:
			menuOptionsForCustomerInput();
		}
		
		
		
		
		
	}
	
}
