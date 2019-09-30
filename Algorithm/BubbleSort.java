package com.bridgelabz.Program.Algorithm;
import com.bridgelabz.Program.Utility.*;
import java.io.*;
import java.util.*;
public class BubbleSort {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		File fileReader=new File("/home/gautam/unsortedNumber.txt");
		Scanner scan=new Scanner(fileReader);
		String numberString="";
		while(scan.hasNext()) {
			numberString+=scan.nextLine();
		}
		String [] stringList=numberString.split(",");
		int [] numberList=new int[stringList.length];
		for(int i=0;i<stringList.length;i++) {
			numberList[i]=Integer.parseInt(stringList[i]);
		}
		int [] sortedList=Utility.bubbleSortForInteger(numberList);
		for(int i=0;i<sortedList.length;i++) {
			System.out.print(sortedList[i]+" ");
		}
		
		
	}

}


  