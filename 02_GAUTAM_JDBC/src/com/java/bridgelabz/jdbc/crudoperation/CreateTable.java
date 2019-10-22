package com.java.bridgelabz.jdbc.crudoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CreateTable {
	
	public  void insertIntoTable(String tableName, Connection connection){
		
		try {
			PreparedStatement statement=connection.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			
			do{  
				System.out.println("Enter Employee id:");  
				String EId=br.readLine();  
				System.out.println("Enter Employee Name:");  
				String EName=br.readLine();  
				System.out.println("Enter Employee Salary:");  
				String Salary=br.readLine();  
				  
				statement.setString(1,EId);  
				statement.setString(2,EName);  
				statement.setString(3,Salary);  
				int i=statement.executeUpdate();  
				System.out.println(i+" records affected");  
				System.out.println("Do you want to continue: yes/no");  
				String s=br.readLine();  
				if(s.startsWith("n")){  
				break;  
				}  
				}while(true);  
				  
				connection.close();  
		}
		catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}
