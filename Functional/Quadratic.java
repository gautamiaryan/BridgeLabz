package com.bridgelabz.Program.Functional;

import java.util.Scanner;

public class Quadratic {
	
	public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the Quadratic Equation");
        int a=scn.nextInt();
        int b= scn.nextInt();
        int c=scn.nextInt();
        findTheRootsOfEquation(a,b,c);
    }
    static void findTheRootsOfEquation(int a,int b,int c){
        double root1=0,root2=0;
        double delta=b*b-4*a*c;
        if(delta>0){
            root1 = (-b + Math.sqrt(delta)) / (2 * a);
            root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
        }
        else if(delta==0){
            root1=-b/(2*a);
            root2=-b/(2*a);
            System.out.format("root1 = root2 = %.2f;", root1);
        }
        else{
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-delta) / (2 * a);
            System.out.format("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi", realPart, imaginaryPart, realPart,
                    imaginaryPart);
        }

}
}