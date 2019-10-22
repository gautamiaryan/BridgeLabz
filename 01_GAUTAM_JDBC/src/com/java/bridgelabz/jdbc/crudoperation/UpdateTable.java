package com.java.bridgelabz.jdbc.crudoperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateTable {
	
	public  void updateTheTable(String tableName, Connection connection){
		try {
			Statement statement=connection.createStatement();
			int count=statement.executeUpdate("UPDATE emp SET EName='Raj Krishna Jha' where EId ='105'");
			if(count>0) {
				System.out.println("Records Updated");
			}
			else {
				System.out.println("Records not updated");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();

		}
		

	}
	
	


}
