package com.java.bridgelabz.spring.model;

public class A {

	B b;
	A(){
		System.out.println("A is created");
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}

	void print() {
		System.out.println("Hello A");
	}

	public void display() {
		print();
		b.print();
	}

}
