package com.java.bridgelabz.jdbc.crudoperation;

import java.sql.*;

public class CreateTable {
	public  void insertIntoTable(String tableName, Connection connection){
		String query="INSERT INTO " +tableName+" VALUES('108','Sanjeet','70000')";
		try {
			Statement statment=connection.createStatement();
			int count =statment.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();

		}
		


	}
	
}