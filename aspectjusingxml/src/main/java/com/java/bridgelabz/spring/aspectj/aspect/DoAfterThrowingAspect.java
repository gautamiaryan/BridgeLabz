package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;

public class DoAfterThrowingAspect {
	
public void doAfterThrowing(JoinPoint joinPoint,Throwable error) {
		
		System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
      
		
	}

}
