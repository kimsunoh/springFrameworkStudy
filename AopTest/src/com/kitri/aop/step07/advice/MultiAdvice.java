package com.kitri.aop.step07.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MultiAdvice {
	
	public void count(JoinPoint joinPoint){
		System.out.println("after " + joinPoint.toShortString() + ": 무조건 실행");
	}
	
	public void exceptionInfo(JoinPoint joinPoint, Exception e){
		String signature = joinPoint.toShortString();
		System.out.println("after throwing >>" + signature + " : " + e);
	}
	
	public void history(Object ret) {
		System.out.println("after returning : " + ret);
	}
	
	public void userCheck(JoinPoint joinpoint){
		String signature = joinpoint.toString();
		System.out.println("before : " + signature);
	}
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signature = joinPoint.getSignature().toShortString();
		long startTime = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long endTime = System.nanoTime();
			System.out.println(signature + "실행시간:" + (endTime - startTime) + "ns");
		}
	}
}
