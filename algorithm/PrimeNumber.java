package com.bridgelab.algorithm;

public class PrimeNumber {
	public static void main(String[] args) {
		int minRange=0;
		int maxRange=1000;
		System.out.println("Prime Number between "+minRange+" to "+maxRange);
		for(int i=minRange;i<=maxRange;i++) {
			if(Utility.isPrime(i)) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println("\n\nPrime numbers Which are Pelindrome:--->");
		Utility.primePallindrome();
		System.out.println("\n\nPrime numbers Which are Anagram:--->");
		Utility.primeAnagrams();
		
	}
	
	
	
}
