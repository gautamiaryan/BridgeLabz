package com.java.bridgelabz.spring.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.jdbctemplete.dao.EmployeeDao;
import com.java.bridgelabz.spring.jdbctemplete.model.Employee;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/java/bridgelabz/spring/context/applicationContext.xml");
	    
		EmployeeDao emp=(EmployeeDao) context.getBean("employeeDAO");
		
		int status=emp.saveEmployee(new Employee(102,"Amit","35000"));  
	    System.out.println(status); 
	}

}
