package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.Customer;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoImplementations;
import com.sun.tools.javac.Main;

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

	public Customer login(Customer user) {

		System.out.println("Enter Username: ");
		customerUsernameInput = bankScanner.next().trim();
		System.out.println("Enter Password: ");
		customerPasswordInput = bankScanner.next().trim();
		System.out.println();

		bankLoginLogger.warn("Accessing database");
		user = dbUser.getCustomerAccount(customerUsernameInput, customerPasswordInput);

		bankLoginLogger.warn("Checking database for matching username and password");
		if (user != null) {
			System.out.println("Welcome " + user.getFirstname().toUpperCase());
			checkPIN(user);

		} else {
			System.out.println("Username/Password not valid. Please try again");
			MainMenu.selectUser();
		}
		
		MainMenu.selectUser();

		return user;

	}
	
	
	public void checkPIN(Customer user) {
		CustomerController cc = new CustomerController();

		System.out.println("Enter PIN: ");
		customerPINInput = bankScanner.nextInt();
		user = dbUser.getCustomerAccountVerfication(customerUsernameInput, customerPasswordInput, customerPINInput);
		if (user != null) {
			cc.menuOptionsForCustomerInput(user);
		} else {
			failedPINCounter++;
			bankLoginLogger.warn("Failed PIN: " + failedPINCounter);
			if (failedPINCounter > 3) {
				System.out.println("Too many failed PIN attempts.");
				MainMenu.selectUser();
			} 
			checkPIN(user);
		}
		
	}

}
