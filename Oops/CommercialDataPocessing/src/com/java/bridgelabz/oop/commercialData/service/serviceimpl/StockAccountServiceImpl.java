package com.java.bridgelabz.oop.commercialData.service.serviceimpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utilityoops.Node;
import com.bridgelabz.utilityoops.UnOrderedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.bridgelabz.oop.commercialData.model.StockAccSubModel;
import com.java.bridgelabz.oop.commercialData.model.StockAccountModel;
import com.java.bridgelabz.oop.commercialData.service.StockAccountService;
import com.java.bridgelabz.oop.commercialData.util.InputScanner;


public class StockAccountServiceImpl implements StockAccountService {

	UnOrderedList<StockAccountModel> stockList = new UnOrderedList<StockAccountModel>();
	List<StockAccountModel> list = new LinkedList<StockAccountModel>();
	private static final String stockShareJsonPath="/home/gautam/Desktop/BRIDGELABZ/CommercialDataPocessing/src/com/java/bridgelabz/oop/commercialData/repo/Stockshare.json";
	private static final String stockShareOutputJsonPath="/home/gautam/Desktop/BRIDGELABZ/CommercialDataPocessing/src/com/java/bridgelabz/oop/commercialData/repo/StockshareOutput.json";
	static JSONParser jParser = new JSONParser();
	
	public void readFile()  {
		try(FileReader fileReader=new FileReader(stockShareJsonPath)){
			Object object=jParser.parse(fileReader);
			JSONArray stocks=(JSONArray) object;
			stocks.forEach(stock -> setIntoList( (JSONObject) stock));
			printReport();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		} 

	}

	@Override
	public void setIntoList(JSONObject object) {
		StockAccountModel stockModel=new StockAccountModel();
		stockModel.setStockName( (String) object.get("stockName"));
		JSONArray stockQuantity=(JSONArray) object.get("quantity");
		for(Object obj:stockQuantity) {
			JSONObject jsonObject=(JSONObject) obj;
			int quantity = (int) (long)jsonObject.get("quantity");
			int price =  (int) (long)jsonObject.get("price");
			String dateTime = (String) jsonObject.get("datetime");
			stockModel.setNewShareForExistingStockHolder(quantity, price, dateTime);

		}
		stockList.add(stockModel);

	}

	@Override
	public void valueOf() {
		readFile();
		Node<StockAccountModel> startNode=stockList.getHead();
		while(startNode!=null) {
			ArrayList<StockAccSubModel> quantity=startNode.getData().getQuantity();
			double result = 0;
			double totalResult = 0;
			for(StockAccSubModel subModel:quantity) {
				result=subModel.getQuantity()*subModel.getPrice();
				System.out.println("share of account " + startNode.getData().getStockName() + " : " + result);
				totalResult += result;
			}
			System.out.println("Total share of account " + startNode.getData().getStockName() + " : " + totalResult);
			System.out.println();
			startNode=startNode.getLink();
		}


	}

	@Override
	public void buy() {
		System.out.println("enter the share name");
		String symbol=InputScanner.getString();
		System.out.println("enter quantity");
		int quantity=InputScanner.getInt();
		System.out.println("enter price");
		int price=InputScanner.getInt();
		if (quantity == 0 || price == 0) {
			System.out.println("this amount is invalid");
			return;
		}
		Node<StockAccountModel> startNode=stockList.getHead();
		while(startNode!=null) {
			if(startNode.getData().getStockName().equalsIgnoreCase(symbol)) {
				startNode.getData().setExistingSubQuantity(quantity, price, 1);
				break;
			}
			startNode=startNode.getLink();
		}
		save();
		printReport();
	}

	@Override
	public void sell() {
		System.out.println("enter the share name");
		String symbol=InputScanner.getString();
		System.out.println("enter quantity");
		int quantity=InputScanner.getInt();
		System.out.println("enter price");
		int price=InputScanner.getInt();
		if (quantity == 0 || price == 0) {
			System.out.println("this amount is invalid");
			return;
		}
		Node<StockAccountModel> startNode=stockList.getHead();
		while(startNode!=null) {
			if(startNode.getData().getStockName().equalsIgnoreCase(symbol)) {
				startNode.getData().setExistingSubQuantity(quantity, price, 1);
				break;
			}
			startNode=startNode.getLink();
		}
		save();
		printReport();

	}

	@Override
	public void save() {
		Node<StockAccountModel> startNode=stockList.getHead();
		list.clear();
		while(startNode!=null) {
			list.add(startNode.getData());
			startNode=startNode.getLink();
		}

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		try(FileWriter  fileWriter=new FileWriter(stockShareOutputJsonPath)){

			fileWriter.write(gson.toJson(list));
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printReport() {
		Node<StockAccountModel> startNode = stockList.getHead();
		while(startNode!=null) {
			StockAccountModel stockmodel = startNode.getData();
			ArrayList<StockAccSubModel> sublist = stockmodel.getQuantity();
			for (StockAccSubModel subModel : sublist) {
				System.out.println(stockmodel.getStockName());
				System.out.println(subModel.getQuantity());
				System.out.println(subModel.getPrice());
				System.out.println(subModel.getDateTime());
				System.out.println();
			}

			startNode=startNode.getLink();
		}
	}

}





