package com.bridgelabz.cliniquemanagement.main;

import com.bridgelabz.cliniquemanagement.service.implementation.CliniqueService;
import com.bridgelabz.utilityoops.Utility;

public class CliniqueManagement {
	
	public static void main(String[] args) {
		
		CliniqueService cliniqueService=new CliniqueService();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice>>");
			System.out.println("1.Take Appointment>>");
			System.out.println("2.Search Doctor>>");
			System.out.println("3.Search Patient>>");
			System.out.println("4.Show popular Doctor>>");
			System.out.println("5.Print Doctor's report>>");
			System.out.println("6.EXIT ");
			
			int choice = Utility.getInt();
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
				cliniqueService.displayDoctorRecord();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			
		}

	}

}
