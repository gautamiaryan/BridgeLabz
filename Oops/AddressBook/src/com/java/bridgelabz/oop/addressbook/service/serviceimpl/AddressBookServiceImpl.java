package com.java.bridgelabz.oop.addressbook.service.serviceimpl;

import java.io.FileNotFoundException;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.bridgelabz.oop.addressbook.model.AddressBook;
import com.java.bridgelabz.oop.addressbook.service.AddressBookNameComparator;
import com.java.bridgelabz.oop.addressbook.service.AddressBookZipComparator;
import com.java.bridgelabz.oop.addressbook.util.InputScanner;
import com.java.bridgelabz.oop.addressbook.service.AddressBookService;

public class AddressBookServiceImpl implements AddressBookService{
	
	private TreeSet<AddressBook> sortedUsers;
	private ArrayList<AddressBook> list=new ArrayList<>();
	private static final String addressBookJsonPath="/home/gautam/Desktop/BRIDGELABZ/AddressBook/src/com/java/bridgelabz/oop/addressbook/repo/addressbook.json";
	private static final String addressBookOutputJsonPath="/home/gautam/Desktop/BRIDGELABZ/AddressBook/src/com/java/bridgelabz/oop/addressbook/repo/AddressBookOutput.json";
	public AddressBookServiceImpl()   {
		JSONParser jParser=new JSONParser();
		
		try(FileReader fileReader=new FileReader(addressBookJsonPath)) {
			Object object=jParser.parse(fileReader);
			JSONArray users=(JSONArray) object;
			users.forEach(userObj -> setFullAddress((JSONObject) userObj));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
			
	}

	@Override
	public void setFullAddress(JSONObject userObj) {
		AddressBook user=new AddressBook();
		user.setFirstName((String)userObj.get("firstName"));
		user.setLastName((String)userObj.get("lastName"));
		user.setHouseNumber((String) userObj.get("houseNum"));
		user.setStreet((String) userObj.get("street"));
		user.setCity((String) userObj.get("city"));
		user.setState((String) userObj.get("state"));
		user.setZip((long) userObj.get("zip"));
		user.setPhoneNumber((long) userObj.get("phoneNo"));
		list.add(user);
		
	}

	@Override
	public void addNewUser() {
		AddressBook newUser=User.getInputForNewUser();
		list.add(newUser);
		saveIntoFile(list);
		writeIntoFile(list);
		display(list);
		
	}

	@Override
	public void editUser() {
		AddressBook editUser=User.getInputForEditUser();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFirstName().equalsIgnoreCase(editUser.getFirstName())
					&& list.get(i).getLastName().equalsIgnoreCase(editUser.getLastName())) {
				AddressBook model = list.get(i);
				if (editUser.getHouseNumber() != null) {
					model.setHouseNumber(editUser.getHouseNumber());
				
				}
				else if (editUser.getStreet() != null) {
					model.setStreet(editUser.getStreet());
			
				}
				else if (editUser.getCity() != null) {
					model.setCity(editUser.getCity());
					
				}
				else if (editUser.getState() != null) {
					model.setState(editUser.getState());
					
				}
				else if (editUser.getZip()!=null) {
					model.setZip(editUser.getZip());
					
				}
				else if (editUser.getPhoneNumber() !=null) {
					model.setPhoneNumber(editUser.getPhoneNumber());
				}
				list.set(i, model);
				saveIntoFile(list);
				writeIntoFile(list);
				display(list);
			}
		}
	}

	@Override
	public void deleteUser() {
		System.out.println("Enter the User's first-name and last-name");
		String firstName = InputScanner.getString();
		String lastName = InputScanner.getString();
		list.removeIf(user -> user.getFirstName().equalsIgnoreCase(firstName)
						&& user.getLastName().equalsIgnoreCase(lastName));
		saveIntoFile(list);
		writeIntoFile(list);
		display(list);
		
		
	}

	@Override
	public void sortByName() {
		sortedUsers = new TreeSet<>(new AddressBookNameComparator());
		sortedUsers.addAll(list);
		writeIntoFile(sortedUsers);
		display(sortedUsers);
		
	}

	@Override
	public void sortByZip() {
		sortedUsers = new TreeSet<>(new AddressBookZipComparator());
		sortedUsers.addAll(list);
		writeIntoFile(sortedUsers);
		display(sortedUsers);
		
	}
	
	

	private void display(Collection<AddressBook> list1) {
		
		for (AddressBook model : list1) {
			System.out.println(model.getFirstName());
			System.out.println(model.getLastName());
			System.out.println(model.getHouseNumber());
			System.out.println(model.getStreet());
			System.out.println(model.getCity());
			System.out.println(model.getState());
			System.out.println(model.getZip());
			System.out.println(model.getPhoneNumber());
			System.out.println();
		}
		
		
	}
	
	public void writeIntoFile(Collection<AddressBook> list) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(addressBookOutputJsonPath)) {
			writer.write(gson.toJson(list));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveIntoFile(ArrayList<AddressBook> list) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(addressBookJsonPath)) {
			writer.write(gson.toJson(list));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
