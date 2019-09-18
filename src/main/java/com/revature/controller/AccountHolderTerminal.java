package com.revature.controller;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.service.DepositToAccount;
import com.revature.service.WithdrawFromAccount;
import com.revature.Main;
import com.revature.model.Customer;

public class AccountHolderTerminal extends CustomerLogin {

	private static Logger customerAccountLogger = Logger.getLogger(AccountHolderTerminal.class);

	Throwable t;
	protected DecimalFormat df = new DecimalFormat("#.00");

	// MENU OPTIONS FOR USER
	public void menuOptionsForCustomerInput(Customer accountHolder) {

		customerAccountLogger.info("PIN verified. Retrieving account data from DB.");

		System.out.println("Welcome " + accountHolder.getFirstname().toUpperCase());
		System.out.println("\n");
		System.out.println("Please choose an option:");
		System.out.println("1 - View Balance");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Exit");

		String customerInput = bankScanner.next();

		WithdrawFromAccount userWithdraw = new WithdrawFromAccount();
		DepositToAccount userDeposit = new DepositToAccount();

		switch (customerInput) {
		case "1":
			customerAccountLogger.info("Retrieving balance from database");
			System.out.println("ACCOUNT BALANCE: $" + df.format(accountHolder.getBalance()));
			System.out.println("------------------------");
			System.out.println("\n");
			menuOptionsForCustomerInput(accountHolder);
			break;
		case "2":
			customerAccountLogger.info("Withdraw method initiated.");
			userWithdraw.withdraw(accountHolder);
			System.out.println("------------------------");
			break;
		case "3":
			customerAccountLogger.info("Deposit method initiated.");
			userDeposit.deposit(accountHolder);
			System.out.println("------------------------");
			break;
		case "4":
			System.out.println("Exiting");
			System.out.println("------------------------");
			logoutVerify(accountHolder);
			break;
		default:
			System.out.println("Input Not Recognized.");
			System.out.println("------------------------");
			menuOptionsForCustomerInput(accountHolder);
		}

	}

	// LOGOUT METHOD
	private void logoutVerify(Customer accountHolder) {

		System.out.println("Enter PIN to logout or Press '1' to return: ");
		int pinInput = bankScanner.nextInt();

		customerAccountLogger.warn("Input should be an integer.");
		try {
			if (pinInput == accountHolder.getPinNumber()) {
				System.out.println("Logging off");
				System.out.println("------------------------");
				customerAccountLogger.info("Returning to main");
				Main.main(null);

			} else if (pinInput == 1) {
				menuOptionsForCustomerInput(accountHolder);
			} else {
				System.out.println("Input Not Recognized");
				System.out.println("------------------------");
				logoutVerify(accountHolder);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please try again.");
			customerAccountLogger.debug("Invalid input type.", e);
			bankScanner.next();
			
		}

	}

}
