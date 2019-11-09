package com.java.bridgelabz.spring.jdbctemplate.dao;

import java.util.List;

import com.java.bridgelabz.spring.jdbctemplate.model.Employee;

public interface EmployeeDao {

	public void save(Employee employee);
	public Employee getById(int id);
	public void update(Employee employee);
	public void deleteById(int id);
	public List<Employee> getAll();




}
