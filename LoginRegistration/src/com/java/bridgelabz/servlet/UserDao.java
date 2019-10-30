package com.java.bridgelabz.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private static final String connectionUrl="jdbc:mysql://localhost:3306/User";
	private static final String userName="root";
	private static final String password="root";
	public static  Connection getMysqlConnection() {
		Connection connection=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionUrl,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public static  boolean velidate(String username,String password) {
		boolean status=false;
		Connection connection=UserDao.getMysqlConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from REGISTERUSER where Name=? and Password=?");
			statement.setString(1,username);  
			statement.setString(2,password);  
		    ResultSet resultSet=statement.executeQuery();
		    status=resultSet.next();
		    connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		return status;
	}

}
