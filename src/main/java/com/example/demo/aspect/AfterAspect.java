package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

	@Pointcut("execution(* com.example.demo.*.*.*(..))")
	public void afterDemo() {
		// This method is used to reference the pointcut in multiple places
	}
	
	//Works like finally block in try-catch
	//Runs regardless of success or failure of method call
	@After("afterDemo()")
	public void afterFinal(JoinPoint joinPoint) {
		System.out.println("After pointcut : "+ joinPoint.getSignature().toShortString());
	}
}
