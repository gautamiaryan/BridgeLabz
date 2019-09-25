package com.bridgeLabz.Functional;
import java.util.*;
public class FlipCoin {

	public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of Flip Coin");
        int numberOfTimeFlipCoin=scanner.nextInt();
        percentageOfHeadAndTell(numberOfTimeFlipCoin);
    }
    static void percentageOfHeadAndTell(int number){
      int numberOfHead=0;
      int numberOfTell=0;
      double rangeMin = 0.0f;
      double rangeMax = 1.0f;
      Random r = new Random();
      for(int i=0;i<number;i++){
       double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
       if(createdRanNum<0.5){
           numberOfTell+=1;
       }
       else{
           numberOfHead+=1;
       }
      }
      double percentageOfHead=(numberOfHead*100)/number;
      double percentageOfTell=(numberOfTell*100)/number;
      System.out.println("Percentage of Head:-"+percentageOfHead+"%  Percentage of Tell:-"+percentageOfTell+"% ");
    }
}
