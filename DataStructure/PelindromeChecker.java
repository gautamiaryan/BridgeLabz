package com.bridgeLabz.DataStructure;

import java.util.Scanner;

public class PelindromeChecker {
   
	public static void main(String[] args) {
		Deque deque=new Deque();
		 Scanner scanner=new Scanner(System.in);
		 System.out.println("Enter string");
		 String string=scanner.nextLine();
		 System.out.println(string);
		for(int i=0;i<string.length();i++) {
			char ch=string.charAt(i);
			deque.insertLeft(ch);
		}

		String rev="";
		for(int i=0;i<string.length();i++) {
			char ch=(char)deque.deleteRight();
			rev+=ch;
		}
		
		if(string.equals(rev)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}

	
 }
}
