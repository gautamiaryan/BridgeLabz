package com.bridgelabz.Program.DataStructure;
import java.util.*;
public class PrimeAnagram {
	
	static boolean isAnagram(String A,String B){
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
	public static void main(String[] args) {
		PrimeNumber2DArray  primes=new PrimeNumber2DArray();
		String primeString="";
		for(int i=0;i<1000;i++) {
			if(primes.isPrime(i)) {
				primeString+=i+" ";
			}
		}
		String primeAnagram="";
		String [] primeList=primeString.split(" ");
		for(int i=0;i<primeList.length-1;i++) {
			for(int j=i+1;j<primeList.length;j++) {
				String l=primeList[i];String m=primeList[j];
				if(isAnagram(l,m)) {
					primeAnagram+=l+" ";
					
				}
			}
		}
         System.out.println(primeAnagram);
//		String [] primeAnagramNumber=primeAnagram.split(" ");
//		Arrays.sort(primeAnagramNumber);
//		
//		for(int i=0;i<primeAnagramNumber.length;i++) {
//			System.out.println(primeAnagramNumber[i]+" ");
//		}
		
	}

}
