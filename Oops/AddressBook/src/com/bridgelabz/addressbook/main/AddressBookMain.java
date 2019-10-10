package com.bridgelabz.addressbook.main;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.service.Book;
import com.bridgelabz.addressbook.service.implementation.AddressBookService;
import com.bridgelabz.utilityoops.Utility;


public class AddressBookMain {

	public static void main(String[] args) throws IOException, ParseException {
		Book addressBookService=new AddressBookService();
		boolean flag=true;
		while(flag) {

			System.out.println("1:add User \n2:edit User\n3:delete \n4:sort by Last Name, \n5:sort by zip");
			System.out.println("enter your choice : ");
			int choice = Utility.getInt();

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
			default:
				flag = false;
			}
		}

	}
}





