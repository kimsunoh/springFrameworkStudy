package com.kitri.aop.step02.advice;

import org.aspectj.lang.JoinPoint;

public class UserCheckAdvice {
	/*공통관심사항*/
	public void userCheck(JoinPoint joinpoint){
		String signature = joinpoint.toString();
		System.out.println(signature);
	}
}
