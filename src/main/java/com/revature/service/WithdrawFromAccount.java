package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.controller.CustomerController;
import com.revature.controller.CustomerLogin;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;
import com.revature.repository.BankDaoImplementations;
import com.revature.repository.BankDao;

public class WithdrawFromAccount extends CustomerController {
	private static Logger withdrawLogger = Logger.getLogger(WithdrawFromAccount.class);	
	CustomerController cc = new CustomerController();
	BankDao dbUser = new BankDaoImplementations();
	Throwable t;
	
	public void withdraw(Customer accountHolder) throws WithdrawException {
		
		//accountHolder = null;
		Customer accountBalance = accountHolder;

		withdrawLogger.info("Withdraw method implemented");
		System.out.println("-------------------------------------");
		System.out.println("Enter amount to withdraw: ");
		
		double withdrawAmount = bankScanner.nextDouble();
		Double i = withdrawAmount;
		//Double j = accountBalance.getBalance();
		Double j = accountBalance.getBalance();

		if (i > j) {
			System.out.println("Unable to process. Account overdrawn.");
			withdrawLogger.debug("User trying to withdraw more than balance");
			withdraw(accountHolder);
			throw new WithdrawException("Insufficient Funds");
		} else if (i <= 0) {
			System.out.println("Invalid input. Please enter a positive number.");
			withdrawLogger.debug("User trying to withdraw with a negative input");
			withdraw(accountHolder);
			throw new WithdrawException("Invalid input");
		}else {
			double balanceAfterWithdraw = j - i;
			System.out.println("Withdrawal Amount Confirmation: " + i);
			System.out.println("NEW BALANCE: " + balanceAfterWithdraw);
			
			accountBalance.setBalance(balanceAfterWithdraw);
			withdrawLogger.warn("Updating data in database", t);
			dbUser.updateAccount(accountBalance);

			//dbUser.updateAccount(accountHolder);
	
		}			

		withdrawLogger.info("New Balance Set After Withdrawal");
		cc.menuOptionsForCustomerInput(accountHolder);

	
	}
	
}
