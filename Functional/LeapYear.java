package com.bridgelabz.Program.Functional;

import java.util.Scanner;

public class LeapYear {
	
	public static void main(String [] args){
	       
        System.err.println("Please Enter a year of four digit: ");
        Scanner scanner=new Scanner(System.in);
        int year=scanner.nextInt();
        while(year<1000 || year>=10000)
        {
            System.out.println("Please Enter a valid year of four digit: ");
            year = scanner.nextInt();
        }
        isLeapYear(year);
    }
    static void isLeapYear(int year){
        boolean leap=false;
        
            if(year%4==0 && year %100!=0 || year%400==0){
                leap=true;
            }
            else{
                leap=false;
            }
        
        if(leap){
            System.out.println(year+" is a leap year.");
        }
        else{
            System.out.println(year+" is not a leap year.");
        }
        
    }

}
