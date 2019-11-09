package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DoAfterThrowingAspect {
	@AfterThrowing(
			pointcut="execution(* com.java.bridgelabz.spring.aspectj.service.SimpleService.sayHello(..))",throwing="error")
	public void doAfterThrowing(JoinPoint joinPoint,Throwable error) {
		
		System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
      
		
	}

}
