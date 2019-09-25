package com.bridgeLabz.DataStructure;

import java.util.*;
import java.io.*;
public class HashingFuction {
	public static void main(String[] args) throws Exception {
		int totalSlot=11;
		ArrayList<Integer> [] list=new ArrayList[totalSlot];
		for(int j=0;j<totalSlot;j++) {
			list[j]=new ArrayList();
		}
		File fileReader=new File("/home/gautam/output.txt");

		Scanner scanner=new Scanner(fileReader);
		String string ="";
		while(scanner.hasNext()) {
			string+=scanner.nextLine();
		}
		String [] listNumber=string.split(",");
		for(int i=0;i<listNumber.length;i++) {
			String num=listNumber[i];
			int number=Integer.parseInt(num);
			int mod=(number%totalSlot);
			
				switch(mod){
				case 0:{
					list[mod].add(number);
					break;
				}
				case 1:{
					list[mod].add(number);
					break;
				}

				case 2:{
					list[mod].add(number);
					break;
				}

				case 3:{
					list[mod].add(number);
					break;
				}

				case 4:{
					list[mod].add(number);
					break;
				}

				case 5:{
					list[mod].add(number);
					break;
				}

				case 6:{
					list[mod].add(number);
					break;
				}

				case 7:{
					list[mod].add(number);
					break;
				}
				case 8:{
					list[mod].add(number);
					break;
				}

				case 9:{
					list[mod].add(number);
					break;
				}
				case 10:{
					list[mod].add(number);
					break;
				}
				default:
					break;

				}
			}
	    for(int i=0;i<list.length;i++) {
	    	
	    	for(int j=0;j<list[i].size();j++) {
	    		System.out.print(list[i].get(j)+" ");
	    	}
	    	System.out.println("");
	    	
	    }
	}
}
