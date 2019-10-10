package com.bridgelabz.regexproject.serviceImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.regexproject.modal.UserDetails;
import com.bridgelabz.regexproject.service.UserService;

public class ServiceImplementation implements UserService{
	
	BufferedReader bufferedReader;

	@Override
	public void printDate(String date) {

	}

	@Override
	public String getFormattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return sdf.format(date);
	}

	@Override
	public String replace(UserDetails user, String message) {
		
		Pattern p = Pattern.compile("<<name>>");
		Matcher m = p.matcher(message);
		message = m.replaceAll(user.getFirstName());

		p = Pattern.compile("<<full name>>");
		m = p.matcher(message);
		message = m.replaceAll(user.getFirstName() + " " + user.getLastName());

		p = Pattern.compile("xxxxxxxxxx");
		m = p.matcher(message);
		message = m.replaceAll(user.getMobileNum());

		p = Pattern.compile("01/01/2016");
		m = p.matcher(message);
		message = m.replaceAll(user.getDate());

		return message;
	}

	@Override
	public String readFile() {
		StringBuilder string = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("/home/gautam/Documents/message.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				string.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return string.toString();
	}


}
