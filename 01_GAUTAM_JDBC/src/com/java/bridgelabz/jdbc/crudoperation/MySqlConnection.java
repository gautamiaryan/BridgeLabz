package com.java.bridgelabz.jdbc.crudoperation;
import java.sql.*;
public class MySqlConnection {
	
	public static Connection getMySqlDBConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/employee";
		Connection connection=null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(connectionURL, "root", "root");
	        

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return connection;
	}
	

}
