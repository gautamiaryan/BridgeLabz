package com.java.bridgelabz.oop.cliniquemanagement;

import com.java.bridgelabz.oop.cliniquemanagement.service.CliniqueService;
import com.java.bridgelabz.oop.cliniquemanagement.service.serviceimpl.CliniqueServiceImpl;
import com.java.bridgelabz.oop.cliniquemanagement.util.InputScanner;

public class Main {
	
	public static void main(String[] args) {
		
		CliniqueService cliniqueService=new CliniqueServiceImpl();
		int choice;
		do {
			System.out.println("Enter your choice>>");
			System.out.println("1.Take Appointment>>");
			System.out.println("2.Search Doctor>>");
			System.out.println("3.Search Patient>>");
			System.out.println("4.Show popular Doctor>>");
			System.out.println("5.Show popular specialization>>");
			System.out.println("6.Print Doctor's report>>");
			System.out.println("7.EXIT ");
			
			choice = InputScanner.getInt();
			switch (choice) {

			case 1:
				cliniqueService.takeAppointment();
				break;
			case 2:
				cliniqueService.searchDoctor();
				break;
			case 3:
				cliniqueService.searchPatient();
				break;
			case 4:
				cliniqueService.showPopularDoctor();
				break;
			case 5:
				cliniqueService.showPopularSpecialization();
				break;
			case 6:
				cliniqueService.displayDoctorRecord();
				break;
			case 7:
				 break;
			default:
				System.out.println("Please Enter Valid choice");
				break;
			}
		}
		while(choice!=7);

	}

}
