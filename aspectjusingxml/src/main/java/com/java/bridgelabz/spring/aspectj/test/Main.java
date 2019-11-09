package com.java.bridgelabz.spring.aspectj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.aspectj.service.SimpleService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/aspectj/context/applicationContext.xml");

		SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
		simpleService.printNameId();
		System.out.println("---------------");
		try{
			simpleService.checkName();
		} catch(Exception e){
			System.out.println("SimpleService checkName() : Exception thrown..");
		}
		System.out.println("---------------");
		simpleService.sayHello("Javacodegeeks");
		System.out.println("---------------");

	}

}
