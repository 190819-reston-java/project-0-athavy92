package com.revature.model;


public class Customer {
	
	//Instances
	private int id;
	private String firstName;
	private String userName;
	private String userPass;
	private int pinNumber;
	private double balance; 

	public Customer(int id, String firstname, String username, String userPass, int pinNumber, double balance) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.userName = username;
		this.userPass = userPass;
		this.pinNumber = pinNumber;
		this.balance = balance;
	}
	
	public Customer() {
	}

	public Customer(int i, String string, String string2, int j, int k) {
		// TODO Auto-generated constructor stub
	}

	public Customer(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String user_pass) {
		this.userPass = user_pass;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Customer [AccoundID: " + id + ", First Name: " + firstName + ", Username: " + userName
				+ ", User Password: " + userPass + ", PIN: " + pinNumber + ", Balance = " + balance + "]";
	}

}
