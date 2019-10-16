package com.bridgelabz.regexproject.main;

import java.util.Scanner;

import com.bridgelabz.regexproject.modal.UserDetails;
import com.bridgelabz.regexproject.service.UserService;
import com.bridgelabz.regexproject.serviceImplementation.ServiceImplementation;

public class RegaxMain {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Scanner sc = new Scanner(System.in);
		UserService util = new ServiceImplementation();
		System.out.println("Enter your first name");
		String firstName = sc.next();
		System.out.println("Enter your last name");
		String lastName = sc.next();
		System.out.println("Enter the Mobile Number");
		String mobileNum = sc.next();
		user.setFirstName(firstName);
		user.setLastName(lastName);;
		user.setMobileNum(mobileNum);
		user.setDate(util.getFormattedDate());
		String message=util.readFile();
		System.out.println(util.replace(user,message));
		
	}

}
