package com.revature.model;


public class Customer {
	
	//Instances
	private String accountNumber;
	private String firstName;
	private String username = "alecthavy";
	private String password = "jumpman23";
	private int pin = 8989;
	private float balance = 5000; 
	
	public Customer(String firstName, String username, String password) {
		super();
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}
	
	public Customer() {
		
	};

	
	//Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
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
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", username=" + username + ", password=" + password + "]";
	}

	

}
