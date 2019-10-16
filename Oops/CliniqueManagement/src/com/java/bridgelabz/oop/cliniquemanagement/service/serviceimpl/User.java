package com.java.bridgelabz.oop.cliniquemanagement.service.serviceimpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import com.java.bridgelabz.oop.cliniquemanagement.model.Doctor;
import com.java.bridgelabz.oop.cliniquemanagement.model.Patient;
import com.java.bridgelabz.oop.cliniquemanagement.util.InputScanner;

public class User {
	
	public static Patient getNewUser(Patient patient) {
		System.out.println("Enter Patient Name : ");
		patient.setName(InputScanner.getString());
		System.out.println("Enter Patient ID : ");
		patient.setId(InputScanner.getString());
		System.out.println("Enter Patient Mobile Number : ");
		patient.setMobNumber((long)InputScanner.getLong());
		System.out.print("Enter Patient age : ");
		patient.setAge(InputScanner.getInt());
		patient.setDate(""+LocalDate.now());
		return patient;
	}
	public static String getIncreamentedDate(int days)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calender = Calendar.getInstance();
	        calender.add(Calendar.DAY_OF_MONTH, days);  
		return dateFormat.format(calender.getTime());  
	}

	public static Doctor findDoctor() {
		Doctor doctor = new Doctor();
		System.out.println("Enter The Choice To Search Doctor : ");
		System.out.println("1.By Name\n2.By Id\n3.By Specialization\n4.By Availability");
		int num = InputScanner.getInt();
		switch (num) {
		case 1:
			System.out.println("Enter Doctor Name : ");
			doctor.setName(InputScanner.getString());
			break;
		case 2:
			System.out.println("Enter Doctor Id : ");
			doctor.setId(InputScanner.getString());
			break;
		case 3:
			System.out.println("Enter Doctor Specialization");
			doctor.setSpecialization(InputScanner.getString());
			break;
		case 4:
			System.out.println("Enter Doctor Availability");
			doctor.setSpecialization(InputScanner.getString());
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		return doctor;
	}

	public static Patient findPatient() {
		Patient patient = new Patient();
		System.out.println("Enter The Choice To Search Patient : ");
		System.out.println("1.By Name\n2.By Id\n3.By Mobile Number");
		int num = InputScanner.getInt();
		switch (num) {
		case 1:
			System.out.println("Enter Patient Name : ");
			patient.setName(InputScanner.getString());
			break;
		case 2:
			System.out.println("Enter Patient Id : ");
			patient.setId(InputScanner.getString());
			break;
		case 3:
			System.out.println("Enter Patient Mobile Number ");
			patient.setMobNumber((long) InputScanner.getLong());
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		return patient;
	}

}
