package com.bridgelabz.cardservice;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
	
	private String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private String[] cards = new String[52];
	private String[][] playersandcards = new String[4][9];
	int position = 0;

	public DeckOfCards() {
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				cards[position++] = rank[i] + "-" + suit[j];
			}
		}
	}

	public void shuffleCards() {
		Random random = ThreadLocalRandom.current();
		for (int i = cards.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			String value = cards[index];
			cards[index] = cards[i];
			cards[i] = value;
		}

	}

	public void distributeCards() {
		int row = 0;
		int col = 0;
		for (String card : cards) {
			if (col < 9) {
				playersandcards[row++][col] = card;
				if (row == playersandcards.length) {
					row = 0;
					col++;
				}
			} else {
				break;
			}
		}
		displayCards();
	}

	private void displayCards() {
		int index = 1;
		for (String[] playercards : playersandcards) {
			System.out.println("player-" + index + " cards : " + Arrays.toString(playercards));
			index++;
		}
	}

}
