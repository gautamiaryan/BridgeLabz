package com.java.bridgelabz.oop.stockreport.service.serviceimpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.java.bridgelabz.oop.stockreport.model.StockDetails;
import com.java.bridgelabz.oop.stockreport.service.StockService;

public class StockServiceImpl implements StockService {
	

	StockDetails[] stockDetails = {};
	@Override
	public StockDetails[] readJSONFile(String fileName) {
		JSONParser jParser = new JSONParser();

		try (FileReader fileReader = new FileReader(fileName)){
			JSONArray stocks = (JSONArray) jParser.parse(fileReader);
			int length = stocks.size();
			stockDetails = new StockDetails[length];
			int i = 0;
			for (Object obj : stocks) {
				JSONObject stockObj = (JSONObject) obj;
				String stockName = (String) stockObj.get("stockname");
				Number numberOfShare = (Number) stockObj.get("numberofshares");
				double pricePerShare = (double) stockObj.get("pricepershare");
				stockDetails[i] = new StockDetails();
				stockDetails[i].setStockname(stockName);
				stockDetails[i].setNumberOfShares(numberOfShare.intValue());
				stockDetails[i].setPricePerShare(pricePerShare);
				i++;
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
		return stockDetails;
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
