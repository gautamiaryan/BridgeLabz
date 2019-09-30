package com.bridgelabz.Program.Utility;
import java.util.*;
public class Util {
	
	static Scanner scanner=new Scanner(System.in);
	static void dayOfWeek(int day,int month,int year){

		int mYear = year -(14 - month) / 12;
		int x = mYear + mYear/4 - (mYear/100) + (mYear/400);
		int mMonth = month + 12 * ((14 - month) / 12) - 2;
		int dDay = (day + x + (31*mMonth) / 12) % 7;
		String dayOfWeek="";
		switch(dDay){
		case 0:
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		case 4:
			dayOfWeek = "Thursday";
			break;
		case 5:
			dayOfWeek = "Friday";
			break;
		case 6:
			dayOfWeek = "Saturday";
			break;
		default:
			dayOfWeek = "Invalid day";
			break;
		}
		System.err.println("Day of Week is: "+ dayOfWeek);

	}
	
	
	static void temperatureConversion(){

		System.err.println("Enter Temperature in Celsius");
		int celsius=scanner.nextInt();
		double inFahrenheit= (celsius*9)/5+32;
		System.out.println("Temperature in Fahrenheit is: "+inFahrenheit);
		System.out.println("Enter Temperature in Fahrenheit: ");
		int fahrenheit=scanner.nextInt();
		double inCelsius=(fahrenheit-32) * 5/9;
		System.out.println("Temperature in Celsius is: "+inCelsius);
	}
	
	
	static void monthlyPayment(double P,double Y,double R){
		double payment=0;
		double n=Y*12;
		double r=R/1200;

		payment=(P*r)/(1-(Math.pow((1+r), (-n))));

		System.out.println(payment);

	}
	
	
	static void squareRoot(Double C){
		double t=C;
		double epsilon = 1e-15;

		while(Math.abs(t - C / t)> (epsilon*t) ){
			t= ((C/t)+t)/2.0;
		}
		System.out.println(t);

	}

	static int [] toBinary(int decimalValue){

		String bin = "";
		while (decimalValue != 0) {
			bin = (decimalValue % 2) + bin;
			decimalValue /= 2;
		}
		while (bin.length() % 4 != 0) {
			bin = 0 + bin;
		}
		return stringToIntArray(bin);

	}
	
	static int[] stringToIntArray(String bin) {
		int[] binary = new int[bin.length()];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = bin.charAt(i) - 48;
		}
		return binary;
	}

	static int toDecimal(int[] binary) {
		int decimal = 0, j = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			if (binary[i] == 1) {
				decimal = decimal + (int) Math.pow(2, j);
			}
			j++;
		}
		return decimal;
	}


}
