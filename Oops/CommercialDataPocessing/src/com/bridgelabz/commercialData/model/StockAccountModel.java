package com.bridgelabz.commercialData.model;

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
	
	
	public void setExistingSubQty(int qty, int prc, int flag) {
		for (int i = 0; i < this.quantity.size(); i++) {
			if (quantity.get(i).getPrice() == prc) {
				int existqty = quantity.get(i).getQuantity();
				if (qty + existqty < 0) {
					System.out.println("Quantity exceeded ,currently unavailable in stock : " + existqty);
					return;
				}
				quantity.get(i).setQuantity(qty + existqty);
				quantity.get(i).setDateTime("" + LocalDateTime.now());
				return;
			}
		}
		if (flag == 1) {
			String time = "" + LocalDateTime.now();
			setNewShareForExistSHolder(qty, prc, time);
		} else {
			System.out.println("Sorry! share not available in that range! ");
		}
	}

	public void setQuantity(int quantity) {
		StockAccSubModel submodel = new StockAccSubModel();
		submodel.setQuantity(quantity);
		this.quantity.add(submodel);
	}

	public void setNewShareForExistSHolder(int quantity, int price, String dt) {
		StockAccSubModel submodel = new StockAccSubModel();
		submodel.setQuantity(quantity);
		submodel.setPrice(price);
		submodel.setDateTime(dt);
		this.quantity.add(submodel);
	}
	
	
}
