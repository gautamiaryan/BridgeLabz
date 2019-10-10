package com.bridgelabz.addressbook.service;

import java.util.Comparator;

import com.bridgelabz.addressbook.model.AddressBook;

public class AddressBookNameComparator  implements Comparator<AddressBook>{

	@Override
	public int compare(AddressBook user1, AddressBook user2) {
		if(user1.getLastName().compareTo(user2.getLastName())!=0){
		    return user1.getLastName().compareTo(user2.getLastName());
		}
		return user1.getFirstName().compareTo(user2.getFirstName());
	}

}
