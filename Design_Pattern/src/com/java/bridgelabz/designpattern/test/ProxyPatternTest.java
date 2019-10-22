package com.java.bridgelabz.designpattern.test;

import com.java.bridgelabz.designpattern.proxy.CommandExecutor;
import com.java.bridgelabz.designpattern.proxy.CommandExecutorProxy;

public class ProxyPatternTest {
	
	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
	}

}
