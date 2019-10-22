package com.java.bridgelabz.designpattern.test;

import java.sql.Connection;

import com.java.bridgelabz.designpattern.facade.HelperFacade;
import com.java.bridgelabz.designpattern.facade.MySqlHelper;
import com.java.bridgelabz.designpattern.facade.OracleHelper;

public class FacadePatternTest {
	
	public static void main(String[] args) {
        String tableName="emp";
        String tableName1="StudentDetails";
		
		//generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		
		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName1, con1);
	
		//generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.PDF, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.HTML, tableName1);
		}

}
