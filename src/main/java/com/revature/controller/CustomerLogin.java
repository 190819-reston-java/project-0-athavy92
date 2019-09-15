package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.Customer;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoImplementations;
import java.util.Scanner;

public class CustomerLogin {

	private static Logger bankLoginLogger = Logger.getLogger(CustomerLogin.class);
	protected static Scanner bankScanner = new Scanner(System.in);
		
	protected String customerUsernameInput;
	protected String customerPasswordInput;
	protected int customerPINInput;
	
	//protected Customer user = new Customer();

	public Customer login(Customer user) {	
		
		user = new Customer();

		CustomerController cc = new CustomerController();
		
		BankDao dbUser = new BankDaoImplementations();

		System.out.println("Enter Username: ");
		customerUsernameInput = bankScanner.next().trim();
		System.out.println("Enter Password: ");
		customerPasswordInput = bankScanner.next().trim();
		System.out.println();
		
		
		bankLoginLogger.warn("Accessing database");
		user = dbUser.getCustomerAccount(customerUsernameInput, customerPasswordInput);
		
		
		if (user != null) {
			bankLoginLogger.warn("Checking database for matching username and password");
			System.out.println("Welcome " + user.getFirstname().toUpperCase());
			System.out.println("Enter PIN:");
			customerPINInput = bankScanner.nextInt();
			user = dbUser.getCustomerAccountVerfication(customerUsernameInput, customerPasswordInput, customerPINInput);
			if (user != null) {
				cc.menuOptionsForCustomerInput(user);
			} else {
				System.out.println("PIN invalid.");
			}
			
			
			//cc.menuOptionsForCustomerInput(user);
			
		} else {
			System.out.println("Username/Password not valid. Please try again");
			MainMenu.selectUser();
			//return user;
		}	
		return user;

	}			

	
	
}
	


