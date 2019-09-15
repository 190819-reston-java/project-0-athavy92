package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.Customer;
import com.revature.repository.BankData;
import com.revature.repository.BankDAOMethods;
import java.util.Scanner;

public class CustomerLogin {

	private static Logger bankLoginLogger = Logger.getLogger(CustomerLogin.class);
	protected static Scanner bankScanner = new Scanner(System.in);
		
	protected String customerUsernameInput;
	protected String customerPasswordInput;
	protected int pinInput;
	
	//protected Customer user = new Customer();

	public Customer login(Customer user) {	
		
		user = new Customer();

		CustomerController cc = new CustomerController();
		
		BankData dbUser = new BankDAOMethods();

		System.out.println("Enter Username: ");
		customerUsernameInput = bankScanner.next();
		System.out.println("Enter Password: ");
		customerPasswordInput = bankScanner.next();
		System.out.println();

		user = dbUser.getCustomerAccount(customerUsernameInput, customerPasswordInput);
		

		
		if (user != null) {
			System.out.println("Welcome " + user.getFirstname().toUpperCase());
			cc.menuOptionsForCustomerInput(user);
			
		} else {
			System.out.println("Username/Password not valid. Please try again");
			MainMenu.selectUser();
		}	
		return user;

	}			

	
	
}
	


