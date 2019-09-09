package com.revature.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionDriver {

	public static void main(String[] args) {
		
		accountCollection();
		
	
	}

	private static void accountCollection() {
		
		List<CheckingAccount> checkingAccountList = new ArrayList<CheckingAccount>();
		
		Map<String, CheckingAccount> checkingAcctMap = new HashMap<String, CheckingAccount>();
		for (CheckingAccount c : checkingAccountList) {
			checkingAcctMap.put(c.getUsername(), c);
		}
		
		System.out.println(checkingAcctMap);
	}

} 
