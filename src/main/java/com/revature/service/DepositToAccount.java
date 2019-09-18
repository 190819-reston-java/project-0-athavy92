package com.revature.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.controller.AccountHolderTerminal;
import com.revature.exception.DepositException;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;
import com.revature.repository.BankDao;

import com.revature.repository.BankDaoImplementations;

public class DepositToAccount extends AccountHolderTerminal {
	
	AccountHolderTerminal cc = new AccountHolderTerminal();
	BankDao dbUser = new BankDaoImplementations();
	
	private static Logger depositLogger = Logger.getLogger(DepositToAccount.class);

	public void deposit(Customer accountHolder) throws DepositException {
					
		Customer accountBalance = accountHolder;

		depositLogger.info("Deposit method implemented");
		System.out.println("-------------------------------------");
		System.out.println("Enter amount to deposit: ");
		
		try {
		double depositAmount = bankScanner.nextDouble();
		Double i = Math.abs(depositAmount);
		Double j = accountBalance.getBalance();

		if (i > 10000) {
			System.out.println("Deposit too large. Plese enter a different amount or visit a branch.");
			depositLogger.warn("User trying to deposit a large amount");
			deposit(accountHolder);
			throw new DepositException("Insufficient Funds");
		}else {
			double balanceAfterDeposit = j + i;
			System.out.println("Deposit Amount Confirmation: " + df.format(i));
			System.out.println("NEW BALANCE: $" + df.format(balanceAfterDeposit));
			
			accountBalance.setBalance(balanceAfterDeposit);		
			depositLogger.info("Updating into database");
			dbUser.updateAccount(accountBalance);
		}
		} catch (InputMismatchException e) {
			depositLogger.debug("Invalid input type",e);
			System.out.println("Invalid input. Please enter a numeric value");
			bankScanner.next();
		}
			

		cc.menuOptionsForCustomerInput(accountHolder);

	
	}

}
