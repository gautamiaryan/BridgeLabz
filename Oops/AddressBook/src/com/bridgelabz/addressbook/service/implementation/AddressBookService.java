package com.bridgelabz.addressbook.service.implementation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookNameComparator;
import com.bridgelabz.addressbook.service.AddressBookZipComparator;
import com.bridgelabz.addressbook.service.Book;
import com.bridgelabz.utilityoops.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddressBookService implements Book{
	
	private TreeSet<AddressBook> sortedUsers;
	private ArrayList<AddressBook> list=new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public AddressBookService() throws IOException, ParseException  {
		JSONParser jParser=new JSONParser();
		
		FileReader fileReader=new FileReader("/home/gautam/Documents/addressbook.json");
			Object object=jParser.parse(fileReader);
			JSONArray users=(JSONArray) object;
			users.forEach(userObj -> setFullAddress((JSONObject) userObj));	
		
	}

	@Override
	public void setFullAddress(JSONObject userObject) {
		AddressBook user=new AddressBook();
		user.setFirstName((String)userObject.get("firstName"));
		user.setLastName((String)userObject.get("lastName"));
		user.setHouseNum((String) userObject.get("houseNum"));
		user.setStreet((String) userObject.get("street"));
		user.setCity((String) userObject.get("city"));
		user.setState((String) userObject.get("state"));
		user.setZip((Long) userObject.get("zip"));
		user.setPhoneNo((Long) userObject.get("phoneNo"));
		list.add(user);
		
	}

	@Override
	public void addNewUser() {
		AddressBook newUser=UserService.getInputForNewUser();
		list.add(newUser);
		writeIntoFile();
		display(list);
		
	}

	@Override
	public void editUser() {
		AddressBook editUser=UserService.getInputForEditUser();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFirstName().equalsIgnoreCase(editUser.getFirstName())
					&& list.get(i).getLastName().equalsIgnoreCase(editUser.getLastName())) {
				AddressBook model = list.get(i);
				if (editUser.getHouseNum() != null) {
					model.setHouseNum(editUser.getHouseNum());
				}
				if (editUser.getStreet() != null) {
					model.setStreet(editUser.getStreet());
				}
				if (editUser.getCity() != null) {
					model.setCity(editUser.getCity());
				}
				if (editUser.getState() != null) {
					model.setState(editUser.getState());
				}
				if (editUser.getZip()!= 0) {
					model.setZip(editUser.getZip());
				}
				if (editUser.getPhoneNo() != 0) {
					model.setPhoneNo(editUser.getPhoneNo());
				}
				list.set(i, model);
				writeIntoFile();
				display(list);
			}
		}
		
		
	}

	@Override
	public void deleteUser() {
		System.out.println("Enter the User's first-name and last-name");
		String firstName = Utility.getString();
		String lastName = Utility.getString();
		list.removeIf(user -> user.getFirstName().equalsIgnoreCase(firstName)
						&& user.getLastName().equalsIgnoreCase(lastName));
		writeIntoFile();
		display(list);
		
		
	}

	@Override
	public void sortByName() {
		sortedUsers = new TreeSet<>(new AddressBookNameComparator());
		sortedUsers.addAll(list);
		display(sortedUsers);
		
	}

	@Override
	public void sortByZip() {
		sortedUsers = new TreeSet<>(new AddressBookZipComparator());
		sortedUsers.addAll(list);
		display(sortedUsers);
		
	}
	
	

	private void display(Collection<AddressBook> list1) {
		
		for (AddressBook model : list1) {
			System.out.println(model.getFirstName());
			System.out.println(model.getLastName());
			System.out.println(model.getHouseNum());
			System.out.println(model.getStreet());
			System.out.println(model.getCity());
			System.out.println(model.getState());
			System.out.println(model.getZip());
			System.out.println(model.getPhoneNo());
			System.out.println();
		}
		
		
	}
	
	public void writeIntoFile() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(
				"/home/gautam/Documents/output.json")) {
			writer.write(gson.toJson(list));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
