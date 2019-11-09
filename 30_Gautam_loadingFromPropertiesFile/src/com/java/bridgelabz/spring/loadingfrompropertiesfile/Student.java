package com.java.bridgelabz.spring.loadingfrompropertiesfile;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	
	private String name;
	private String intrestedCourse;
	private String hobby;
	
	@Value("Gautam kumar Singh")
	public void setName(String name) {
		this.name = name;
	}
	
	@Value("Java/Python")
	public void setIntrestedCourse(String intrestedCourse) {
		this.intrestedCourse = intrestedCourse;
	}
	
	@Value("Cricket/chess")
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	public void displayStudentInfo() {
		System.out.println("Student name "+name);
		System.out.println("Intrested course "+intrestedCourse);
		System.out.println("Student hobby "+hobby);
	}

}
