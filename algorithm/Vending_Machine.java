package com.bridgelab.algorithm;

import java.util.Scanner;

public class Vending_Machine {

	static int [] notesValue= {1000,500,200,100,50,10,5,2,1};
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the amount of Money!!:--->");
		int money=scanner.nextInt();
		int totalNotes=minimumNumberOfNotes(money);
		System.out.println("Total number of notes is:-->"+totalNotes);
	}

	static int minimumNumberOfNotes(int money) {
		int totalNotes=0;
		for(int i=0;i<notesValue.length;i++) {
			int noteValue=notesValue[i];
			int numberOfEachNote=(money/noteValue);
			System.out.println("Total number of notes of "+noteValue+" is:-->"+numberOfEachNote);
			totalNotes+=numberOfEachNote;
			money=money%noteValue;
		}
		return totalNotes;
	}

}
