package com.revature.repository;

import java.util.List;
import com.revature.model.Customer;

public interface BankData {
	
	List<Customer> getCustomers();
	
	Customer getCustomerAccount(String username, String password);
	
	Customer getUsername(String username);
	
	Customer getPassword(String password);
	
	//Customer getFirstName(String firstName);
	
	//Customer getBalance(String username);
	
	Customer getPin(int pin);
	
	boolean updateAccount (Customer bc);
	//boolean updateBalance(double bc, String username);
	
	boolean createNewAccount(Customer bc);
	
}
	