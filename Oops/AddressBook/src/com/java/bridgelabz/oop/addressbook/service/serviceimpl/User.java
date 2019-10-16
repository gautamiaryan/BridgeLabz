package com.java.bridgelabz.oop.addressbook.service.serviceimpl;

import com.java.bridgelabz.oop.addressbook.model.AddressBook;
import com.java.bridgelabz.oop.addressbook.util.InputScanner;


public class User {
	
	public static AddressBook getInputForNewUser() {
		AddressBook  newUser=new AddressBook();
		System.out.println("Please Enter your first name");
		newUser.setFirstName(InputScanner.getString());
		System.out.println("Please Enter your last name");
		newUser.setLastName(InputScanner.getString());
		System.out.println("Please Enter your house number");
		newUser.setHouseNumber(InputScanner.getString());
		System.out.println("Please Enter your street");
		newUser.setStreet(InputScanner.getString());
		System.out.println("Please Enter your city");
		newUser.setCity(InputScanner.getString());
		System.out.println("Please Enter your State");
		newUser.setState(InputScanner.getString());
		System.out.println("Please Enter your zip code");
		newUser.setZip(InputScanner.getLong());
		System.out.println("Please Enter your mobile number");
		newUser.setPhoneNumber(InputScanner.getLong());
		
		return newUser;	
	}
	
	public static AddressBook getInputForEditUser() {
		AddressBook editUser=new AddressBook();
		System.out.println("Please Enter your first name");
		editUser.setFirstName(InputScanner.getString());
		System.out.println("Please Enter your last name");
		editUser.setLastName(InputScanner.getString());
		System.out.println("Please Enter your choice");
		int choice;
		do {
			System.out.println(" 1:change house No.\n 2:change street\n "
					+ "3:change city\n 4:change state\n 5:change zip\n "
					+ "6:change phone no. \n7:done\n 8.exit");																												// File.
			choice = InputScanner.getInt();
			switch (choice) {
			case 1:{
				System.out.println("Please Enter house No.");
				editUser.setHouseNumber(InputScanner.getString());
				break;
			}
			case 2:{
				System.out.println("Please Enter street : ");
				editUser.setStreet(InputScanner.getString());
				break;
			}
			case 3:{
				System.out.println("Please Enter name : ");
				editUser.setCity(InputScanner.getString());
				break;
			}
			case 4:{
				System.out.println("Please Enter state name : ");
				editUser.setState(InputScanner.getString());
				break;
			}
			case 5:{
				System.out.println("Please Enter Zip code : ");
				editUser.setZip(InputScanner.getLong());
				break;
			}
			case 6:{
				System.out.println("Please Enter Phone Number : ");
				editUser.setPhoneNumber(InputScanner.getLong());
				break;
			}
			case 7:{
				return editUser;
			}
			case 8:{
				break;
			}
			default:{
				System.out.println("Please enter a valid choice");
				break;
			}
			}
		}
		while(choice!=8);
		return editUser;
	}

}
