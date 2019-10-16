package com.bridgelabz.stockreport.serviceImplementation;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.stockreport.model.StockDetails;
import com.bridgelabz.stockreport.service.StockService;

public class StockServiceImplementation implements StockService {
	
	StockDetails[] detail = {};
	@Override
	public StockDetails[] readJSONFile(String fileName) {
		JSONParser parser = new JSONParser();

		try {
			FileReader fr = new FileReader(fileName);
			JSONArray stocks = (JSONArray) parser.parse(fr);
			int length = stocks.size();
			detail = new StockDetails[length];
			int i = 0;
			for (Object obj : stocks) {
				JSONObject stock = (JSONObject) obj;
				String stockName = (String) stock.get("stockname");
				Number numberOfShares = (Number) stock.get("numberofshares");
				double pricePerShare = (double) stock.get("pricepershare");
				detail[i] = new StockDetails();
				detail[i].setStockname(stockName);
				detail[i].setNumberOfShares(numberOfShares.intValue());
				detail[i].setPricePerShare(pricePerShare);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return detail;
	}
	@Override
	public void calculateStockValue(StockDetails[] stockDetails) {

		for (int i = 0; i < stockDetails.length; i++) {
			System.out.println("Stock Name: " + stockDetails[i].getStockname());
			double stockPrice = stockDetails[i].getNumberOfShares() * stockDetails[i].getPricePerShare();
			System.out.println("Value of the Stock is: Rs." + stockPrice);
		}
	}

	
	

}
