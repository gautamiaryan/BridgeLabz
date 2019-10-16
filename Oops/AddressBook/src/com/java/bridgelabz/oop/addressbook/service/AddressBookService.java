package com.java.bridgelabz.oop.addressbook.service;

import org.json.simple.JSONObject;

public interface AddressBookService {
	
	void setFullAddress(JSONObject obj);

	void addNewUser();

	void editUser();

	void deleteUser();

	void sortByName();

	void sortByZip();

}
