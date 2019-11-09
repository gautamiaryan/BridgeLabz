package com.java.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.methodbeforeadvice.A;

public class Test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context =new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
		
		A a=(A)context.getBean("proxy",A.class);
		
		System.out.println("proxy class name: "+a.getClass().getName());
		a.m();
	}

}
