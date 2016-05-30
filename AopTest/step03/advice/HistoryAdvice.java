package com.kitri.aop.step03.advice;

public class HistoryAdvice {
	
	public void history(Object ret) {
		System.out.println("history : " + ret);
	}
}
