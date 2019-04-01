package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterThrowingAspect {

	@Pointcut("execution(* com.example.demo.*.*.*(..))")
	public void after() {
		// This method is used to reference the pointcut at various locations
	}

	@AfterThrowing(pointcut = "after()",
			throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Throwable ex) {
		System.out.println("After throwing pointcut: " + joinPoint.getSignature().toShortString());
		System.out.println("The exception is : " + ex.getMessage());
	}
}
