package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;

public class DoAfterAspect {
	
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
	}

}
