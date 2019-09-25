package com.bridgelab.algorithm;

import java.util.Scanner;

public class VendingMachine {
	
	private static final int ONE=1;
    private static final int TWO=2;
    private static final int FIVE=5;
    private static final int TEN=10;
    private static final int FIFTY=50;
    private static final int HUNDRED=100;
    private static final int FIVEHUNDRED=500;
    private static final int THOUSEND=1000;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Total amount of Money:--->");
        int number=scanner.nextInt();
        minNumberOfNotes(number);

    }

    static void minNumberOfNotes(int totalMoney){
        int totalNotes=0;
        while(totalMoney>0){
            if(totalMoney>THOUSEND){
            	int Thousend_Notes=0;
                Thousend_Notes += totalMoney / THOUSEND;
                totalNotes+=Thousend_Notes;
                totalMoney=totalMoney%THOUSEND;
                System.out.println("Number of Thousend Rupee notes:--->"+Thousend_Notes);
             
            }
            else if(totalMoney>=FIVEHUNDRED){
            	int Five_Hundred_Notes = totalMoney / FIVEHUNDRED;
                totalNotes +=Five_Hundred_Notes;
                totalMoney=totalMoney%FIVEHUNDRED;
                System.out.println("Number of Five Hundred Rupee notes:--->"+Five_Hundred_Notes);
            }
            else if(totalMoney>=HUNDRED){
            	int Hundred_Notes=totalMoney / HUNDRED;
                totalNotes += Hundred_Notes;
                totalMoney=totalMoney%HUNDRED;
                System.out.println("Number of Hundred Rupee notes:--->"+Hundred_Notes);
                
            }
            else if(totalMoney>=FIFTY){
            	int Fifty_Notes=totalMoney / FIFTY;
                totalNotes += Fifty_Notes;
                totalMoney=totalMoney%FIFTY;
                System.out.println("Number of Fifty Rupee notes:--->"+Fifty_Notes);

            }
            else if(totalMoney>=TEN ){
            	int Ten_Notes=totalMoney / TEN;
                totalNotes += Ten_Notes;
                totalMoney=totalMoney%TEN;
                System.out.println("Number of Ten Rupee notes:--->"+Ten_Notes);
            }
            else if(totalMoney>=FIVE){
            	int Five_Notes=totalMoney / FIVE;
                totalNotes += Five_Notes;
                totalMoney=totalMoney%FIVE;
                System.out.println("Number of Five Rupee notes:--->"+Five_Notes);
            }
            else if(totalMoney>=TWO){
            	int Two_Notes=totalMoney/TWO;
                totalNotes+=Two_Notes;
                totalMoney=totalMoney%TWO;
                System.out.println("Number of Two Rupee notes:--->"+Two_Notes);
            }
            else{
            	int One_Notes=totalMoney/ONE;
                totalNotes+=One_Notes;
                totalMoney=totalMoney%ONE;
                System.out.println("Number of One Rupee notes:--->"+One_Notes);
            }
        }
        System.out.println("Total Number of Notes:--->"+totalNotes);
    }


}
