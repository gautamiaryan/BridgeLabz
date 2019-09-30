package com.bridgelabz.Program.Algorithm;
import com.bridgelabz.Program.Utility.*;
import java.util.*;
public class InsertionSort {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the String");
		String wordString=scanner.nextLine();
		String [] wordList=wordString.split(" ");
		Utility.insertionSortForString(wordList);
		for(int i=0;i<wordList.length;i++) {
			System.out.print(wordList[i]+" ");
		}
	}

}
