package com.revature.service;

import com.revature.exception.WithdrawException;

public class WithdrawFromCustomerAccount extends CustomerAccounts {
		
	
	protected static void withdrawFromBalance() throws WithdrawException {
		System.out.println("Enter amount to withdraw: ");
		float withdrawAmount = bankScanner.nextFloat();
		
		if (withdrawAmount > getBalanceUser1()) {
			throw new WithdrawException("Insuffient Funds");
		} else {
			float balanceAfterWithdraw = getBalanceUser1() - withdrawAmount;
			System.out.println(balanceAfterWithdraw);

			setBalanceUser1(balanceAfterWithdraw);
		}

	CustomerAccounts.menuOptionsForCustomerInput();


	}
}
