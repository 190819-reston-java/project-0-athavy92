package com.revature.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.controller.AccountHolderTerminal;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;
import com.revature.repository.BankDaoImplementations;
import com.revature.repository.BankDao;

public class WithdrawFromAccount extends AccountHolderTerminal {
	private static Logger withdrawLogger = Logger.getLogger(WithdrawFromAccount.class);
	AccountHolderTerminal cc = new AccountHolderTerminal();
	BankDao dbUser = new BankDaoImplementations();
	Throwable t;

	public void withdraw(Customer accountHolder) throws WithdrawException {

		// accountHolder = null;
		Customer accountBalance = accountHolder;

		withdrawLogger.info("Withdraw method implemented");
		System.out.println("-------------------------------------");
		System.out.println("Enter amount to withdraw: ");

		try {
			double withdrawAmount = bankScanner.nextDouble();
			double i = Math.abs(withdrawAmount);
			double j = accountBalance.getBalance();
			if (i > j) {
				System.out.println("Unable to process. Account overdrawn.");
				withdrawLogger.warn("User trying to withdraw more than balance");
				withdraw(accountHolder);
				throw new WithdrawException("Insufficient Funds");
			} else {
				double balanceAfterWithdraw = j - i;
				System.out.println("Withdrawal Amount Confirmation: " + df.format(i));
				System.out.println("NEW BALANCE: $" + df.format(balanceAfterWithdraw));

				accountBalance.setBalance(balanceAfterWithdraw);
				withdrawLogger.debug("Updating data in database", t);
				dbUser.updateAccount(accountBalance);
			}
		} catch (InputMismatchException e) {
			withdrawLogger.debug("Invalid input type.", e);
			System.out.println("You entered a non-numeric value. Please try again.");
			bankScanner.next();
			System.out.println("\n");
		}

		withdrawLogger.info("New Balance Set After Withdrawal");
		cc.menuOptionsForCustomerInput(accountHolder);

	}

}
