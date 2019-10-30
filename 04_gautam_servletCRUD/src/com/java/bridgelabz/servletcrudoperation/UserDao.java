package com.java.bridgelabz.servletcrudoperation;

import java.sql.*;
import java.util.*;

public class UserDao {
	private static final String connectionUrl="jdbc:mysql://localhost:3306/User";
	private static final String user="root";
	private static final String password="root";
	public static Connection getMySqlConnection() {
		Connection connection=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection=DriverManager.getConnection(connectionUrl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return connection;
	}

	public static int saveUser(User user) {
		int status=0;
		try {
			Connection connection=UserDao.getMySqlConnection();
			PreparedStatement statement=connection.prepareStatement("insert into user107(FULLNAME,USERPASSWORD,USEREMAIL,COUNTRY) values(?,?,?,?)");
			statement.setString(1,user.getName());
			statement.setString(2,user.getPassword());
			statement.setString(3,user.getEmail());
			statement.setString(4,user.getCountry());
			
			status=statement.executeUpdate();
			if(status>0) {
				System.out.println("record updated");
			}
			else {
				System.out.println("record not updated");
			}
			connection.close();


		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static int updateUser(User user) {
		int status=0;
		try {
			Connection connection=UserDao.getMySqlConnection();
			PreparedStatement statement=connection.prepareStatement("update user107 set FULLNAME=?,USERPASSWORD=?,USEREMAIL=?,COUNTRY=? where ID=?");
			
			statement.setString(1,user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getCountry());
			statement.setInt(5, user.getId());
			
			status=statement.executeUpdate();
			
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int deleteUser(int id) {
		int status=0;
		
		try {
			Connection connection=UserDao.getMySqlConnection();
			PreparedStatement statement=connection.prepareStatement("delete from user107 where ID=?");
			statement.setInt(1,id);
			
			status=statement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	public static User getUserById(int id) {
		
		User user =new User();
		try {
			Connection connection=UserDao.getMySqlConnection();
			PreparedStatement statement=connection.prepareStatement("Select *from user107 where ID=?");
			
			statement.setInt(1,id);  
            ResultSet resultSet=statement.executeQuery();  
            if(resultSet.next()){  
                user.setId(resultSet.getInt(1));  
                user.setName(resultSet.getString(2));  
                user.setPassword(resultSet.getString(3));  
                user.setEmail(resultSet.getString(4));  
                user.setCountry(resultSet.getString(5));  
            }  
            
            connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
		
		
	}
	
	public static List<User> getAllUsers(){
		List<User> userList=new ArrayList<User>();
		
		try {
			Connection connection=UserDao.getMySqlConnection();
			PreparedStatement statement=connection.prepareStatement("select *from user107");
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setCountry(resultSet.getString(5));
				userList.add(user);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
}