package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;

public class DoBeforeAspect {
		
	public void doBefore(JoinPoint joinPoint) {
		 
        System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
    }
	
}
