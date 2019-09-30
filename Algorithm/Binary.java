package com.bridgelabz.Program.Algorithm;
import java.util.*;
public class Binary {
	
	static void showArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}


	static boolean isPowerOfTwo(int n) {
		if(n==0) 
			return false; 

		return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==  
				(int)(Math.floor(((Math.log(n) / Math.log(2))))); 
	} 

	static int[] swapNibbles(int[] arr) {

		int temp, j = arr.length - 4;
		for (int i = 0; i < 4; i++) { 
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j++;
		}
		return arr;
	}


	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("enter a no");
			int[] binary = Utility.toBinary(s.nextInt());
			System.out.println("Binary is ");
			showArr(binary);
			swapNibbles(binary);
			System.out.println("After swapping ");
			showArr(binary);
			int swapDec = Utility.toDecimal(binary);
			System.out.println("Decimal of swapped Binary is " + swapDec);
			if (isPowerOfTwo(swapDec)) {
				System.out.println("It's power of 2");
			}
			else {
				System.out.println("It's not power of 2");
			}
		} catch (Exception e) {
			System.out.println("enter input as integer ");
		}

	}


}
