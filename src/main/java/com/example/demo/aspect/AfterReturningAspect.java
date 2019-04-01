package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterReturningAspect {

	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	public void afterController() {
		// This method is used to reference the pointcut at various locations
	}

	@AfterReturning(pointcut = "afterController()")
	public void afterReturn(JoinPoint joinPoint) {
		System.out.println("After returning pointcut: " + joinPoint.getSignature().toShortString());
	}

}
