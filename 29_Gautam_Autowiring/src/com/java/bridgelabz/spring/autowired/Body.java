package com.java.bridgelabz.spring.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/config/bean.xml");
	    Human human=(Human) context.getBean("human");
	    human.startPumping();
	
	}

}
