package com.java.bridgelabz.oop.commercialData;

import com.java.bridgelabz.oop.commercialData.service.StockAccountService;
import com.java.bridgelabz.oop.commercialData.service.serviceimpl.StockAccountServiceImpl;
import com.java.bridgelabz.oop.commercialData.util.InputScanner;

public class Main {

	public static void main(String[] args) {
		StockAccountService stockAccService=new StockAccountServiceImpl();
		int choice;
		do {
			System.out.println("1: Total shares of each account\n2: buy shares\n"
					+ "3: sell shares\n4:exit");
			choice = InputScanner.getInt();
			switch (choice) {
			case 1:{
				stockAccService.valueOf();
				break;
			}
			case 2:{
				stockAccService.buy();
				break;
			}
			case 3:{
				stockAccService.sell();
				break;
			}
			case 4:{
				break;
			}
			default:{
				System.out.println("Please Enter a valid input");
				break;
			}

			}
		}
		while(choice!=4);
		
	}
}