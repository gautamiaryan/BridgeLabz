package com.bridgeLabz.Functional;
import java.util.*;

public class CoupanNumber {
	public static void main(String [] args){
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter The Number of Coupan");
        int n=scn.nextInt();
        int randomGenerated=uniqueCoupanNumber(n);
        System.out.println("Total random number generated: "+randomGenerated);
    }
    
    public static int getCoupon(int n) {
        return (int) (Math.random() * n);
    }

    public static int uniqueCoupanNumber(int n) {
        boolean[] isCollected = new boolean[n]; 
        int count = 0; 
        int distinct = 0; 

       
        while (distinct < n) {
            int value = getCoupon(n); 
            count++; 
            if (!isCollected[value]) { 
                distinct++;
                isCollected[value] = true;
            }
        }
        return count;
    }
    
}
