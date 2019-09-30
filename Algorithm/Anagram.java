package com.bridgelabz.Program.Algorithm;
import java.util.*;
public class Anagram {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First String:--->");
		String firstString=scanner.nextLine();
		System.out.println("Enter Second String:--->");
		String secondString=scanner.nextLine();
		if(Utility.isAnagram(firstString, secondString)) {
			System.out.println("First and Second String is Anagram");
		}
		else {
			System.out.println("First and Second String is not Anagram");
		}
	   }
	

}
