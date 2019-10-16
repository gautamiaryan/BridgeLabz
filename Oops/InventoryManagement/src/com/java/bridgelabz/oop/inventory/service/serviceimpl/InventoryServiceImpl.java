package com.java.bridgelabz.oop.inventory.service.serviceimpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.java.bridgelabz.oop.inventory.service.InventoryService;

public class InventoryServiceImpl implements InventoryService{
    private static final String inventoryJsonPath="/home/gautam/Desktop/BRIDGELABZ/InventoryManagement/src/com/java/bridgelabz/oop/inventory/repo/inventoryDetails.json";
	@Override
	public void readJSONFile() {
		JSONParser parser=new JSONParser();
		try (FileReader fileReader=new FileReader(inventoryJsonPath)){
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
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}


}


