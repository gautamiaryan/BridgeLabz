package com.bridgelabz.utilityoops;

import java.util.Scanner;

public class Utility {
	static Scanner scanner=new Scanner(System.in);
	public static int binarySearch(String[] list, String word) {
		int startIndex = 0;
		int endIndex = list.length - 1;
		int midIndex = (startIndex + endIndex) / 2;
		int prev = -1;
		while (!list[midIndex].equals(word) && startIndex <= endIndex) {
			if (midIndex == prev) {
				break;
			}
			prev = midIndex;
			if (word.compareTo(list[midIndex]) < 0) {
				endIndex = midIndex;
			} else {
				startIndex = midIndex;
			}
			midIndex = (startIndex + endIndex) / 2;
		}
		if (list[midIndex].equals(word)) {
			return midIndex;
		} else if (list[list.length - 1].equals(word)) {
			return ++midIndex;
		} else {
			return -1;
		}

	}
	
	
	public static void mergeSort(String[] Arr, int p, int r, String rank[]) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(Arr, p, q, rank);
			mergeSort(Arr, q + 1, r, rank);
			mergeProcess(Arr, p, q, r, rank);
		}
	}

	private static void mergeProcess(String[] Arr, int p, int q, int r, String rank[]) {
		int n1 = q - p + 1;
		int n2 = r - q;
		String[] list1 = new String[n1];
		String[] list2 = new String[n2];
		for (int i = 0; i < n1; i++) {
			list1[i] = Arr[p + i];
		}

		for (int i = 0; i < n2; i++) {
			list2[i] = Arr[q + 1 + i];
		}
		int k = p;
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			int a=linearSearch(rank, list1[i].substring(list1[i].indexOf("-")+1));
			int b=linearSearch(rank, list2[j].substring(list2[j].indexOf("-")+1));
			if (a - b < 0) {
				Arr[k++] = list1[i++];
			} else {
				Arr[k++] = list2[j++];
			}
		}
		while (i < n1) {
			Arr[k++] = list1[i++];
		}
		while (j < n2) {
			Arr[k++] = list2[j++];
		}
	}
	
	public static int linearSearch(String[] arr, String word)
	{
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(word))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	public static int getInt() {
		return scanner.nextInt();
	}
	public static long getLong() {
		return scanner.nextLong();
	}
	public static String getString() {
		return scanner.next();
	}
	public static float getFloat() {
		return scanner.nextFloat();
	}
	public static String getLineString() {
		return scanner.nextLine();
	}


}
