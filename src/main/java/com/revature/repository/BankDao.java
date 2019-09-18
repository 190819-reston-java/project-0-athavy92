package com.revature.repository;

import java.util.List;
import com.revature.model.Customer;

public interface BankDao {
	
	List<Customer> getCustomers();
	boolean createNewAccount(Customer bc);
	Customer getUsername(String username);
	Customer getCustomerAccount(String username, String password);
	Customer getCustomerAccountVerfication(String username, String password, int pin);
	boolean updateAccount (Customer bc);

	
	//Customer getPassword(String password);
	
	
	
	//Customer getPin(int pin);
	

	//boolean updateBalance(double balanceAmt, String username);

	
}
	