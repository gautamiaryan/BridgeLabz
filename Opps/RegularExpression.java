package com.bridgelabz.Program.Opps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegularExpression {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String welcomeMessage="Hello <<name>>,\n We have your full name as <<full name>> in our system.\n your contact number is 91-xxxxxxxxxx.\n Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		System.out.println("Please Enter your first Name");
		String yourName=scanner.nextLine();
		System.out.println("Please Enter your last name");
		String yourFullName=scanner.nextLine();
		System.out.println("Please Enter Your Contact Number");
		String yourContactNumber=scanner.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dDate = new Date();
		String date=dateFormat.format(dDate);
		String newWelcomeMessage=replaceWelcomeMessage(welcomeMessage, yourName, yourFullName, yourContactNumber, date);
		System.out.println(newWelcomeMessage);
		

		
	}
	
	static String replaceWelcomeMessage(String welcomeMessage,String firstName,String lastName,String contactNumber,String date) {
		String fullName=firstName+" "+lastName;
		System.out.println(fullName);
		welcomeMessage=welcomeMessage.replace("<<name>>", firstName);
		welcomeMessage=welcomeMessage.replace("<<full name>>", fullName);
		welcomeMessage=welcomeMessage.replace("xxxxxxxxxx", contactNumber);
		welcomeMessage=welcomeMessage.replace("01/01/2016",date);
		return welcomeMessage;
	}

}
