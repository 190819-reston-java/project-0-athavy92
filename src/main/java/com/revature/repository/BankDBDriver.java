package com.revature.repository;

import java.util.Scanner;

import com.revature.model.Customer;

public class BankDBDriver {

	public static void main(String[] args) {
		BankAppConnectionUtil.getConnection();
		
		BankData test = new BankDAOMethods();
		
		for (Customer c : test.getCustomers()) {
			System.out.println(c);
		};
		
		//test.createNewAccount(new Customer(0, "Alison", "Wonderland4", "peace05", 7878, 20000));
		//System.out.println(test.getBalance("illenium3", 3));
				
		//System.out.println(test.getCustomerAccount("ReadyPlayerOne", "jumpman23$"));
//
		//System.out.println(test.getCustomerAccount("ReadyPlayerOne", "Password1#"));
		
		
		//System.out.println(test.updateBalance(8000, "ReadyPlayerOne"));
		
		//System.out.println(test.getCustomerAccount("ReadyPlayerOne", "jumpman23"));
		
	}
}
		
//}
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Username:");
//		String u = sc.nextLine();
//		System.out.println(test.getCustomerUsername(u));
//
//		String p = sc.nextLine();
//
//		
	
		//System.out.println(test.getCustomerBalance(1));
		
		
//		for(Customer c : test.getCustomers()) {
//				test.updateBalance(8000, 2);
//			}			
		
		//test.updateBalance(30000, 2);
				
		//test.updateBalance((test.getCustomerBalance(2)+1000), 2);
			
		//System.out.println(test.getAccountId(1));
		//System.out.println(test.getCustomerUsername("ReadyPlayerOne"));
		
		//System.out.println(test.getAccountId(2));
		//System.out.println(test.getCustomerLogin(null, null));
		
