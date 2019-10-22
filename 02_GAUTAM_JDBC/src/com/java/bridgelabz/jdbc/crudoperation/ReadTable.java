package com.java.bridgelabz.jdbc.crudoperation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReadTable {
	
	public  void generateMySqlPDFReport(String tableName, Connection connection){
		String query="SELECT *FROM "+tableName;
		try {
			PreparedStatement statment=connection.prepareStatement(query);
			ResultSet resultSet=statment.executeQuery();


			Document myPdfReport=new Document();
			PdfWriter.getInstance(myPdfReport, new FileOutputStream("/home/gautam/Documents/Table_Read_1.pdf"));
			myPdfReport.open();
			PdfPTable table = new PdfPTable(3);
			PdfPCell tableCell;
			while(resultSet.next()) {
				String emp_id = resultSet.getString("EId");
				tableCell=new PdfPCell(new Phrase(emp_id));
				table.addCell(tableCell);
				String emp_name=resultSet.getString("EName");
				tableCell=new PdfPCell(new Phrase(emp_name));
				table.addCell(tableCell);
				String emp_salary=resultSet.getString("Salary");
				tableCell=new PdfPCell(new Phrase(emp_salary));
				table.addCell(tableCell);
				System.out.print(emp_id+" "+emp_name+" "+emp_salary+"\n");
			}

			myPdfReport.add(table);
			myPdfReport.close();
			statment.close();
			resultSet.close();
			connection.close();

		}
		catch (SQLException  | DocumentException  | FileNotFoundException e) {
			e.printStackTrace();

		}
		


	}


}
