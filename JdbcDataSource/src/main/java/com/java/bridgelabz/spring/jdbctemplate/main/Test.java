package com.java.bridgelabz.spring.jdbctemplate.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bridgelabz.spring.jdbctemplate.dao.EmployeeDao;
import com.java.bridgelabz.spring.jdbctemplate.model.Employee;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao employeeDao=(EmployeeDao) context.getBean("employeeDAO");
		Employee employee=new Employee();
		int random=new Random().nextInt(1000);
		employee.setId(random);
		employee.setName("Rahul singh");
		employee.setSalary("1000000");

		employeeDao.save(employee);
        int id=1;
		Employee emp1 = employeeDao.getById(id);
		System.out.println("Employee Retrieved::"+emp1);
        
		
		emp1.setSalary("200000");
		employeeDao.update(emp1);

		List<Employee> empList = employeeDao.getAll();
		System.out.println(empList);

		employeeDao.deleteById(random);
		
		context.close();

		

		System.out.println("DONE");

	}

}
