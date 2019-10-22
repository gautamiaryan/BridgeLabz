package com.java.bridgelabz.jdbc.crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	
	public static Connection getMySqlDBConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/employee";
		Connection connection=null;
        try {
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	        connection = DriverManager.getConnection(connectionURL, "root", "root");
	        

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return connection;
	}
	

}
