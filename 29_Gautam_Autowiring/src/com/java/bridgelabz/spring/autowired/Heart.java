package com.java.bridgelabz.spring.autowired;

public class Heart {
	
	private String nameOfAnimal;
	private int noOfHeart;
	
	public void setNameOfAnimal(String nameOfAnimal) {
		this.nameOfAnimal = nameOfAnimal;
	}

	public void setNoOfHeart(int noOfHeart) {
		this.noOfHeart = noOfHeart;
	}

	public void pump() {
		System.out.println("Your heart is pumping\nAlive!!");
	}

}
