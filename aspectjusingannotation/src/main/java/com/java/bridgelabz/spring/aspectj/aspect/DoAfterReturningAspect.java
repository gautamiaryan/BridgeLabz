package com.java.bridgelabz.spring.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect

public class DoAfterReturningAspect {
	
	@AfterReturning(
			pointcut="execution(* com.java.bridgelabz.spring.aspectj.service.SimpleService.sayHello(..))",returning="result")
	public void doAfterReturning(JoinPoint joinPoint,Object result) {
		System.out.println("***AspectJ*** DoAfterReturning() is running!! intercepted : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
      
		
	}

}
