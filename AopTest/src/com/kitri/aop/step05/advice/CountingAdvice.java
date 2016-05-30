package com.kitri.aop.step05.advice;

import org.aspectj.lang.JoinPoint;

public class CountingAdvice {
	
	public void count(JoinPoint joinPoint){
		System.out.println(joinPoint.toShortString() + ": 무조건 실행");
	}
}
