package com.java.bridgelabz.spring.throwadvice;

public class Validator {
	
	public void validate(int age) throws Exception{
		
		if(age<18) {
			
			throw new ArithmeticException("Not Valid Age");
		}
		else {
			System.out.println("Vote confermed");
		}
	}

}
