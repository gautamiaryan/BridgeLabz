package com.bridgelab.algorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class BubbleSort {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the size of List:--->");
		int listSize=scanner.nextInt();
		int [] list=new int[listSize];
		for(int i=0;i<listSize;i++) {
			list[i]=scanner.nextInt();
		}
		Instant start = Instant.now();
		int [] sortedList= Utility.bubbleSortForInteger(list);
		Instant end = Instant.now();
		for(int i=0;i<sortedList.length;i++) {
			System.out.println(sortedList[i]);
		}
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

		
	}

}
