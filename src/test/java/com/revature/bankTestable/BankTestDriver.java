package com.revature.bankTestable;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Customer;


public class BankTestDriver {
	
	private static Customer c = null;
	
	@Before
	public void setUp() {
		BankDaoMock c = new BankDaoMock();
	

	}
	
	
	@Test
	public void userRetrievalTest () {
		
		//c = new Customer(new BankDaoMock());
		BankDaoMock dbUserMock = new BankDaoMock();
		String usernameInput = "ReadyPlayerOne";
		
		
		assertTrue((dbUserMock.getUsername(usernameInput).equals(usernameInput)));
		
		
	}
	
	
}

