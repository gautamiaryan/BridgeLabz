package com.bridgelabz.Program.Algorithm;
import com.bridgelabz.Program.Utility.*;
import java.io.*;
import java.util.*;

public class BinarySearch {
	static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		
		File fileReader=new File("/home/gautam/wordList.txt");
		Scanner scan = new Scanner(fileReader);
		String wordString="";
		while(scan.hasNext()) {
			wordString+=scan.nextLine()+" ";
		}
		String [] wordList=wordString.split(" ");
		String [] word_List=Utility.bubbleSortForString(wordList);
		System.out.println("Enter the word you wanna Search!!");
		String wordToSearch=scanner.nextLine();
		int index=Utility.binarySearchForString(word_List, wordToSearch);
		if(index==-1) {
			System.out.println("Word Not Found");
		}
		else {
			System.out.println("Word found at index "+index);
		}
			
		
		
		
		
		
	}

}
