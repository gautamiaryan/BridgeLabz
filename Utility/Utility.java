package com.bridgelabz.Program.Utility;
import java.util.*;
public class Utility {
	
	static Scanner scanner = new Scanner(System.in);    

	public static List<Integer> primeNumberUptoRange(int range){
		List<Integer> listOfPrime=new ArrayList<Integer>();
		for(int i=1;i<=range;i++){
			int count=0;
			for(int j=2;j<=i;j++){
				if(i%j==0){
					count+=1;
				}
			}
			if(count==1){
				listOfPrime.add(i);
			}
		}
		return listOfPrime;

	}


	public static boolean isPrime(int number){
		int count=0;
		if(number<2) {
			return false;
		}
		for(int i=2;i<=number/2;i++){
			if(number%i==0){
				count+=1;
			}
		}
		if(count==0){
			return true;
		}
		else{
			return false;
		}
	}


	public static boolean isPalindromeString(String string){
		String temp="";
		for(int i=string.length()-1;i>=0;i--){
			temp+=string.charAt(i);
		}
		if(string.equals(temp)){
			return true;
		}else{
			return false;
		}
	}


	public static boolean isPalindrome(int number){
		int number1=number;
		int reverse=0;
		int remainder;
		while (number != 0) {
			remainder = number % 10;
			reverse = (reverse * 10) + remainder;
			number /= 10;
		}
		if(number1==reverse){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean isAnagram(String A,String B){
		int a=A.length();
		int b=B.length();
		if(a!=b){
			return false;
		}
		char [] A1=A.toCharArray();
		char [] B1=B.toCharArray();
		Arrays.sort(A1);
		Arrays.sort(B1);
		return Arrays.equals(A1, B1);
	}

	public static void primePallindrome() {
		System.out.println();
		boolean b;
		for (int j = 2; j <= 1000; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b && isPalindrome(j))
				System.out.print(j + " ");
		}
	}


	public static ArrayList<Integer> primeAnagrams() {
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		ArrayList<Integer> primeAnagramList=new ArrayList<Integer>();
		System.out.println();
		for(int i=0;i<=1000;i++) {
			if (isPrime(i))
				primeList.add(i);
		}
		for (int i = 0; i < primeList.size(); i++) {
			for (int j = i + 1; j < primeList.size(); j++) {
				if (isAnagram(Integer.toString(primeList.get(i)), Integer.toString(primeList.get(j)))) {
					primeAnagramList.add(primeList.get(i));
					primeAnagramList.add(primeList.get(j));
				}
			}
		}
		return primeAnagramList;
	}

	public static int[] insertionSortForInteger(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}



	public static void printSortedArray(int arr[]) {
		int length = arr.length;
		for (int i = 0; i < length; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
	
	public static void printStringArray(String [] string) {
		int length=string.length;
		for(int i=0;i<length;i++) {
			System.out.print(string[i]+" ");
		}
		System.out.println();
	}


	public static String[] insertionSortForString(String array[]) {
		String temp = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareToIgnoreCase(array[j]) > 0) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}


	public static int [] bubbleSortForInteger(int []arr){
		int length=arr.length;
		for (int i = 0; i < length; i++){
			for (int j = 0; j < length - i - 1; j++){
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}



	public static String [] bubbleSortForString(String [] arr){
		String temp="";
		for (int j = 0; j < arr.length; j++) {
			for (int i = j + 1; i < arr.length; i++) {
				if (arr[i].compareTo(arr[j]) < 0) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}




	public static int binarySearchForInteger(int [] arr,int startIndex,int endIndex,int numberToSearch){

		if (endIndex >= startIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;


			if (arr[midIndex] ==numberToSearch ){
				return midIndex;
			}


			if (arr[midIndex] > numberToSearch){
				return binarySearchForInteger(arr, startIndex, midIndex - 1, numberToSearch);
			}


			return binarySearchForInteger(arr, midIndex + 1, endIndex, numberToSearch);
		}

		return-1;

	}


	public static int binarySearchForString(String string[],String wordToSearch){
		int startIndex=0;
		int endIndex=string.length-1;
		while (startIndex <= endIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;

			int result = wordToSearch.compareTo(string[midIndex]);

			if (result == 0)
				return midIndex;


			if (result > 0)
				startIndex = midIndex + 1;


			else
				endIndex = midIndex - 1;
		}
		
		return-1;
	}

	public static void dayOfWeek(int day,int month,int year){

		int mYear = year -(14 - month) / 12;
		int x = mYear + mYear/4 - (mYear/100) + (mYear/400);
		int mMonth = month + 12 * ((14 - month) / 12) - 2;
		int dDay = (day + x + (31*mMonth) / 12) % 7;
		String dayOfWeek="";
		switch(dDay){
		case 0:
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		case 4:
			dayOfWeek = "Thursday";
			break;
		case 5:
			dayOfWeek = "Friday";
			break;
		case 6:
			dayOfWeek = "Saturday";
			break;
		default:
			dayOfWeek = "Invalid day";
			break;
		}
		System.err.println("Day of Week is: "+ dayOfWeek);

	}



	public static void temperatureConversion(){

		System.err.println("Enter Temperature in Celsius");
		int celsius=scanner.nextInt();
		double inFahrenheit= (celsius*9)/5+32;
		System.out.println("Temperature in Fahrenheit is: "+inFahrenheit);
		System.out.println("Enter Temperature in Fahrenheit: ");
		int fahrenheit=scanner.nextInt();
		double inCelsius=(fahrenheit-32) * 5/9;
		System.out.println("Temperature in Celsius is: "+inCelsius);
	}

	public static void monthlyPayment(double P,double Y,double R){
		double payment=0;
		double n=Y*12;
		double r=R/1200;

		payment=(P*r)/(1-(Math.pow((1+r), (-n))));

		System.out.println(payment);

	}

	public static void squareRoot(Double C){
		double t=C;
		double epsilon = 1e-15;

		while(Math.abs(t - C / t)> (epsilon*t) ){
			t= ((C/t)+t)/2.0;
		}
		System.out.println(t);

	}

	public static int [] toBinary(int decimalValue){

		String bin = "";
		while (decimalValue != 0) {
			bin = (decimalValue % 2) + bin;
			decimalValue /= 2;
		}
		while (bin.length() % 4 != 0) {
			bin = 0 + bin;
		}
		return stringToIntArray(bin);

	}


	public static int[] stringToIntArray(String bin) {
		int[] binary = new int[bin.length()];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = bin.charAt(i) - 48;
		}
		return binary;
	}

	public static int toDecimal(int[] binary) {
		int decimal = 0, j = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			if (binary[i] == 1) {
				decimal = decimal + (int) Math.pow(2, j);
			}
			j++;
		}
		return decimal;
	}
	
	public static void merge(int []array,int startIndex,int midIndex,int endIndex) {
		int left=midIndex-startIndex+1;
		int right=endIndex-midIndex;
		int [] leftArray=new int[left];
		int [] rightArray=new int[right];
		for(int i=0;i<left;i++) {
			leftArray[i]=array[startIndex+i];
		}
		for(int j=0;j<right;j++) {
			rightArray[j]=array[midIndex+j];

		}
		int i = 0, j = 0;  
		int k = startIndex;  
		while (i<left&&j<right){  
			if (leftArray[i] <= rightArray[j]){  
				array[k] = leftArray[i];  
				i++;  
			}  
			else{  
				array[k] = rightArray[j];  
				j++;  
			}  
			k++;  
		}  
		while (i<left){  
			array[k] = leftArray[i];  
			i++;  
			k++;  
		}  

		while (j<right){  
			array[k] = rightArray[j];  
			j++;  
			k++;  
		}  
	}


	
	public static void mergeSort(int [] array,int startIndex,int endIndex) {
		if (startIndex<endIndex)  
		{  
		int mid = (startIndex+endIndex)/2;  
		mergeSort(array, startIndex, mid);  
		mergeSort(array , mid+1, endIndex);  
		merge(array, startIndex, mid, endIndex);  
		}  
	}


}
