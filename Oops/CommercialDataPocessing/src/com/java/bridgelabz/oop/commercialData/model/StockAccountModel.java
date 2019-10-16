package com.java.bridgelabz.oop.commercialData.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StockAccountModel {
	
	private String stockName;
	private ArrayList<StockAccSubModel> quantity = new ArrayList<>();
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public ArrayList<StockAccSubModel> getQuantity() {
		return quantity;
	}
	public void setQuantity(ArrayList<StockAccSubModel> quantity) {
		this.quantity = quantity;
	}
	
	
	public void setExistingSubQuantity(int quantity1, int price1, int flag) {
		for (int i = 0; i < this.quantity.size(); i++) {
			if (quantity.get(i).getPrice() == price1) {
				int existingQuantity = quantity.get(i).getQuantity();
				if (quantity1 + existingQuantity < 0) {
					System.out.println("Quantity exceeded ,currently unavailable in stock : " + existingQuantity);
					return;
				}
				quantity.get(i).setQuantity(quantity1 + existingQuantity);
				quantity.get(i).setDateTime("" + LocalDateTime.now());
				return;
			}
		}
		if (flag == 1) {
			String time = "" + LocalDateTime.now();
			setNewShareForExistingStockHolder(quantity1, price1, time);
		} else {
			System.out.println("Sorry! share not available in that range! ");
		}
	}

	public void setQuantity(int quantity) {
		StockAccSubModel submodel = new StockAccSubModel();
		submodel.setQuantity(quantity);
		this.quantity.add(submodel);
	}

	public void setNewShareForExistingStockHolder(int quantity, int price, String dateTime) {
		StockAccSubModel submodel = new StockAccSubModel();
		submodel.setQuantity(quantity);
		submodel.setPrice(price);
		submodel.setDateTime(dateTime);
		this.quantity.add(submodel);
	}
	
	
}
