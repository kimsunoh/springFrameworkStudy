package com.kitri.aop.step04.advice;

import org.aspectj.lang.JoinPoint;

public class ExceptionAdvice {
	public void exceptionInfo(JoinPoint joinPoint, Exception e){
		String signature = joinPoint.toShortString();
		System.out.println(signature + " : " + e);
	}
}