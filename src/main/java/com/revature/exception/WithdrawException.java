package com.revature.exception;

import com.revature.service.CustomerAccounts;

public class WithdrawException extends RuntimeException {

	public WithdrawException(String message) {
		System.out.println("Insufficient Funds");
		CustomerAccounts.menuOptionsForCustomerInput();
	}
}
