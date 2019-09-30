package com.bridgelabz.Program.DataStructure;
import java.util.*;
public class BinarySearchTree {
	
	static int M=100000007;
	static long factorial(int n) 
	{ 
	    long res = 1; 
	    while(n>=1) {
	    	res=(res*n)%M;
	        n--;
	    }
	    return res;
	  
	    
	} 
	
	static long binomialCoeff(int n,int k) { 
		long res = 1;
		if (k > n - k) 
			k = n - k; 
		for (int i = 0; i < k; ++i) 
		{ 
			res =(res*(n - i))%M; 
			res =(res/(i + 1)); 
		} 

		return res; 
	} 
	
	static Long catalan( int n) 
	{ 
	      
	   
	    long c = binomialCoeff(2 * n, n); 
	    return c / (n + 1); 
	} 
	
	static long countBST( int n) 
	{ 
	     
	    long count = catalan(n); 
	    return count; 
	} 

	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter");
		for(int i=1;i<=100;i++) {
		int count=(int)Math.abs(countBST(i));
		System.out.println(count);
		}
		
	}
	
	

}
