package com.bridgelabz.cardmain;

import java.util.Scanner;

import com.bridgelabz.cardservice.DeckOfCards;

public class PlayCard {
	
	public static void main(String[] args) {
		DeckOfCards deckofcards = new DeckOfCards();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1:Shuffle cards \n2:Distribute cards \n3: Exit Game");
			System.out.println("Enter the your choice : ");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				deckofcards.shuffleCards();
				break;
			case 2:
				deckofcards.distributeCards();
				break;
			default:
				flag = false;
			}
		}
	}

}
