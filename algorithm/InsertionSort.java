package com.bridgelab.algorithm;

import java.util.Scanner;

public class InsertionSort {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the Number of word");
		int wordNumber=scanner.nextInt();
		String [] word= new String[wordNumber];
		for(int i=0;i<wordNumber;i++) {
			word[i]=scanner.nextLine();
		}
		Utility.insertionSortForString(word);
	}

}
