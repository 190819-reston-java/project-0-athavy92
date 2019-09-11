package com.revature.model;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckingAccount extends Customer {

	static Scanner createNewUser = new Scanner(System.in);	
	
		
	public void createNewChecking() {
		
		System.out.println("Enter first name:");
		this.setFirstName(createNewUser.next());
		System.out.println("Enter username:");
		this.setUsername(createNewUser.next());
		System.out.println("Enter password: ");
		this.setPassword(createNewUser.next());
		
		
		ArrayList<Customer> checkingAccountUsers = new ArrayList<Customer>();
		checkingAccountUsers.add(new Customer());		
		System.out.println(checkingAccountUsers);
	}
}
	
	
