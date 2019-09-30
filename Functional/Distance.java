package com.bridgelabz.Program.Functional;

import java.util.Scanner;

public class Distance {
	
	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of X and Y");
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        System.out.println(findTheDistance(x, y));
    }
    static double findTheDistance(int x,int y){
        double dist=((x*x)+(y*y));
        double result =Math.sqrt(dist);
        return result;
    }

}
