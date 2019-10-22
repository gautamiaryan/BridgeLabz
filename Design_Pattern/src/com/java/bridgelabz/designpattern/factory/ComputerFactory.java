package com.java.bridgelabz.designpattern.factory;

import com.java.bridgelabz.designpattern.model.Computer;
import com.java.bridgelabz.designpattern.model.PC;
import com.java.bridgelabz.designpattern.model.Server;

public class ComputerFactory {
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
		
		return null;
	}

}
