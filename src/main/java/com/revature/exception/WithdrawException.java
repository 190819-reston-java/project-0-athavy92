package com.revature.exception;

import com.revature.service.WithdrawFromAccount;

public class WithdrawException extends RuntimeException {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	WithdrawFromAccount userInvalidWithdraw = new WithdrawFromAccount();
	public WithdrawException (String message) {

	}
}
