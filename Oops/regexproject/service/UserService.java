package com.bridgelabz.regexproject.service;

import com.bridgelabz.regexproject.modal.UserDetails;

public interface UserService {
	public void printDate(String date);
	public String getFormattedDate();
	public String replace(UserDetails user,String message);
	public String readFile();

}
