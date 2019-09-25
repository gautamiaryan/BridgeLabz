package com.bridgelab.algorithm;
import com.bridgeLabz.Functional.*;
import java.util.*;
import java.lang.*;
public class ElapsedTime {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		StopWatch stopWatch=new StopWatch();
		double []elapsedTimes=new double [6];
		int i=-1;
		double start=0;
		double stop=0;
		double elapseTime=0;
		int[] sorted;
		String [] sortString;
		int [] array= {9,6,99,5,98,4,3,101,2,105,1,66,63,55,44,23,14,95,100};
		String [] string= {"P","C","B","E","D","F","H","G","J","I","K","A","N","M","P","O"};
		System.out.println("Please Enter to start insertion sort for integer");
		scanner.next();
		start=stopWatch.startTime();
		sorted=Utility.insertionSortForInteger(array);
		stop=StopWatch.stopTime();
		Utility.printSortedArray(sorted);
		elapseTime=stopWatch.elapsedTime(start, stop);
		elapsedTimes[++i]=elapseTime;
		
		System.out.println("Please enter to start insertion sort for string");
		scanner.next();
		start=stopWatch.startTime();
		sortString=Utility.insertionSortForString(string);
		stop=stopWatch.stopTime();
		Utility.printStringArray(sortString);
	    elapseTime=stopWatch.elapsedTime(start, stop);
	    elapsedTimes[++i]=elapseTime;
	    
	    System.out.println("Please Enter to start bubble sort for integer");
	    scanner.next();
	    start=stopWatch.startTime();
	    sorted=Utility.bubbleSortForInteger(array);
	    stop=stopWatch.stopTime();
	    Utility.printSortedArray(sorted);
	    elapseTime=stopWatch.elapsedTime(start, stop);
	    elapsedTimes[++i]=elapseTime;
	    
	    
	    System.out.println("Please Enter to start bubble sort for String");
	    scanner.next();
	    start=stopWatch.startTime();
	    sortString=Utility.bubbleSortForString(string);
	    stop=stopWatch.stopTime();
	    Utility.printStringArray(sortString);
	    elapseTime=stopWatch.elapsedTime(start, stop);
	    elapsedTimes[++i]=elapseTime;
	    
	    System.out.println("Please Enter to start Binary Search for integer");
	    scanner.next();
	    start=stopWatch.startTime();
	    int startIndex=0,endIndex=sorted.length-1,numberToSearch=9;
	    int searchedItem=Utility.binarySearchForInteger(sorted, startIndex, endIndex, numberToSearch);
	    stop=stopWatch.stopTime();
	    System.out.println(searchedItem);
	    elapseTime=stopWatch.elapsedTime(start, stop);
	    elapsedTimes[++i]=elapseTime;
	    
	    System.out.println("Please Enter to start binary search for string");
	    scanner.hasNext();
	    start=stopWatch.startTime();
	    String wordToSearch="A";
	    int searchedString=Utility.binarySearchForString(sortString, wordToSearch);
	    stop=stopWatch.stopTime();
	    System.out.println(searchedString);
	    elapseTime=stopWatch.elapsedTime(start, stop);
	    elapsedTimes[++i]=elapseTime;
	    
	    System.out.println("time taken for each operation");
	    //Utility.printSortedArray(elapsedTimes);
	    for(int i1=0;i1<elapsedTimes.length;i1++) {
	    	System.out.println(elapsedTimes[i]);
	    }
	    System.out.println("time taken in sorted order");
	    //int[] sort=Utility.insertionSortForInteger(elapsedTimes);
	    //Utility.printSortedArray(sort);
	
		}

}
