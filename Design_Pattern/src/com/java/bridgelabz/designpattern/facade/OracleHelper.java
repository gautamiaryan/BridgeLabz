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

public class OracleHelper {


	public static Connection getOracleDBConnection(){
		String connectionURL = "jdbc:mysql://localhost:3306/student";
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

	public void generateOraclePDFReport(String tableName, Connection connection){
		try {
			Statement statment=connection.createStatement();
			ResultSet resultSet=statment.executeQuery("select rollNo,SName,Marks from StudentDetails");
			Document my_pdf_report = new Document();
			PdfWriter.getInstance(my_pdf_report, new FileOutputStream("/home/gautam/Documents/pdf_report_from_oracle_using_java.pdf"));
			my_pdf_report.open();            
			PdfPTable my_report_table = new PdfPTable(3);
			PdfPCell table_cell;
			while(resultSet.next()) {
				String Emp_id = resultSet.getString("rollNo");
				table_cell=new PdfPCell(new Phrase(Emp_id));
				my_report_table.addCell(table_cell);
				String dept_name=resultSet.getString("SName");
				table_cell=new PdfPCell(new Phrase(dept_name));
				my_report_table.addCell(table_cell);
				String manager_id=resultSet.getString("Marks");
				table_cell=new PdfPCell(new Phrase(manager_id));
				my_report_table.addCell(table_cell);
			}
			my_pdf_report.add(my_report_table); 
			my_pdf_report.close();
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

	public void generateOracleHTMLReport(String tableName, Connection connection){

		try {
			Statement statment=connection.createStatement();
			ResultSet resultSet=statment.executeQuery("select rollNo,SName,Marks from StudentDetails");
			PrintWriter writer=new PrintWriter("/home/gautam/Documents/html_report_from_oracle_using_java.htm");
            writer.write("<!DOCTYPE html>\n<meta charset=\"UTF-8\">\n<html>\n<head>\n<title>Student Report</title>\n</head>\n<body>\n");
			writer.write("<P ALIGN='center'><TABLE BORDER=1>");
			 ResultSetMetaData rsmd = resultSet.getMetaData();
			 int columnCount = rsmd.getColumnCount();
			 writer.write("<TR>");
			 for (int i = 0; i < columnCount; i++) {
			   writer.write("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
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
