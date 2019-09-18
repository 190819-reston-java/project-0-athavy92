package com.revature.bankTestable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.BankDao;

public class MockBankDao implements BankDao {

	Customer tb = new Customer(12, "Tom", "TB12", "theGOAT", 1212, 12000);
	Customer cn = new Customer(1, "Cam", "SuperCam", "panthersQB1", 1111, 5000);
	
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> testUsers = new ArrayList<Customer>(Arrays.asList(tb, cn));
		return testUsers;
	}

	@Override
	public boolean createNewAccount(Customer bc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerAccount(String username, String password) {	
		return null;
	}

	@Override
	public Customer getCustomerAccountVerfication(String username, String password, int pin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Customer bc) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
