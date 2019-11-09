package com.java.bridgelabz.spring.jdbctemplete.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.java.bridgelabz.spring.jdbctemplete.model.Employee;

public class EmployeeDao {
	
	
	
	JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee employee) {
		String query="Insert into emp1 values(employee.getId(),'employee.getName()',employee.getSalary())";
		return jdbcTemplate.update(query);
	}
	
	
	
	

}
