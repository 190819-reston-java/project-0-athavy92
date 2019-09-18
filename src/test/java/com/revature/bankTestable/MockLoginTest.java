package com.revature.bankTestable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.controller.CustomerLogin;
import com.revature.model.Customer;
import com.revature.repository.BankDao;
import com.revature.service.DepositToAccount;
import com.revature.service.WithdrawFromAccount;

public class MockLoginTest {
	private static CustomerLogin testLogin;
	private static Customer testUser1;
	private static Customer testUser2;	
	private static BankDao mockBankDao = null;
	private static Customer testUser = null;

	
	@Before
	public void setUp() {
		testUser1 = new Customer (1, "Cam", "SuperCam", "panthersQB1", 1111, 5000);
		mockBankDao = new MockBankDao();

	}
	
	
	@Test
	public void loginVerification() {
		String testUsername = "SuperCam";
		String testPassword = "panthersQB1";
		for (Customer ct : mockBankDao.getCustomers()) {
			if (ct.getUsername().equals(testUsername) && ct.getUserPass().equals(testPassword)) {
				System.out.println("User valid.");
			} else {
				System.out.println("User fail");
			}
		}
		
		
		
	}
	
	@After
	public void tearDown() {
		testUser1 = null;
		mockBankDao = null;
		
	}

}
