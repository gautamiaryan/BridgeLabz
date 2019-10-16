package com.java.bridgelabz.oop.inventory;

import com.java.bridgelabz.oop.inventory.service.InventoryService;
import com.java.bridgelabz.oop.inventory.service.serviceimpl.InventoryServiceImpl;

public class Main {
	public static void main(String[] args) {
		InventoryService implementation=new InventoryServiceImpl();
		implementation.readJSONFile();
	}
	
}
