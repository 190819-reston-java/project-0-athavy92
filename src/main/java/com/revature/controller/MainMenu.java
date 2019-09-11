package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.CheckingAccount;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
	
	private static Logger bankMainMenuLogger = Logger.getLogger(MainMenu.class);

	static Scanner bankScanner = new Scanner(System.in);

	public static void selectUser() throws InputMismatchException {		
		bankMainMenuLogger.info("Main Menu Started");
		System.out.println("-------------------------------------");

		System.out.println("Select your sign in or register:");
		System.out.println("1 - Customer Sign In");
		System.out.println("2 - Create Account");
		
		try {
			int userSelected = bankScanner.nextInt();

			// will throw an InputMismatchException if use anything other than int

			// try {
			// userSelected = selectNum.nextInt();
			// } catch(InputMismatchException e) {
			// bankMainMenuLogger.warn("User Input: " + userSelected, e);
			// throw new InputMismatchException("Invalid Input");
			// }

			switch (userSelected) {
			case 1:
				CustomerLogin.customerLoginCredentials(null, null);
				break;
			case 2:
				System.out.println("Create New Customer");
				System.out.println("------------------------");
				CheckingAccount chk = new CheckingAccount();
				chk.createNewChecking();
				break;
			default:
				bankMainMenuLogger.debug("User Input: " + userSelected);
				bankMainMenuLogger.debug("Input Invalid");
				selectUser();
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
			bankMainMenuLogger.error("User tried to input something other than a number (double), which would throw a Scanner exception and stop the program");
			bankScanner.nextLine();
		} 
	}


 }
 