package com.java.bridgelabz.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {
	@Autowired
    @Qualifier("humanHeart")
	private Heart heart;
   
	public void startPumping() {
		if(heart!=null) {
		    heart.pump(); 
		}
		else {
			System.out.println("your heart is not pumping\nYou are dead");
		}
	}

}
