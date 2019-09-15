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
		System.out.println("Select to sign in or register:");
		System.out.println("1 - Customer Sign In");
		System.out.println("2 - Create Account");
		System.out.println("\n");

		String userSelected = bankScanner.next();

		switch (userSelected) {
		case "1":
			login.login(null);
			break;
		case "2":
			System.out.println("Open Account");
			System.out.println("------------------------");
			CreateAccount.register(null); 
			break;
		default:
			bankMainMenuLogger.info("User Input: " + userSelected);
			System.out.println("Input Invalid.");
			selectUser();
		}
	}

}
