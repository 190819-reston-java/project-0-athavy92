package com.revature.controller;

import org.apache.log4j.Logger;

//import java.io.Console;
import java.util.Scanner;
import com.revature.service.CustomerAccounts;

public class CustomerLogin {	
	
	//static Console console = System.console();

	protected static Logger loginLogger = Logger.getLogger(CustomerLogin.class);
	public static Scanner bankScanner = new Scanner(System.in);
	
	//TESTING username and password
	private static String username = "alecthav";
	private static String password = "Password1#";
	
	public static void customerLoginCredentials() {

		// Username and password
		System.out.println("Enter Username: ");
		String user = bankScanner.next();
		System.out.println("Enter Password: ");
		String pass = bankScanner.next();
		
		//Attempting to hide Password but it may not work in Eclipse
		//char[] passString = console.readPassword();
		//String pass = new String(passString);
		if (user.equals(username) && pass.equals(password)) { //I want to match reference 
			CustomerAccounts.customerPIN();
		}else {
			loginLogger.debug("User Input: " + user + pass);
			System.out.println("Invalid Credentials");
			customerLoginCredentials();
		}
		
	  //Logic/Exception to check if login is valid will go here

	}

	
}
