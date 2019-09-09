package com.revature.service;

public class DepositToAccount extends CustomerAccounts {
	
	protected static void depositToBalance() {
		System.out.println("Enter amount to deposit: ");
		float depositAmount = bankScanner.nextFloat();
		float balanceAfterDeposit = getBalanceUser1() + depositAmount;
		System.out.println(balanceAfterDeposit);
		setBalanceUser1(balanceAfterDeposit);

	}

}
