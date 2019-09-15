package com.revature.controller;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

	private static Logger bankMainMenuLogger = Logger.getLogger(MainMenu.class);

	static Scanner bankScanner = new Scanner(System.in);
	
	public static void selectUser() {
		CustomerLogin login = new CustomerLogin();
		
		bankMainMenuLogger.info("Main Menu Started");
		System.out.println("Select your sign in or register:");
		System.out.println("\n");
		System.out.println("1 - Customer Sign In");
		System.out.println("\n");
		System.out.println("2 - Create Account");
		System.out.println("\n");

		String userSelected = bankScanner.next();

		switch (userSelected) {
		case "1":
			login.login(null);
			break;
		case "2":
			System.out.println("Create New Customer");
			System.out.println("------------------------");
			CreateAccount.createNewCustomer(null); 
			break;
		default:
			bankMainMenuLogger.debug("User Input: " + userSelected);
			bankMainMenuLogger.debug("Input Invalid");
			selectUser();
		}
	}

}
