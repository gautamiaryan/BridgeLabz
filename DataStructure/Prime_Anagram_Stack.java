package com.bridgelabz.Program.DataStructure;

import com.bridgelabz.Program.Algorithm.Utility;

public class Prime_Anagram_Stack {
	
	public static void main(String[] args) {
		StackLinkedList<Integer> stack=new StackLinkedList<Integer>();
		int minRange=0;
		int maxRange=1000;
		System.out.println("Prime Number between "+minRange+" to "+maxRange);
		int [] primeList=new int[300];
		int count=0;
		for(int i=minRange;i<=maxRange;i++) {
			if(Utility.isPrime(i)) {
				primeList[count++]=i;
			}
		}
		int counter=0;
		for(int i=0;i<count-1;i++) {
			for(int j=i+1;j<count;j++) {
				if(Utility.isAnagram(Integer.toString(primeList[i]), Integer.toString(primeList[j]))) {
					stack.push(primeList[i]);
					stack.push(primeList[j]);
					counter+=1;
				}
			}
		}
		
		for(int i=0;i<counter;i++) {
			Object prime_Anagram=stack.pop();
			Object prime_Anagram1=stack.pop();
			System.out.println(prime_Anagram+" " + prime_Anagram1);
			
		}
	}

}
