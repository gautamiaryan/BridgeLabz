package com.java.bridgelabz.designpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		EagerInitializedSingleton instanceOne=EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo=null;
		EagerInitializedSingleton instanceThree=null;
		EagerInitializedSingleton instanceFour=null;
		
		try {
			
			Constructor [] constructors=EagerInitializedSingleton.class.getDeclaredConstructors();
			
			for(Constructor constructor:constructors) {
				constructor.setAccessible(true);
				instanceTwo=(EagerInitializedSingleton) constructor.newInstance();
				instanceThree=(EagerInitializedSingleton) constructor.newInstance();
				instanceFour=(EagerInitializedSingleton) constructor.newInstance();
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println(instanceThree.hashCode());
		System.out.println(instanceFour.hashCode());
		
	}

}
