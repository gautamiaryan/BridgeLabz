package com.java.bridgelabz.jdbc.crudoperation;
import java.sql.*;
public class UpdateTable {
    public void updateTheTable(String tableName,Connection connection) {
    	try {
        	PreparedStatement statement=connection.prepareStatement("update emp set name=? where EISSSd=?");  
			statement.setString(1,"Abhishek Singh");
			statement.setString(2,"101");  
	    	int i=statement.executeUpdate();  
	    	System.out.println(i+" records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}  
      
    }
}
