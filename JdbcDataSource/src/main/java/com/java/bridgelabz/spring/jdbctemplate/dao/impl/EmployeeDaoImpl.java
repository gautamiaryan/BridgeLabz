package com.java.bridgelabz.spring.jdbctemplate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.java.bridgelabz.spring.jdbctemplate.dao.EmployeeDao;
import com.java.bridgelabz.spring.jdbctemplate.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Employee employee) {
		String queery="insert into emp1(Id,EName,Salary) values(?,?,?)";
		
		Connection connection=null;
		PreparedStatement pStatement=null;
		
		try {
			connection=dataSource.getConnection();
			pStatement=connection.prepareStatement(queery);
			pStatement.setInt(1,employee.getId());
			pStatement.setString(2, employee.getName());
			pStatement.setString(3, employee.getSalary());
			
			int status=pStatement.executeUpdate();
			if(status!=0) {
				System.out.println("Employee successfully added with id:-->"+employee.getId());
			}
			else {
				System.out.println("Employee not added with id:--->"+employee.getId());
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				pStatement.close();
			}
			catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
		
	}

	public Employee getById(int id) {
		String query="select Id,EName,Salary from emp1 where Id=?";
		Employee employee=null;
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=dataSource.getConnection();
			pStatement=connection.prepareStatement(query);
			pStatement.setInt(1,id);
			resultSet=pStatement.executeQuery();
			if(resultSet.next()) {
				employee=new Employee();
				employee.setId(resultSet.getInt("Id"));
				employee.setName(resultSet.getString("EName"));
				employee.setSalary(resultSet.getString("Salary"));
				System.out.println("Employee found: "+employee);
				
			}
			else {
				System.out.println("Employee not found ");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				resultSet.close();
				pStatement.close();
				connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return employee;
	}

	public void update(Employee employee) {
		String query="update emp1 set EName=?,set Salary=? where Id=?";
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=dataSource.getConnection();
			pStatement =connection.prepareStatement(query);
			pStatement.setString(1,employee.getName());
			pStatement.setString(2, employee.getSalary());
			pStatement.setInt(3, employee.getId());
			
			int status=pStatement.executeUpdate();
			
			if(status!=0) {
				System.out.println("Employee updated with id: "+employee.getId());
			}
			else {
				System.out.println("Employee not updated with id"+employee.getId());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pStatement.close();
				connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void deleteById(int id) {
		String query="delete from emp1 where Id=?";
		Connection connection =null;
		PreparedStatement pStatement=null;
		try {
			connection = dataSource.getConnection();
			pStatement=connection.prepareStatement(query);
			pStatement.setInt(1, id);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Employee> getAll() {
		
		String query = "select Id, EName, Salary from emp1";
		List<Employee> empList = new ArrayList<Employee>();
		Connection connection = null;
		PreparedStatement pSatement = null;
		ResultSet resultSet = null;
		try{
			connection = dataSource.getConnection();
			pSatement = connection.prepareStatement(query);
			resultSet = pSatement.executeQuery();
			while(resultSet.next()){
				Employee emp = new Employee();
				emp.setId(resultSet.getInt("Id"));
				emp.setName(resultSet.getString("EName"));
				emp.setSalary(resultSet.getString("Salary"));
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				pSatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
		
	}
	
	

}
