package com.bridgelabz.commercialData.main;

import com.bridgelabz.commercialData.service.StockAccountInterface;
import com.bridgelabz.commercialData.service.Implementation.StockAccountInterfaceImpl;
import com.bridgelabz.utilityoops.Utility;

public class StockAccountMain {

	public static void main(String[] args) {
		StockAccountInterface stockAccService=new StockAccountInterfaceImpl();
		int choice;
		do {
			System.out.println("1: Total shares of each account\n2: buy shares\n"
					+ "3: sell shares\n4:exit");
			choice = Utility.getInt();
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