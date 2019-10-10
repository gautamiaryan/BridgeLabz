package com.bridgelabz.cliniquemanagement.model;

import java.util.ArrayList;

public class CliniqueRecord {
	
	private String doctorName;
	private String doctorID;
	private String specialization;
	private ArrayList<ArrayList<Patient>> appointment=new ArrayList<>();
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public ArrayList<ArrayList<Patient>> getAppointment() {
		return appointment;
	}
	public void setAppointment(ArrayList<Patient> appointment) {
		this.appointment.add(appointment);
	}
	

}
