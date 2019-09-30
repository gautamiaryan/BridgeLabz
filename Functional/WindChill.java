package com.bridgelabz.Program.Functional;

import java.util.Scanner;

public class WindChill {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Enter temperature in fahrenheit");
			double f = scanner.nextDouble();
			System.out.println("Enter wind speed in miles per hour");
			double ws = scanner.nextDouble();
			if (Math.abs(f) > 50 || ws > 120 || ws < 3) {
				System.out.println("Enter correct input");
			} else {
				windChill(f, ws);
			}
		} catch (Exception e) {
			System.out.println("Enter proper input");
		}
		scanner.close();

    }
    static void windChill(double t,double v){
       double effectiveTemp=35.74+0.6215*t+(0.4275-35.75)*Math.pow(v,0.16);
       System.out.println("The effective temperature is: "+effectiveTemp);
    }   

}
