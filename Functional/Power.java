package com.bridgeLabz.Functional;

import java.util.Scanner;

public class Power {
	public static void main(String [] args){
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("Please enter the range");
	    int range=scanner.nextInt();
	    powerOfTwoUptoN(range);
	    }
	
	
	    static void powerOfTwoUptoN(int range){
	        for(int i=0;i<=range;i++){
	            int value=(int)Math.pow(2, i);
	            System.out.println(value);
	        }
	    }
}
