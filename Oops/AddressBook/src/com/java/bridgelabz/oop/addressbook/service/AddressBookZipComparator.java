package com.java.bridgelabz.oop.addressbook.service;

import java.util.Comparator;

import com.java.bridgelabz.oop.addressbook.model.AddressBook;

public class AddressBookZipComparator implements Comparator<AddressBook>{

	@Override
	public int compare(AddressBook user1, AddressBook user2) {
		return user1.getZip().compareTo(user2.getZip());
	}

}
