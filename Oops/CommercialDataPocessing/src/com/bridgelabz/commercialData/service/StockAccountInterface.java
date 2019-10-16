package com.bridgelabz.commercialData.service;


import org.json.simple.JSONObject;

public interface StockAccountInterface {
	
	void readFile();

	void setIntoList(JSONObject obj);

	void valueOf();

	void buy();

	void sell();

	void save();

	void printReport();
	

}
