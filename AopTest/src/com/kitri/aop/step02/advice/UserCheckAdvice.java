package com.kitri.aop.step02.advice;

import org.aspectj.lang.JoinPoint;

public class UserCheckAdvice {
	/*������ɻ���*/
	public void userCheck(JoinPoint joinpoint){
		String signature = joinpoint.toString();
		System.out.println(signature);
	}
}