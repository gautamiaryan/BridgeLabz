package com.bridgelabz.stockreport.main;

import com.bridgelabz.stockreport.model.StockDetails;
import com.bridgelabz.stockreport.service.StockService;
import com.bridgelabz.stockreport.serviceImplementation.StockServiceImplementation;

public class StockMain {

	public static void main(String[] args) {
		StockService stock = new StockServiceImplementation();
		StockDetails[] array = stock.readJSONFile("/home/gautam/Documents/stockdetails.json");
		stock.calculateStockValue(array);
	}

}
