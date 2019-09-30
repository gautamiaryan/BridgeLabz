package com.bridgelabz.Program.Algorithm;
import java.util.*;
public class Vending_Machine {
	static int [] Notes_Value= {1000,500,200,100,50,10,5,2,1};
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the amount of Money!!:--->");
		int money=scanner.nextInt();
		int totalNotes=minimumNumberOfNotes(money);
		System.out.println("Total number of notes is:-->"+totalNotes);
	}

	static int minimumNumberOfNotes(int money) {
		int totalNotes=0;
		for(int i=0;i<Notes_Value.length;i++) {
			int noteValue=Notes_Value[i];
			int numberOfEachNote=(money/noteValue);
			System.out.println("Total number of notes of "+noteValue+" is:-->"+numberOfEachNote);
			totalNotes+=numberOfEachNote;
			money=money%noteValue;
		}
		return totalNotes;
	}


}
