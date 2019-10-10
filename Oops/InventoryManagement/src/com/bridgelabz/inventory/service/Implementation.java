package com.bridgelabz.inventory.service;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Implementation {
	
	public void readFile() {
		
		JSONParser parser=new JSONParser();
		try {
			FileReader fileReader=new FileReader("/home/gautam/Documents/inventoryDetails.json");
			JSONArray inventoryDetails=(JSONArray) parser.parse(fileReader);
			for(Object object1:inventoryDetails) {
				double totalWeight=0.0;
				double totalPrice=0.0;
				JSONObject details1=(JSONObject) object1;
				String inventory=(String) details1.get("inventory");
				System.out.println(inventory);
				JSONArray listOfInventories=(JSONArray) details1.get("listofinventories");
				System.out.println(listOfInventories);
				for(Object object2:listOfInventories) {
					JSONObject details2=(JSONObject) object2;
					double weight=(double) details2.get("weight");
					double price=(double) details2.get("price");
					totalWeight+=weight;
					totalPrice+=(weight*price);
				}
				System.out.println("Total Weight of " + inventory + ": " + totalWeight + "Kg");
				System.out.println("Total Price of " + inventory + ": Rs." + totalPrice);
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
