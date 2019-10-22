package com.java.bridgelabz.designpattern.facade;

import java.sql.Connection;

public class HelperFacade {
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
		Connection connection = null;
		switch (dbType){
		case MYSQL: 
			connection = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			switch(reportType){
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, connection);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, connection);
				break;
			}
			break;
		case ORACLE: 
			connection = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			switch(reportType){
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, connection);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, connection);
				break;
			}
			break;
		}
		
	}
	
	public static enum DBTypes{
		MYSQL,ORACLE;
	}
	
	public static enum ReportTypes{
		HTML,PDF;
	}

}
