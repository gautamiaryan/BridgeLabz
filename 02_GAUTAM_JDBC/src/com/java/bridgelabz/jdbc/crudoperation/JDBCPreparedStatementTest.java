package com.java.bridgelabz.jdbc.crudoperation;

import java.sql.Connection;
import java.util.Scanner;

public class JDBCPreparedStatementTest {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Connection connection=null;
		CreateTable createTable=new CreateTable();
		ReadTable readTable=new ReadTable();
		UpdateTable updateTable=new UpdateTable();
		DeleteTable deleteTable=new DeleteTable();
		String tableName="emp";
		int choice;
		do {
			System.out.println("Please Enter Your Choice");
			System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.exit");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				connection=MySqlConnection.getMySqlDBConnection();
				createTable.insertIntoTable(tableName,connection);
				break;
			}

			case 2:{
				connection=MySqlConnection.getMySqlDBConnection();
				readTable.generateMySqlPDFReport(tableName, connection);
				break;
			}

			case 3:{
				connection=MySqlConnection.getMySqlDBConnection();

				updateTable.updateTheTable(tableName, connection);
				break;
			}

			case 4:{
				connection=MySqlConnection.getMySqlDBConnection();

				deleteTable.deleteTheTable(tableName, connection);
				break;
			}

			case 5:{
				break;
			}
			default:
				System.out.println("Please Enter a Valid Choice .");
			}
		}
		while(choice!=5);

	}

}

