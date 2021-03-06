package com.kitri.aop.step01.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformenceTraceAdvice {
	/* 성능확인 : 공통관심사 */
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		//sifnature : 수행한 메소드
//		String signature = joinPoint.getSignature().toLongString();
		String signature = joinPoint.getSignature().toShortString();
		/*여기서 하는 일은 수행시간 체크, 
		 * 1.현재시간체크
		 * 2.메소드 수행
		 * 3.현재시간
		 * 3-1 = 수행시간*/
		long startTime = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); //감싼 메소드를 실행해라
			return result;
		} finally {
			long endTime = System.nanoTime();
			System.out.println(signature + "실행시간:" + (endTime - startTime) + "ns");
		}
	}
}
