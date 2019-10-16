package com.java.bridgelabz.oop.addressbook.util;

import java.util.Scanner;

public class InputScanner {
	
	static Scanner scanner=new Scanner(System.in);
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
