package com.java.bridgelabz.oop.stockreport.service;

import com.java.bridgelabz.oop.stockreport.model.StockDetails;

public interface StockService {
	
	public StockDetails[] readJSONFile(String fileName);

	public void calculateStockValue(StockDetails[] stockDetails);


}
