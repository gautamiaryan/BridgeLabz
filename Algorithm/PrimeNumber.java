package com.bridgelabz.Program.Algorithm;
import com.bridgelabz.Program.Utility.*;
import java.util.*;
public class PrimeNumber {
	public static void main(String[] args) {
		ArrayList<Integer> primeAnagram=new ArrayList<Integer>();
		int minRange=0;
		int maxRange=1000;
		System.out.println("Prime Number between "+minRange+" to "+maxRange);
		for(int i=minRange;i<=maxRange;i++) {
			if(Utility.isPrime(i)) {
				System.out.print(i+" ");
			}
		}
		System.out.println("\n\nPrime numbers Which are Palindrome:--->");
		Utility.primePallindrome();
		System.out.println("\n\nPrime numbers Which are Anagram:--->");
		primeAnagram=Utility.primeAnagrams();
		System.out.println(primeAnagram);
	}

}
