package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Main;
import com.revature.model.Customer;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoImplementations;

public class CreateAccount {
	private static Logger registrationLogger = Logger.getLogger(CreateAccount.class);
	static Scanner bankScanner = new Scanner(System.in);
	static BankDao dbUser = new BankDaoImplementations();

	// String constructors
	private static String createUsernameInput = "";
	private static String createPasswordInput = "";

	public static void register(Customer newUser) {

		newUser = new Customer();

		System.out.println("Enter your first name:");
		String firstName = bankScanner.next().trim();
		System.out.println("Enter a username:");
		createUsernameInput = bankScanner.next().trim();

		newUser = dbUser.getUsername(createUsernameInput);

		// Check to see if username already exists
		registrationLogger.info("Checking database for username match.");
		if (newUser != null) {
			System.out.println("Username exists. Please enter a new one.");
			register(null);
		}
		System.out.println("Enter a password:");
		createPasswordInput = bankScanner.next().trim();
		System.out.println("Acccount username available.");

		System.out.println("Enter a 4-digit PIN:");
		int newPINInput = bankScanner.nextInt();
		if (String.valueOf(newPINInput).length() != 4) {
			System.out.println("Invalid PIN. Please enter a 4-digit PIN");
			register(null);
		}

		System.out.println("Please make a deposit or enter 0 to exit.");
		double newCustomerDeposit = bankScanner.nextDouble();
		
		//Creating user into database
		registrationLogger.info("Creating new user and adding to database");
		dbUser.createNewAccount(
				new Customer(0, firstName, createUsernameInput, createPasswordInput, newPINInput, newCustomerDeposit));

		System.out.println("Thank you! Account created. Returning to main menu. Please login to check balance.");
		Main.main(null);

	}

}
