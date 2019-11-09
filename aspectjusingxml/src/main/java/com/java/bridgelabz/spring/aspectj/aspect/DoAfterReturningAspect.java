package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;

public class DoAfterReturningAspect {
	
	public void doAfterReturning(JoinPoint joinPoint,Object result) {
		System.out.println("***AspectJ*** DoAfterReturning() is running!! intercepted : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
      
		
	}

}
