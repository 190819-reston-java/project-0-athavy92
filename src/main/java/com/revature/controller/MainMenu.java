package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.CustomerAccounts;

public class MainMenu {
	
	private static Scanner selectNum = new Scanner(System.in);
	
	public static void WelcomeMessage() {
		System.out.println("Select your user access:");
		System.out.println("1 Customer");
		System.out.println("2 Employee");
	}
	
	public static void selectUser() {
		
		
		int userSelected = selectNum.nextInt(); 
		//will throw an InputMismatchException if use anything other than int
		
		
		switch (userSelected) {
		case 1:
			CustomerLogin.customerLoginCredentials();
			break;
		case 2:
			System.out.println("Welcome to Employee Options");
			System.out.println("------------------------");
			break;
		}
		selectUser();
	}
	
 }
 