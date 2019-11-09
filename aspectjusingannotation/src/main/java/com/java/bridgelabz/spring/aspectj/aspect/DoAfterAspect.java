package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect

public class DoAfterAspect {
	
	@After("execution(* com.java.bridgelabz.spring.aspectj.service.SimpleService.sayHello(..))")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
	}
	

}
