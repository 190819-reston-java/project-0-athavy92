package com.revature.service;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.CustomerController;
import com.revature.exception.DepositException;
import com.revature.exception.WithdrawException;
import com.revature.model.Customer;
import com.revature.repository.BankData;

import com.revature.repository.BankDAOMethods;

public class DepositToAccount extends CustomerController {
	
	CustomerController cc = new CustomerController();
	BankData dbUser = new BankDAOMethods();
	
	private static Logger depositLogger = Logger.getLogger(DepositToAccount.class);
	private DecimalFormat currencyFormat = new DecimalFormat("#.00");

	public void deposit(Customer accountHolder) throws DepositException {
				
		System.out.println("Enter amount to deposit: ");
	
		
		Customer accountBalance = accountHolder;

		depositLogger.info("Withdraw method implemented");
		System.out.println("-------------------------------------");
		System.out.println("Enter amount to withdraw: ");
		
		double depositAmount = bankScanner.nextDouble();
		Double i = depositAmount;
		Double j = accountBalance.getBalance();

		if (i > 5000) {
			System.out.println("Deposit too large. Plese enter a different amount or visit a branch.");
			depositLogger.debug("User trying to deposit a large amount");
			deposit(accountHolder);
			throw new WithdrawException("Insufficient Funds");
		} else if (i <= 0) {
			System.out.println("Invalid input. Please enter a positive number.");
			depositLogger.debug("User trying to deposit with a negative input");
			deposit(accountHolder);
			throw new WithdrawException("Invalid input");
		}else {
			double balanceAfterDeposit = j + i;
			System.out.println("Deposit Amount Confirmation: " + i);
			System.out.println("NEW BALANCE: " + balanceAfterDeposit);
			
			accountHolder.setBalance(balanceAfterDeposit);
		}			
			
		dbUser.updateAccount(accountHolder);

		depositLogger.info("New Balance Set After Withdrawal");
		cc.menuOptionsForCustomerInput(accountHolder);

	
	}

}
