package com.revature;

import com.revature.controller.MainMenu;
import com.revature.repository.BankAppConnectionUtil;

import org.apache.log4j.Logger;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */

public class Main {
	private static Logger bankMainLog = Logger.getLogger(Main.class);
	public static void main(String[] args) {
	
	BankAppConnectionUtil.getConnection();
	
	bankMainLog.info("Program Started");
	
	
	System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	System.out.println("Z                                                                Z");
	System.out.println("Z                                                                Z");
	System.out.println("Z                       BUZZ CITY BANK                           Z");
	System.out.println("Z                                                                Z");
	System.out.println("Z                                                                Z");
	System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	System.out.println("\n");
	
	MainMenu.selectUser();
		 
	}

		
}
	
