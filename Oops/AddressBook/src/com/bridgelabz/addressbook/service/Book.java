package com.bridgelabz.addressbook.service;

import org.json.simple.JSONObject;

public interface Book {
	
	void setFullAddress(JSONObject obj);

	void addNewUser();

	void editUser();

	void deleteUser();

	void sortByName();

	void sortByZip();

}
