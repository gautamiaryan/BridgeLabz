package com.bridgelabz.addressbook.service.implementation;

import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.utilityoops.Utility;


public class UserService {
	
	public static AddressBook getInputForNewUser() {
		AddressBook  model=new AddressBook();
		System.out.println("Please Enter your first name");
		model.setFirstName(Utility.getString());
		System.out.println("Please Enter your last name");
		model.setLastName(Utility.getString());
		System.out.println("Please Enter your house number");
		model.setHouseNum(Utility.getString());
		System.out.println("Please Enter your street");
		model.setStreet(Utility.getString());
		System.out.println("Please Enter your city");
		model.setCity(Utility.getString());
		System.out.println("Please Enter your State");
		model.setState(Utility.getString());
		System.out.println("Please Enter your zip code");
		model.setZip(Utility.getLong());
		System.out.println("Please Enter your mobile number");
		model.setPhoneNo(Utility.getLong());
		
		return model;	
	}
	
	public static AddressBook getInputForEditUser() {
		AddressBook addressBookModel=new AddressBook();
		System.out.println("Please Enter your first name");
		addressBookModel.setFirstName(Utility.getString());
		System.out.println("Please Enter your last name");
		addressBookModel.setLastName(Utility.getString());
		System.out.println("Please Enter your choice");
		boolean b = true;
		while (b) {
			System.out.println(
					" 1:change house No.\n 2:change street\n 3:change city\n 4:change state\n 5:change zip\n 6:change phone no. \n7:done");																												// File.
			int choice = Utility.getInt();
			switch (choice) {
			case 1:
				System.out.println("Please Enter house No.");
				addressBookModel.setHouseNum(Utility.getString());
				break;
			case 2:
				System.out.println("Please Enter street : ");
				addressBookModel.setStreet(Utility.getString());
				break;
			case 3:
				System.out.println("Please Enter name : ");
				addressBookModel.setCity(Utility.getString());
				break;
			case 4:
				System.out.println("Please Enter state name : ");
				addressBookModel.setState(Utility.getString());
				break;
			case 5:
				System.out.println("Please Enter Zip code : ");
				addressBookModel.setZip(Utility.getLong());
				break;
			case 6:
				System.out.println("Please Enter Phone Number : ");
				addressBookModel.setPhoneNo(Utility.getLong());
				break;
			case 7:
				return addressBookModel;

			default:
				b = false;
				break;
			}
		}
		return addressBookModel; 
	}

}
