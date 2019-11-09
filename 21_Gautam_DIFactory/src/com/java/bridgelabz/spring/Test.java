package com.java.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.model.A;

public class Test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
		
		A a=(A) context.getBean("a");
		
		a.msg();
		
	}

}
