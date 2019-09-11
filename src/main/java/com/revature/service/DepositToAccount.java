package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.controller.CustomerController;
import com.revature.exception.DepositException;
import com.revature.model.Customer;

public class DepositToAccount extends CustomerController {
	static Logger depositLogger = Logger.getLogger(DepositToAccount.class);

	public static float depositToBalance(float i, float j) throws DepositException {
		
		Customer balanceAmt = new Customer();

		
		System.out.println("Enter amount to deposit: ");
		float depositAmount = bankScanner.nextFloat();
		
		i = depositAmount;
		j = balanceAmt.getBalance();
		
		if (i > 5000) {
			System.out.println("Deposit too large. Please enter a different amount.");
			depositLogger.debug("User trying to deposit a large amount");
			throw new DepositException("Deposit too large");
		} else if (i <= 0) {
			System.out.println("Deposit cannot be negative.");
			depositLogger.debug("User trying to deposit a negative amount");
			throw new DepositException("Invalid deposit. Cannot deposit 0 or less");
		}else {
			float balanceAfterDeposit = j + i;
			System.out.println("Deposit Amount Confirmation: " + i);
			System.out.println("NEW BALANCE :" + balanceAfterDeposit);
			
			balanceAmt.setBalance(balanceAfterDeposit);
		}
		
		depositLogger.info("New Balance Set After Deposit");
		
		CustomerController.menuOptionsForCustomerInput();
		return (float) 0.0;

	}

}
