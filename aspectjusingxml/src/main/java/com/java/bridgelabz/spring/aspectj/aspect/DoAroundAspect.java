package com.java.bridgelabz.spring.aspectj.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class DoAroundAspect {
	
	
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
				+ " \narguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("***AspectJ*** DoAround() before is running!");
		joinPoint.proceed();
		System.out.println("***AspectJ*** DoAround() after is running!");
	}

}
