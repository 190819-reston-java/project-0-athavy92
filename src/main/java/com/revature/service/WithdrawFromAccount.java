package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.controller.CustomerController;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;

public class WithdrawFromAccount extends CustomerController {
	static Logger withdrawLogger = Logger.getLogger(WithdrawFromAccount.class);


	public static float withdraw(float i, float j) throws WithdrawException {
		
		Customer balanceAmt = new Customer();
		
		withdrawLogger.info("Withdraw method implemented");
		System.out.println("-------------------------------------");
		System.out.println("Enter amount to withdraw: ");
		
		float withdrawAmount = bankScanner.nextFloat();
		i = withdrawAmount;
		j = balanceAmt.getBalance();
		
		if (i > j) {
			System.out.println("Unable to process. Account overdrawn.");
			withdrawLogger.debug("User trying to withdraw more than balance");
			throw new WithdrawException("Insufficient Funds");
		} else if (i <= 0) {
			System.out.println("Invalid input. Please enter a positive number.");
			withdrawLogger.debug("User trying to withdraw with a negative input");
			throw new WithdrawException("Invalid input");
		}else {
			float balanceAfterWithdraw = j - i;
			System.out.println("Withdrawal Amount Confirmation: " + i);
			System.out.println("NEW BALANCE: " + balanceAfterWithdraw);
			balanceAmt.setBalance(balanceAfterWithdraw);
		}			
		
		withdrawLogger.info("New Balance Set After Withdrawal");
		CustomerController.menuOptionsForCustomerInput();

		return (float) 0.0;
	}
	
}
