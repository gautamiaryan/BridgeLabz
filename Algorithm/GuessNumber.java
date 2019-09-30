package com.bridgelabz.Program.Algorithm;
import java.util.*;
public class GuessNumber {
	
	static Scanner scanner=new Scanner(System.in);
	static int findMyNumber(int number) {

		int startIndex = 0, endIndex = number-1, midIndex;
		while (startIndex != endIndex) {
			midIndex = (startIndex + endIndex) / 2;
			System.out.println("Please Enter 1 if number is between " + startIndex + " - " + midIndex + "\nEnter 2 if number is between "
					+ (midIndex + 1) + " - " + endIndex);
			int c = scanner.nextInt();
			midIndex = (startIndex + endIndex) / 2;
			if (c == 1)
				endIndex = midIndex;
			else
				startIndex = midIndex + 1;
		}
		return startIndex;
	}

	public static void main(String[] args) {
		System.out.println("Enter a number");
        int number=scanner.nextInt();
        System.out.println("Please Guess a number between 0 to "+number);
		scanner.next();
		try {
			System.out.println("Your Guessed number is " + findMyNumber(number));
		} catch (Exception e) {
			System.out.println("Enter correct input");
		}

}


}
