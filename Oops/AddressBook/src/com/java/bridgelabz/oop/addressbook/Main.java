package com.java.bridgelabz.oop.addressbook;

import com.java.bridgelabz.oop.addressbook.service.AddressBookService;
import com.java.bridgelabz.oop.addressbook.service.serviceimpl.AddressBookServiceImpl;
import com.java.bridgelabz.oop.addressbook.util.InputScanner;

public class Main {

	public static void main(String[] args)  {
		AddressBookService addressBookService=new AddressBookServiceImpl();
		int choice;
		do {

			System.out.println("1:add User \n2:edit User\n3:delete \n4:sort by Last Name, \n"
					+ "5:sort by zip\n6.exit");
			System.out.println("enter your choice : ");
		    choice = InputScanner.getInt();

			switch (choice) {
			case 1:
				addressBookService.addNewUser();
				break;
			case 2:
				addressBookService.editUser();
				break;
			case 3:
				addressBookService.deleteUser();
				break;
			case 4:
				addressBookService.sortByName();
				break;
			case 5:
				addressBookService.sortByZip();
				break;
			case 6:
				break;
			default:
				System.out.println("Please Enter Valid Choice");
				break;
			}
		}
		while(choice!=6);

	}
}





