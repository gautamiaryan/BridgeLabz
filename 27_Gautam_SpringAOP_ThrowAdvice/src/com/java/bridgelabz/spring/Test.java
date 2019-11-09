package com.java.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.throwadvice.Validator;

public class Test {
	
	public static void main(String[] args) {
	    ApplicationContext context =new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
        
	    Validator validate=(Validator) context.getBean("proxy");
	    
	    try {
			validate.validate(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
