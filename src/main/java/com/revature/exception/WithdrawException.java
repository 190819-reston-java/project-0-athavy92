package com.revature.exception;

import com.revature.controller.CustomerController;

public class WithdrawException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WithdrawException (String message) {
		CustomerController.menuOptionsForCustomerInput();
	}
}
