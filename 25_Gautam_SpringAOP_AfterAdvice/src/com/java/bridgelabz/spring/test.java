package com.java.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.afteradvice.A;

public class test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
	    
		A a=context.getBean("proxy",A.class);
		
		a.m();
	
	
	}

}
