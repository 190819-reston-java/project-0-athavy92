package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.Customer;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoImplementations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLogin {

	private static Logger bankLoginLogger = Logger.getLogger(CustomerLogin.class);
	protected static Scanner bankScanner = new Scanner(System.in);

	int failedLoginCounter = 0;

	protected String customerUsernameInput;
	protected String customerPasswordInput;
	protected int customerPINInput;

	int failedPINCounter = 0;
	BankDao dbUser = new BankDaoImplementations();

	public Customer login(Customer accountHolder) {

		System.out.println("Enter Username: ");
		customerUsernameInput = bankScanner.next().trim();
		System.out.println("Enter Password: ");
		customerPasswordInput = bankScanner.next().trim();
		System.out.println();

		bankLoginLogger.info("Accessing database");
		accountHolder = dbUser.getCustomerAccount(customerUsernameInput, customerPasswordInput); 

		bankLoginLogger.info("Checking database for matching username and password");
		if (accountHolder != null) {
			System.out.println("Welcome " + accountHolder.getFirstname().toUpperCase());
			checkPIN(accountHolder);

		} else {
			System.out.println("Username/Password not valid. Please try again");
			MainMenu.selectUser();
		}

		MainMenu.selectUser();

		return accountHolder;

	}

	public void checkPIN(Customer accountHolder) {
		AccountHolderTerminal cc = new AccountHolderTerminal();

		System.out.println("Enter PIN: ");
		try {
			customerPINInput = bankScanner.nextInt();
			bankLoginLogger.info("Accessing database to verify pin");
			accountHolder = dbUser.getCustomerAccountVerfication(customerUsernameInput, customerPasswordInput, customerPINInput);
			if (accountHolder != null) {
				System.out.println("Login Successful.");
				cc.menuOptionsForCustomerInput(accountHolder);
			} else {
				failedPINCounter++;

				bankLoginLogger.warn("Failed PIN: " + failedPINCounter);

				if (failedPINCounter > 3) {
					System.out.println("Too many failed PIN attempts.");
					MainMenu.selectUser();
				}
				checkPIN(accountHolder);
			}
		} catch (InputMismatchException e) {
			bankLoginLogger.debug("Invalid input type.", e);
			System.out.println("Input invalid. Please enter a numeric value.");
			bankScanner.next();
		}

	}

}
