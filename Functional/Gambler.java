package com.bridgeLabz.Functional;
import java.util.*;
public class Gambler {
	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int stake=scanner.nextInt();
        int goal=scanner.nextInt();
        int N=scanner.nextInt();
        gamblingResult(stake, goal, N);

    }
    static void gamblingResult(int stake,int goal,int totalTimesPlayed){
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        Random random = new Random();
        int numOfWin = 0;
        int numOfLoss = 0;
        for(int i=1;i<= totalTimesPlayed;i++){
            double result = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            if(stake<goal && result>0.5){
              numOfWin+=1;
              stake+=1; 
            }
            else if(stake<goal && result<0.5){
             numOfLoss+=1;
             stake-=1;
            }
            else{
                break;
            }
        }
        double percentageOfWin=(numOfWin*100)/totalTimesPlayed;
        double percentageOfLoss=(numOfLoss*100)/totalTimesPlayed;
        System.out.println(totalTimesPlayed);
        System.out.println("Number of Win:-"+numOfWin);
        System.out.println("Percentage of Win:-"+percentageOfWin);
        System.out.println("Percentage of Loss:-"+percentageOfLoss);

    }
}
