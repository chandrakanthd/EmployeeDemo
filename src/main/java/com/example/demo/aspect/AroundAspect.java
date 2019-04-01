package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

	@Pointcut("execution(* com.example.demo.*.*.*(..))")
	public void afterDemo() {
		// This method is used to reference the pointcut in multiple places
	}

	//Runs before and after a method call
	//Similar to having both before and after aspects
	@Around("afterDemo()")
	public Object afterFinal(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("Around pointcut : "+ proceedingJoinPoint.getSignature().toShortString());
		Object result = proceedingJoinPoint.proceed();
		System.out.println(""+result);
		return result;
	}
}
