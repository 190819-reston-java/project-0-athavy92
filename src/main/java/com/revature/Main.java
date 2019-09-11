package com.revature;

import com.revature.controller.MainMenu;
import com.revature.model.Customer;

import org.apache.log4j.Logger;


/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */

public class Main {
	
	static Logger bankMainLog = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
	
	bankMainLog.info("Program Started");
	
	//MainMenu.WelcomeMessage();
	MainMenu.selectUser();
	
	}

		
}
	
