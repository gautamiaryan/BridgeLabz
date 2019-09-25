package com.bridgeLabz.Functional;
import java.util.*;
public class TicTac {
	
	static Scanner scanner =new Scanner(System.in);
	static int player=0;
	static int[][] BOARD = new int[3][3];
	static boolean isEmpty = true;

	static void initBoard(String playerName) {
		System.out.println("TIC TAC TOE GAME\nComputer is o\n"+playerName+" is x ");
		for (int i = 0; i < BOARD.length; i++) {
			for (int j = 0; j < BOARD[i].length; j++) {
				BOARD[i][j] = -10;
			}
		}
		System.out.println("Board is this :");
		displayBoard();
	}

	static void displayBoard() {
		int count = 0;
		for (int i = 0; i < BOARD.length; i++) {
			System.out.println("---------------");
			System.out.print("||");
			for (int j = 0; j < BOARD[i].length; j++) {
				if (BOARD[i][j] == 0) {
					count++;
					System.out.print(" o |");
				} else if (BOARD[i][j] == 1) {
					count++;
					System.out.print(" x |");
				} else
					System.out.print("   |");
			}
			System.out.println("|");
		}
		if (count == 9) {
			isEmpty = false;
		}
		System.out.println("---------------");
	}
	
	static void putValue() {
		int i;
		int j;
		if (player % 2 == 1) {
			i = (int) (Math.random() * 10) % 3;
			j = (int) (Math.random() * 10) % 3;
		} else {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter value of x and y by space");
			i = s.nextInt();
			j = s.nextInt();
		}
		if (BOARD[i][j] == -10) {
			if (player % 2 == 0) {
				BOARD[i][j] = 0;
			} else {
				BOARD[i][j] = 1;
				System.out.println("Coumputer Choosing " + i + " " + j);
			}
		} else
			putValue();

	}

	static boolean win() {
		return ((BOARD[0][0] + BOARD[0][1] + BOARD[0][2] == player * 3)
				|| (BOARD[1][0] + BOARD[1][1] + BOARD[1][2] == player * 3)
				|| (BOARD[2][0] + BOARD[2][1] + BOARD[2][2] == player * 3)
				|| (BOARD[0][0] + BOARD[1][0] + BOARD[2][0] == player * 3)
				|| (BOARD[0][1] + BOARD[1][1] + BOARD[2][1] == player * 3)
				|| (BOARD[0][2] + BOARD[1][2] + BOARD[2][2] == player * 3)
				|| (BOARD[0][0] + BOARD[1][1] + BOARD[2][2] == player * 3)
				|| (BOARD[2][0] + BOARD[1][1] + BOARD[0][2] == player * 3));
	}

	static void play() {
		System.out.println("Please Enter your Name");
		String playerName=scanner.nextLine();
		initBoard(playerName);
		while (isEmpty) {
			System.out.println(playerName+"'s turn:");
			putValue();
			displayBoard();
			if (win()) {
				System.out.println(playerName+" won!!");
				return;
			}
			player = 1;
			System.out.println("Computer's turn:");
			putValue();
			displayBoard();
			if (win()) {
				System.out.println("Computer won!!");
				return;
			}
			player = 0;
		}
	}

	public static void main(String[] args) {

		play();
	}

}
