package com.bridgelabz.Program.Functional;
import java.util.*;
public class HarmonicNumber {
	
	public static void main(String[] args){
	    Scanner scn=new Scanner(System.in);
	    System.out.println("Enter the Number");
	    int N=scn.nextInt();
	    nThHarmonicNumber(N);
	    }
	    static void nThHarmonicNumber(int N){
	     double nthHarNumber=1;
	     for(int i=2;i<=N;i++){
	         
	         nthHarNumber+=(double)1/i;
	     }
	     System.out.println(nthHarNumber);
	    }

}
