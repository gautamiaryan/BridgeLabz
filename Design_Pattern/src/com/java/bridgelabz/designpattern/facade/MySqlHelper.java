package com.java.bridgelabz.designpattern.facade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class MySqlHelper {
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
	
	public  void generateMySqlPDFReport(String tableName, Connection connection){
		  
		try {
			Statement statment=connection.createStatement();
			ResultSet resultSet=statment.executeQuery("select EId,EName,Salary from emp");
		    
			
			 Document myPdfReport = new Document();
             PdfWriter.getInstance(myPdfReport, new FileOutputStream("/home/gautam/Documents/pdf_report_from_sql_using_java.pdf"));
             myPdfReport.open();            
             PdfPTable myReportTable = new PdfPTable(3);
             PdfPCell tableCell;
             while(resultSet.next()) {
            	 String Emp_Id = resultSet.getString("EId");
                 tableCell=new PdfPCell(new Phrase(Emp_Id));
                 myReportTable.addCell(tableCell);
                 String Emp_Name=resultSet.getString("EName");
                 tableCell=new PdfPCell(new Phrase(Emp_Name));
                 myReportTable.addCell(tableCell);
                 String Emp_Salary=resultSet.getString("Salary");
                 tableCell=new PdfPCell(new Phrase(Emp_Salary));
                 myReportTable.addCell(tableCell);
             }
             myPdfReport.add(myReportTable); 
             myPdfReport.close();
             statment.close();
             resultSet.close();
             connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}
			  
	}
	

	
	public void generateMySqlHTMLReport(String tableName, Connection connection){
		
		try {
			Statement statment=connection.createStatement();
			ResultSet resultSet=statment.executeQuery("select EId,EName,Salary from emp");
			
			
			PrintWriter writer=new PrintWriter("/home/gautam/Documents/html_report_from_sql_using_java.htm");
            writer.write("<!DOCTYPE html>\n<meta charset=\"UTF-8\">\n<html>\n<head>\n<title>Employee Report</title>\n</head>\n<body>\n");
			writer.write("<P ALIGN='center'><TABLE BORDER=1>");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			 int columnCount = resultSetMetaData.getColumnCount();
			 writer.write("<TR>");
			 for (int i = 0; i < columnCount; i++) {
			   writer.write("<TH>" + resultSetMetaData.getColumnLabel(i + 1) + "</TH>");
			   }
			 writer.write("</TR>");
			 while (resultSet.next()) {
			  writer.write("<TR>");
			  for (int i = 0; i < columnCount; i++) {
			    writer.write("<TD>" + resultSet.getString(i + 1) + "</TD>");
			    }
			  writer.write("</TR>");
			  }
			 writer.write("</TABLE></P>");
			 
			 writer.write("</body>\n</html>".toString());
			 writer.flush();
			 writer.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		


		
	}
	
}
