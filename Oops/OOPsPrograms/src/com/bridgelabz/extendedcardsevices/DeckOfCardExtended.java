package com.bridgelabz.extendedcardsevices;
import com.bridgelabz.utilityoops.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class DeckOfCardExtended {
	
	private String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private String[] cards = new String[52];
	private String[][] playersandcards = new String[4][9];
	private QueueLinkedList<String> player;
	private QueueLinkedList<QueueLinkedList<String>> allplayer = new QueueLinkedList<QueueLinkedList<String>>();
	int pos = 0;

	public DeckOfCardExtended() {
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				cards[pos++] = suit[j] + "-" + rank[i];
			}
		}
	}

	public void shuffleCards() {
		Random rnd = ThreadLocalRandom.current();
		for (int i = cards.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
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
		sortByRank();
		createPlayerObject();
		displayCards();
		
	}

	public void sortByRank() {
		for (int i = 0; i < playersandcards.length; i++) {
			Utility.mergeSort(playersandcards[i], 0, playersandcards[0].length - 1, rank);
		}
	}

	public void createPlayerObject() {
		for (int i = 0; i < playersandcards.length; i++) {
			player = new QueueLinkedList<String>();
			for (String card : playersandcards[i]) {
				player.enQueue(card);
			}
			allplayer.enQueue(player);
		}
	}
	
	private void displayCards() {
		int index = 1;
		while (!allplayer.isEmpty()) {
			player = allplayer.deQueue();
			System.out.print("player-" + index + " cards : ");
			while (!player.isEmpty()) {
				System.out.print(player.deQueue() + ", ");
			}
			index++;
			System.out.println();
		}
	}

}
