package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Customer;

public class CreateNewCustomer extends Customer {
	
	private static Scanner bankScanner = new Scanner(System.in);

	public CreateNewCustomer(String firstName, String username, String password) {
		super(firstName, username, password);
		
	}

	

}
