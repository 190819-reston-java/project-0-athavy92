package com.revature.bankTestable;

import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.BankDao;

public class BankDaoMock implements BankDao {

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getAccountID(int id) {
		if (id == 1) {
			return new Customer(0, "SuccessfulID1", "password", 0000, 0);
		}
		return null;
	}
	
	@Override
	public Customer getCustomerAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getUsername(String username) {
		if(username.equals("ReadyPlayerOne")) {
			return new Customer(8, "SuccessfulUsername", "password", 0000, 0);
		}
		return null;
	}

	@Override
	public Customer getPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getPin(int pin) {
		// TODO Auto-generated method stub
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

	@Override
	public boolean createNewAccount(Customer bc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBalance(double balanceAmt, String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
