package com.revature.controller;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
	
	static Logger bankMainMenuLogger = Logger.getLogger(MainMenu.class);

	private static Scanner bankScanner = new Scanner(System.in);

	
	public static void selectUser() {		
		bankMainMenuLogger.info("Main Menu Started");
		System.out.println("-------------------------------------");

		System.out.println("Select your user access:");
		System.out.println("1 Customer");
		System.out.println("2 Employee");

		

		int userSelected = bankScanner.nextInt(); 

		//will throw an InputMismatchException if use anything other than int
		
		//try {
		//	userSelected = selectNum.nextInt();
		//} catch(InputMismatchException e) {
		//	bankMainMenuLogger.warn("User Input: " + userSelected, e);
		//	throw new InputMismatchException("Invalid Input");
		//}

		switch (userSelected) {
		case 1:
			CustomerLogin.customerLoginCredentials();
			break;
		case 2:
			System.out.println("Welcome to Employee Options");
			System.out.println("------------------------");
			break;
		default:		
			bankMainMenuLogger.debug("User Input: " + userSelected);
			bankMainMenuLogger.error("Input Invalid");
		}
		selectUser();
	}
	
 }
 