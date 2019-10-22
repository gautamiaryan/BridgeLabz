package com.java.bridgelabz.jdbc.crudoperation;

import java.sql.*;

public class DeleteTable {
	
	public  void deleteTheTable(String tableName, Connection connection){
		String query="delete from emp where EId=105";
		try {
			PreparedStatement stmt=connection.prepareStatement("delete from emp where EId=?");  
			stmt.setInt(1,101);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			
		}
		catch (SQLException e) {
			e.printStackTrace();

		}


	}

}
