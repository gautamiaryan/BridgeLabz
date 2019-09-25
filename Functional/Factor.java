package com.bridgeLabz.Functional;
import java.util.*;
public class Factor {
	 public static void main(String[] args) {
	 Scanner  scn=new Scanner(System.in);
     System.out.println("Enter a number");
     int N=scn.nextInt();
     while(N<2){
         System.out.println("Please Enter a Number Greater than or Equal to Two: ");
         N=scn.nextInt();
     }
     primeFactors(N);

 }
 static void primeFactors(int n){
     int j=0;
     while (n % 2 == 0) {
         System.out.print(2 + " ");
         n /= 2;
     }
      
 
     
     for (int i = 3; i <= Math.sqrt(n); i += 2) {
         j++;
         while (n % i == 0) {
             System.out.print(i + " ");
             n /= i;
         }
     }
     System.out.println(j+"counter");

     
     if (n > 2)
         System.out.print(n);
 }
}
