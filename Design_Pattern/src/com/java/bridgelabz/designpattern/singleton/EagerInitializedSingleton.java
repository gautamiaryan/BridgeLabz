package com.java.bridgelabz.designpattern.singleton;

public class EagerInitializedSingleton {
	
	private static final EagerInitializedSingleton instance=new EagerInitializedSingleton();
	
	private EagerInitializedSingleton() {
		
	}
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
		
	}
	
	public static void main(String[] args) {
		EagerInitializedSingleton instance1=EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instance2=EagerInitializedSingleton.getInstance();
		
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}

}
