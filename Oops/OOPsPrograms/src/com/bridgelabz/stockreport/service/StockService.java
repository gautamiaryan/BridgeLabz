package com.bridgelabz.stockreport.service;

import com.bridgelabz.stockreport.model.StockDetails;

public interface StockService {
	
	public StockDetails[] readJSONFile(String fileName);

	public void calculateStockValue(StockDetails[] stockDetails);


}
