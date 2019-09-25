package com.bridgeLabz.Functional;
import java.util.*;
public class UserName {
	
	public static void main(String [] args){
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("Enter your UserName");
	    String userName=scanner.nextLine();
	    String welcomeMessage="Hello UserName, How are you?";
	    replaceUserName(userName,welcomeMessage);
	    }
	    static void replaceUserName(String userName,String welcomeMessage){
	        if(userName.length()>=3){
	            String newMessage=welcomeMessage.replaceAll("\\bUserName\\b", userName);
	            System.out.println(newMessage);
	        }
	        else{
	            System.out.println("Please Enter a valid Username");
	        }

	    }

}
