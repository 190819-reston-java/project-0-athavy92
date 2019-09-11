package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.Customer;

//import java.io.Console;
import java.util.Scanner;

public class CustomerLogin {	
	
	private static Logger bankLoginLogger = Logger.getLogger(CustomerLogin.class);
	protected static Scanner bankScanner = new Scanner(System.in);

	public static void customerLoginCredentials(String u, String p) {
		
		Customer chk = new Customer();
		//Created an instance of Customer class to utilize getter

		System.out.println("Enter Username: ");		
		u = bankScanner.next();

		System.out.println("Enter Password: ");		
		p = bankScanner.next();

		
		//Attempting to hide Password but it may not work in Eclipse
		//char[] passString = console.readPassword();
		//String pass = new String(passString);
		if (u.equals(chk.getUsername()) && p.equals(chk.getPassword())) { 
			CustomerController.customerPIN();
		}else {
			bankLoginLogger.debug("User Input: " + u + p);
			System.out.println("Invalid Credentials");
			MainMenu.selectUser();
		}
		
	}

	
}
