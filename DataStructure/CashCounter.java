package com.bridgelabz.Program.DataStructure;

import java.util.Scanner;

public class CashCounter {
	static int cashBalance=0;
	public static void main(String[] args) {
		QueueLinkedList queue=new QueueLinkedList();
		Scanner scanner =new Scanner(System.in);
		int totalDeposited=0;
		int totalWithdrawn=0;
		System.out.println("Please Enter the Number of Customer you wanna in a Queue");
		int numberOfPeople=scanner.nextInt();
		for(int i=1;i<=numberOfPeople;i++) {
			System.out.println("Please enter the amount of Customer "+i);
			int amount=scanner.nextInt();
			queue.enQueue(amount);
			
		}
		for(int i=1;i<=numberOfPeople;i++) {
			System.out.println("Please Enter 1.Deposit\nPlease Enter 2.Withdraw");
			int choice=scanner.nextInt();
			switch(choice){
			case 1:{
				int amount=queue.deQueue();
				totalDeposited+=amount;
				cashBalance+=amount;
				break;
			}
			case 2:{
				int amount=queue.deQueue();
				totalWithdrawn+=amount;
				cashBalance-=amount;
				break;
			}
			default:{
				System.out.println("Invalid choice");
				break;
			}
					
			}
			System.out.println(totalDeposited+"  "+totalWithdrawn);
			if(Math.abs(cashBalance)==Math.abs((totalDeposited-totalWithdrawn))) {
				System.out.println("Expression is Balanced");
			}
			else {
				System.out.println("Expression is Not Balanced");
			}
			
		}
		
		
	}

}
