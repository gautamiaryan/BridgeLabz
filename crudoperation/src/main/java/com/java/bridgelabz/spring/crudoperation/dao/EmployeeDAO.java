package com.java.bridgelabz.spring.crudoperation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.java.bridgelabz.spring.crudoperation.model.Employee;

public class EmployeeDAO {
	
    private JdbcTemplate template;
    
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}



	public int save(Employee emp) {
		String query="insert into emp3(Id,EName,Salary,Designation) values("+emp.getId()+","+emp.getName()+","+emp.getSalary()+","+emp.getDesignation()+")";
		 
		return template.update(query);
	}
	
	public int update(Employee emp) {
		String query="update emp3 set EName="+emp.getName()+" ,Salary="+emp.getSalary()+",Designsation="+emp.getDesignation()+" where Id="+emp.getId()+"";
		return template.update(query);
	}
	
	public int delete(int id) {
		String query="delete from emp3 where Id="+id;
		return template.update(query);
	}
	
	public Employee getEmployeeById(int id) {
		String query="select * emp3 where Id="+id;
		
		return template.queryForObject(query, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public List<Employee> getEmployees(){
		
		return template.query("select * from emp3",new RowMapper<Employee>(){
		
			public Employee mapRow(ResultSet rs, int row) throws SQLException {    
				Employee e=new Employee();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getString(3));    
	            e.setDesignation(rs.getString(4));  
	            return e;    
	        }    
	    });    
	}
}
