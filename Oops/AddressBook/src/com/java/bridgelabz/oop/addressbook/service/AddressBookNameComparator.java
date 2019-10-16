package com.java.bridgelabz.oop.addressbook.service;

import java.util.Comparator;

import com.java.bridgelabz.oop.addressbook.model.AddressBook;

public class AddressBookNameComparator  implements Comparator<AddressBook>{

	@Override
	public int compare(AddressBook user1, AddressBook user2) {
		if(user1.getFirstName().compareTo(user2.getFirstName())!=0){
		    return user1.getFirstName().compareTo(user2.getFirstName());
		}
		return user1.getLastName().compareTo(user2.getLastName());
	}

}
