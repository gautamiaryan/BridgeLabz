package com.java.bridgelabz.jdbc.crudoperation;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {

	public  void deleteTheTable(String tableName, Connection connection){
		String query="delete from emp where EId=105";
		try {
			Statement statement=connection.createStatement();
			int count=statement.executeUpdate(query);
			
			if(count>0) {
				System.out.println("Records deleted");
			}
			else {
				System.out.println("Records not deleted");
			}
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();

		}


	}
}