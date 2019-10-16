package com.bridgelabz.commercialData.service.Implementation;

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

import com.bridgelabz.commercialData.model.StockAccSubModel;
import com.bridgelabz.commercialData.model.StockAccountModel;
import com.bridgelabz.commercialData.service.StockAccountInterface;
import com.bridgelabz.utilityoops.Node;
import com.bridgelabz.utilityoops.UnOrderedList;
import com.bridgelabz.utilityoops.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class StockAccountInterfaceImpl implements StockAccountInterface {

	UnOrderedList<StockAccountModel> list = new UnOrderedList<StockAccountModel>();
	List<StockAccountModel> list1 = new LinkedList<StockAccountModel>();
	static JSONParser jparser = new JSONParser();

	@SuppressWarnings("unchecked")
	@Override
	public void readFile()  {
		try(FileReader reader=new FileReader("/home/gautam/Documents/Stockshare.json")){
			Object object=jparser.parse(reader);
			JSONArray stocks=(JSONArray) object;
			stocks.forEach(stock -> setIntoList((JSONObject) stock));
			printReport();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		
	}

	@Override
	public void setIntoList(JSONObject obj) {
		StockAccountModel model=new StockAccountModel();
		model.setStockName( (String) obj.get("stockName"));
		JSONArray jarr=(JSONArray) obj.get("quantity");
		for(Object obj1:jarr) {
			JSONObject jobj=(JSONObject) obj1;
			int qty = (int) (long)jobj.get("quantity");
			int prc =  (int) (long)jobj.get("price");
			String datetime = (String) jobj.get("datetime");
			model.setNewShareForExistSHolder(qty, prc, datetime);
			
		}
		list.add(model);
		
	}

	@Override
	public void valueOf() {
		readFile();
		Node<StockAccountModel> startNode=list.getHead();
		while(startNode!=null) {
			ArrayList<StockAccSubModel> qty=startNode.getData().getQuantity();
			double result = 0;
			double totalResult = 0;
			for(StockAccSubModel subModel:qty) {
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
		String symbol=Utility.getString();
		System.out.println("enter quantity");
		int quantity=Utility.getInt();
		System.out.println("enter price");
		int price=Utility.getInt();
		if (quantity == 0 || price == 0) {
			System.out.println("this amount is invalid");
			return;
		}
		Node<StockAccountModel> startNode=list.getHead();
		while(startNode!=null) {
			if(startNode.getData().getStockName().equalsIgnoreCase(symbol)) {
				startNode.getData().setExistingSubQty(quantity, price, 1);
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
		String symbol=Utility.getString();
		System.out.println("enter quantity");
		int quantity=Utility.getInt();
		System.out.println("enter price");
		int price=Utility.getInt();
		if (quantity == 0 || price == 0) {
			System.out.println("this amount is invalid");
			return;
		}
		Node<StockAccountModel> startNode=list.getHead();
		while(startNode!=null) {
			if(startNode.getData().getStockName().equalsIgnoreCase(symbol)) {
				startNode.getData().setExistingSubQty(quantity, price, 1);
				break;
			}
			startNode=startNode.getLink();
		}
		save();
		printReport();
		
	}

	@Override
	public void save() {
		Node<StockAccountModel> startNode=list.getHead();
		list1.clear();
		while(startNode!=null) {
			list1.add(startNode.getData());
			startNode=startNode.getLink();
		}
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		try(FileWriter  writer=new FileWriter("/home/gautam/Documents/out.json")){
			
			writer.write(gson.toJson(list1));
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void printReport() {
		Node<StockAccountModel> startNode = list.getHead();
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





