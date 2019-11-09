package com.java.bridgelabz.spring.aspectj.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DoAroundAspect {
	
	@Around("execution(* com.java.bridgelabz.spring.aspectj.service.SimpleService.sayHello(..))")
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
				+ " \narguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("***AspectJ*** DoAround() before is running!");
		joinPoint.proceed();
		System.out.println("***AspectJ*** DoAround() after is running!");
	}

}
