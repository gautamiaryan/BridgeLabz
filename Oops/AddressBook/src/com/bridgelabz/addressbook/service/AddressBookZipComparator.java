package com.bridgelabz.addressbook.service;

import java.util.Comparator;

import com.bridgelabz.addressbook.model.AddressBook;

public class AddressBookZipComparator implements Comparator<AddressBook>{

	@Override
	public int compare(AddressBook user1, AddressBook user2) {
		return user1.getZip().compareTo(user2.getZip());
	}

}
