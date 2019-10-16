package com.java.bridgelabz.oop.stockreport;

import com.java.bridgelabz.oop.stockreport.model.StockDetails;
import com.java.bridgelabz.oop.stockreport.service.StockService;
import com.java.bridgelabz.oop.stockreport.service.serviceimpl.StockServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		StockService stock = new StockServiceImpl();
		StockDetails[] stockDetails = stock.readJSONFile("/home/gautam/Desktop/BRIDGELABZ/StockReport/src/com/java/bridgelabz/oop/stockreport/repo/stockdetails.json");
		stock.calculateStockValue(stockDetails);
	}

}
