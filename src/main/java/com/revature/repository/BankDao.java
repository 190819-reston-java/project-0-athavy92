package com.revature.repository;

import java.util.List;
import com.revature.model.Customer;

public interface BankDao {
	
	List<Customer> getCustomers();
	
	Customer getCustomerAccount(String username, String password);
	
	Customer getUsername(String username);
	
	Customer getPassword(String password);
	
	//Customer getFirstName(String firstName);
	
	//Customer getBalance(String username);
	
	Customer getPin(int pin);
	
	Customer getCustomerAccountVerfication(String username, String password, int pin);
	
	boolean updateAccount (Customer bc);
	//boolean updateBalance(double bc, String username);
	
	boolean createNewAccount(Customer bc);

	boolean updateBalance(double balanceAmt, String username);

	
}
	