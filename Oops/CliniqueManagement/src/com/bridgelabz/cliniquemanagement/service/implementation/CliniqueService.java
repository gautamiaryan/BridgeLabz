package com.bridgelabz.cliniquemanagement.service.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.cliniquemanagement.model.CliniqueRecord;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.service.Clinique;
import com.bridgelabz.utilityoops.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CliniqueService implements Clinique{

	ArrayList<Patient> patients=new ArrayList<>();
	ArrayList<Doctor> doctors=new ArrayList<>();
	ArrayList<CliniqueRecord> cliniqueRecord=new ArrayList<>();
    public static final int maxAppointmentPerDoctor=5;
	public static final String patientRecordJsonPath="/home/gautam/Documents/patient.json";
	public static final String doctorRecordJsonPath="/home/gautam/Documents/doctor.json";
	public static final String cliniqueRecordJsonPath="/home/gautam/Documents/doctorpatientreport.json";

	public CliniqueService() {
		readPatient();
		readDoctor();
		readDoctorPatientReport();
	}

	private void readPatient() {
		JSONParser parser=new JSONParser();
		try(FileReader reader = new FileReader(patientRecordJsonPath)){
			Object object=parser.parse(reader);
			JSONArray patientArray=(JSONArray) object;
			for(Object object1:patientArray) {
				Patient patientmodel = new Patient();
				JSONObject patientobj = (JSONObject) object1;
				patientmodel.setName((String) patientobj.get("name"));
				patientmodel.setId((String) patientobj.get("id"));
				patientmodel.setMobNumber((Long)patientobj.get("mobNo"));
				patientmodel.setAge((int)(long) patientobj.get("age"));
				patientmodel.setDate((String) patientobj.get("date"));
				patients.add(patientmodel);

			}
			displayPatient();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void displayPatient() {
		System.out.println("patients list :");
		for (Patient patient : patients) {
			System.out.println(patient.getId());
			System.out.println(patient.getName());
			System.out.println(patient.getAge());
			System.out.println(patient.getMobNumber());
			System.out.println(patient.getDate());
			System.out.println();
		}

	}

	private void readDoctor() {
		JSONParser parser = new JSONParser();
		try(FileReader reader=new FileReader(doctorRecordJsonPath)){
			Object object=parser.parse(reader);
			JSONArray doctorArray=(JSONArray) object;
			for(Object object1:doctorArray) {
				Doctor doctormodel = new Doctor();
				JSONObject doctortobj = (JSONObject) object1;
				doctormodel.setName((String) doctortobj.get("doctorName"));
				doctormodel.setId((String) doctortobj.get("doctorID"));
				doctormodel.setSpecialization((String) doctortobj.get("specialization"));
				doctormodel.setAvailability((String) doctortobj.get("availability"));
				doctors.add(doctormodel);
			}
			displayDoctor();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void displayDoctor() {
		System.out.println("doctors list : ");
		for (Doctor doctor : doctors) {
			System.out.println(doctor.getId());
			System.out.println(doctor.getName());
			System.out.println(doctor.getSpecialization());
			System.out.println(doctor.getAvailability());
			System.out.println();
		}

	}

	private void readDoctorPatientReport() {
		JSONParser jparser = new JSONParser();
		try (FileReader reader = new FileReader(cliniqueRecordJsonPath)) {
			Object obj = jparser.parse(reader);
			JSONArray doctors = (JSONArray) obj;
			for (Object object : doctors) {
				CliniqueRecord record = new CliniqueRecord();
				JSONObject doctorreport = (JSONObject) object;
				record.setDoctorName((String) doctorreport.get("doctorName"));
				record.setDoctorID((String) doctorreport.get("doctorID"));
				record.setSpecialization((String) doctorreport.get("specialization"));
				JSONArray apointmentArr = (JSONArray) doctorreport.get("appointment");
				for (Object object2 : apointmentArr) {
					JSONArray patientArr = (JSONArray) object2;
					ArrayList<Patient> apointedPatient = new ArrayList<>();
					for (Object object3 : patientArr) {
						Patient patientmodel = new Patient();
						JSONObject patientobj = (JSONObject) object3;
						patientmodel.setName((String) patientobj.get("name"));
						patientmodel.setId((String) patientobj.get("id"));
						patientmodel.setMobNumber((Long) patientobj.get("mobNo"));
						patientmodel.setAge((int) (long) patientobj.get("age"));
						patientmodel.setDate((String) patientobj.get("date"));
						apointedPatient.add(patientmodel);
					}
					record.setAppointment(apointedPatient);
				}
				cliniqueRecord.add(record);
			}
			displayDoctorRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void takeAppointment() {
		System.out.println("Enter Doctor Name: ");
		String doctorName = Utility.getString();
		System.out.println("Enter the Doctor id : ");
		String doctorId = Utility.getString();
		System.out.println("Enter the Spacialization : ");
		String spec = Utility.getString();
		ArrayList<ArrayList<Patient>> eachDoctorApointList;
		Patient patient;
		for (CliniqueRecord record : cliniqueRecord) {
			if (record.getDoctorName().equalsIgnoreCase(doctorName) && record.getDoctorID().equalsIgnoreCase(doctorId)
					&& record.getSpecialization().equalsIgnoreCase(spec)) {
				patient=new Patient();
				eachDoctorApointList = record.getAppointment();
				Patient model = UserService.getNewUser(patient);
				int day = 0;
				boolean flag = true;
				for (ArrayList<Patient> patientListPerDay : eachDoctorApointList) {
					day++;
					if (patientListPerDay.size() < maxAppointmentPerDoctor) {
						patientListPerDay.add(model);
						flag = false;
						break;
					}
				}
				if (flag) {
					ArrayList<Patient> nextDayApointment = new ArrayList<>();
					model.setDate(UserService.getIncreamentedDate(day));
					nextDayApointment.add(model);
					eachDoctorApointList.add(nextDayApointment);
				}
				patients.add(model);
				writePatient();
				writeDoctorReport();
				displayPatient();
				displayDoctorRecord();
				System.out.println("Apointment done!!");
			}
		}
		
	}

	@Override
	public void searchDoctor() {
		Doctor doctortoSearch=UserService.findDoctor();


		if(doctortoSearch.getId()!=null){
			for (Doctor doctor : doctors) {
				if(doctor.getId().equals(doctortoSearch.getId())){
					displaySingleObject(doctor);
				}
			}
		}
		if(doctortoSearch.getName()!=null){
			for (Doctor doctor : doctors) {
				if(doctor.getName().equals(doctortoSearch.getName())){
					displaySingleObject(doctor);
				}
			}
		}
		if(doctortoSearch.getSpecialization()!=null){
			for (Doctor doctor : doctors) {
				if(doctor.getSpecialization().equals(doctortoSearch.getSpecialization())){
					displaySingleObject(doctor);
				}
			}
		}
		if(doctortoSearch.getAvailability()!=null){
			for (Doctor doctor : doctors) {
				if(doctor.getAvailability().equals(doctortoSearch.getAvailability())){
					displaySingleObject(doctor);
				}
			}
		}

	}

	private void displaySingleObject(Doctor doctor) {
		System.out.println(doctor.getId());
		System.out.println(doctor.getName());
		System.out.println(doctor.getSpecialization());
		System.out.println(doctor.getAvailability());

	}

	@Override
	public void searchPatient() {
		Patient patienttoSearch=UserService.findPatient();


		if(patienttoSearch.getId()!=null){
			for (Patient patient : patients) {
				if(patient.getId().equals(patienttoSearch.getId()))
				{
					displaySingleObject(patient);
				}
			}
		}
		if(patienttoSearch.getName()!=null){
			for (Patient patient : patients) {
				if(patient.getName().equals(patienttoSearch.getName()))
				{
					displaySingleObject(patient);
				}
			}
		}
		if(patienttoSearch.getMobNumber()!=null){
			for (Patient patient : patients) {
				if(patient.getMobNumber().equals(patienttoSearch.getMobNumber())){
					displaySingleObject(patient);
				}
			}
		}
		if(patienttoSearch.getAge()!=null){
			for (Patient patient : patients) {
				if(patient.getAge().equals(patienttoSearch.getAge())){
					displaySingleObject(patient);
				}
			}
		}

	}

	private void displaySingleObject(Patient patient) {
		System.out.println(patient.getId());
		System.out.println(patient.getName());
		System.out.println(patient.getAge());
		System.out.println(patient.getMobNumber());

	}

	@Override
	public void showPopularSpecialization() {

	}

	@Override
	public void showPopularDoctor() {

	}

	@Override
	public void displayDoctorRecord() {
		System.out.println("Doctor patients report : ");
		for (CliniqueRecord record : cliniqueRecord) {
			System.out.println(record.getDoctorID());
			System.out.println(record.getDoctorName());
			System.out.println(record.getSpecialization());
			ArrayList<ArrayList<Patient>> apointments = record.getAppointment();
			for (ArrayList<Patient> arrayList : apointments) {
				System.out.println("Apointments : ");
				for (Patient patient : arrayList) {
					System.out.println("\t\t" + patient.getId());
					System.out.println("\t\t" + patient.getName());
					System.out.println("\t\t" + patient.getAge());
					System.out.println("\t\t" + patient.getMobNumber());
					System.out.println("\t\t" + patient.getDate());
					System.out.println();
				}
				System.out.println();
			}
		}

	}
	private void writePatient() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(patientRecordJsonPath)) {
			writer.write(gson.toJson(patients));
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeDoctorReport() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(cliniqueRecordJsonPath)) {
			writer.write(gson.toJson(cliniqueRecord));
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
