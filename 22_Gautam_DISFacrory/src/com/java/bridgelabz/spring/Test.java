package com.java.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.factory.Printable;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
		
		Printable printable=(Printable) context.getBean("printable");
		
		printable.print();
	}

}
