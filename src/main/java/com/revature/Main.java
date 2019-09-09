package com.revature;

import com.revature.controller.MainMenu;
import org.apache.log4j.Logger;


/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */

public class Main {
	
	final static Logger bankMainAppLog = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
	
	bankMainAppLog.info("Program Started");
	
	//MainMenu.WelcomeMessage();
	MainMenu.selectUser();
	
	}

		
}
	
