package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

	@Pointcut("execution(* com.example.demo.*.*.*(..))")
	public void forTest() {
		// This method is used to reference the pointcut at various locations
	}

	@Before("forTest()")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before pointcut : " + joinPoint.getSignature().toShortString());
	}

}
