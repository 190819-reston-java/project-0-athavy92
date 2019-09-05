package com.revature.controller;

import java.util.Scanner;
import com.revature.service.CustomerAccounts;

public class CustomerLogin {
	private static Scanner pinPad = new Scanner(System.in);
	private static Scanner loginInfo = new Scanner(System.in);

	public static void customerLoginCredentials() {

		// Username and password
		System.out.println("Enter Username: ");
		String user = loginInfo.next();
		System.out.println("Enter Password: ");
		String pass = loginInfo.next();

		if (user.equals("alecthav") && pass.equals("password1#")) {
			System.out.println("Welcome");
			customerPIN();
		}else {
			System.out.println("Invalid Credentials");
			customerLoginCredentials();
		}
		
	  //Logic/Exception to check if login is valid will go here

	}

	private static void customerPIN() {
		System.out.println("Press enter PIN: ");

		int pinInput = pinPad.nextInt(); 
		int failedPINCounter = 0;
		  
		if (pinInput == 8939) {
			CustomerAccounts.menuOptionsForCustomerInput();
		} else if (pinInput != 8939) {
			System.out.println("Wrong PIN");
			customerLoginCredentials();
			failedPINCounter++;
		} else if (failedPINCounter > 3) {
			System.out.println("Too many failed attempts");
		}
	}
}
