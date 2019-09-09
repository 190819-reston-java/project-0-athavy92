package com.revature.model;

public class Customer {
	
	//Instances
	private String accountNumber;
	private String accountType;
	private String firstName;
	private String username;
	private String password;
	private int balance; 
	
	
	public Customer(String firstName, String username, String password) {
		super();
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}

	//Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
