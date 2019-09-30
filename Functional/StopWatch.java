package com.bridgelabz.Program.Functional;

import java.util.Scanner;

public class StopWatch {
	
	static double start = 0, stop = 0;

	 public static double startTime() {
		start = System.currentTimeMillis();
		return start;
	}

	
	 public static double stopTime() {
		stop = System.currentTimeMillis();
		return stop;
	}

	
	 public static double elapsedTime(double start,double stop) {
		double elapseTime=(stop - start);
		return elapseTime;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter to start");
		scanner.next();
		double start=startTime();
		System.out.println("Started at :-->"+start);
		System.out.println("Enter to stop");
		scanner.next();
		double stop=stopTime();
		System.out.println("Stoped at:-->"+stop);
		double elapseTime=elapsedTime(start,stop);
		System.out.println("Elapsed time:-->"+elapseTime);
	}

}
