package com.bridgeLabz.Functional;
import java.util.*;
import java.io.*;
public class TwoDimensionalArray {
	static Scanner scan = new Scanner(System.in);

	public static int[][] arrayInt(int row, int column) {
		int intArray[][] = new int[row][column];
		System.out.println();
		System.out.println("Integer Array");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				intArray[i][j] = scan.nextInt();
			}
		}   
		return intArray;
	}

	public static double[][] arrayDouble(int row, int column) {
		double b[][] = new double[row][column];
		System.out.println();
		System.out.println("Double Array");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				b[i][j] = scan.nextDouble();
			}
		}
		return b;
	}

	public static String[][] arrayBoolean(int row, int column) {
		String c[][] = new String[row][column];
		System.out.println();
		System.out.println("Boolean Array");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				c[i][j] = scan.nextLine();
			}
		}
		return c;
	}

	public static void display(int[][] intArray, double[][] doubleArray, String[][] stringArray, int row, int column) {
		PrintWriter printWriter = new PrintWriter(System.out,true);

		System.out.println();
		printWriter.println("2D ARRAY INTEGER");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				printWriter.print("\t" + intArray[i][j] + " ");
			}
			printWriter.println("\t");
		}

		System.out.println();
		printWriter.println("2D ARRAY DOUBLE");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				printWriter.print("\t" + doubleArray[i][j] + " ");
			}
			printWriter.println("\t");
		}

		System.out.println();
		printWriter.println("2D ARRAY BOOLEAN");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				printWriter.print("\t" + stringArray[i][j] + " ");
			}
			printWriter.println("\t");
		}
	}

	<t> void displayArray(t[][] arr) {
		PrintWriter printWriter = new PrintWriter(System.out);

		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				printWriter.print("\t" + arr[i][j] + " ");
			}
			printWriter.println("\t");
		}
	}

	public static void main(String[] args) {

		System.out.println("Enter number of rows: ");
		int m = scan.nextInt();
		System.out.println("Enter number of columns: ");
		int n = scan.nextInt();

		int[][] a = arrayInt(m, n);
		double[][] b = arrayDouble(m, n);
		String[][] c = arrayBoolean(m, n);

		display(a, b, c, m, n);
}
}