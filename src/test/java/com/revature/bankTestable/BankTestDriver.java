package com.revature.bankTestable;


import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.controller.CustomerLogin;
import com.revature.model.Customer;

import com.revature.repository.BankDAOMethods;
import com.revature.repository.BankData;
import com.revature.service.WithdrawFromAccount;

public class BankTestDriver {
	
	@Test
	public void userRetrievalTest () {
		BankData userRetrieval = new BankDAOMethods();
		Customer user = new Customer();
		user.getUsername();
		//String 
		//assertTrue()
	}
	
	
}

