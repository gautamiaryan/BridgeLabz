package com.bridgelabz.cliniquemanagement.service.implementation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.utilityoops.Utility;

public class UserService {
	
	public static Patient getNewUser(Patient patient) {
		System.out.println("Enter Patient Name : ");
		patient.setName(Utility.getString());
		System.out.println("Enter Patient ID : ");
		patient.setId(Utility.getString());
		System.out.println("Enter Patient Mobile Number : ");
		patient.setMobNumber((long)Utility.getLong());
		System.out.print("Enter Patient age : ");
		patient.setAge(Utility.getInt());
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
		int num = Utility.getInt();
		switch (num) {
		case 1:
			System.out.println("Enter Doctor Name : ");
			doctor.setName(Utility.getString());
			break;
		case 2:
			System.out.println("Enter Doctor Id : ");
			doctor.setId(Utility.getString());
			break;
		case 3:
			System.out.println("Enter Doctor Specialization");
			doctor.setSpecialization(Utility.getString());
			break;
		case 4:
			System.out.println("Enter Doctor Availability");
			doctor.setSpecialization(Utility.getString());
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
		int num = Utility.getInt();
		switch (num) {
		case 1:
			System.out.println("Enter Patient Name : ");
			patient.setName(Utility.getString());
			break;
		case 2:
			System.out.println("Enter Patient Id : ");
			patient.setId(Utility.getString());
			break;
		case 3:
			System.out.println("Enter Patient Mobile Number ");
			patient.setMobNumber((long) Utility.getLong());
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		return patient;
	}

}
