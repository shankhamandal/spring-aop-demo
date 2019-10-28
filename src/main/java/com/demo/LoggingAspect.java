package com.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.demo.StudentController.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {
		System.out.println("Entering method " + joinPoint.getSignature());
	}

	@Before("execution(* com.demo.StudentController.getStudentById(..))")
	public void logBeforeGetStudentById(JoinPoint joinPoint) {
		System.out.println("Calling method getStudentById(), logged from method specific advice");
	}

	@After("execution(* com.demo.StudentController.*(..))")
	public void logAfterAllMethods(JoinPoint joinPoint) {
		System.out.println("Exiting method " + joinPoint.getSignature());
	}

	@After("execution(* com.demo.StudentController.getStudentById(..))")
	public void logAfterGetStudentById(JoinPoint joinPoint) {
		System.out.println("Exiting method getStudentById(), logged from method specific advice");
	}

	@AfterReturning("execution(* com.demo.StudentController.*(..))")
	public void logAfterNormalReturnAllMethods(JoinPoint joinPoint) {

		System.out.println(joinPoint.getSignature() + " executed successfully");
	}

	@AfterThrowing("execution(* com.demo.StudentController.*(..))")
	public void logAfterExceptionReturnAllMethods(JoinPoint joinPoint) {

		System.out.println(joinPoint.getSignature() + " threw an exception");
	}

}