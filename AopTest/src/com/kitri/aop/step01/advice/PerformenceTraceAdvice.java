package com.kitri.aop.step01.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformenceTraceAdvice {
	/* ����Ȯ�� : ������ɻ� */
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		//sifnature : ������ �޼ҵ�
//		String signature = joinPoint.getSignature().toLongString();
		String signature = joinPoint.getSignature().toShortString();
		/*���⼭ �ϴ� ���� ����ð� üũ, 
		 * 1.����ð�üũ
		 * 2.�޼ҵ� ����
		 * 3.����ð�
		 * 3-1 = ����ð�*/
		long startTime = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); //���� �޼ҵ带 �����ض�
			return result;
		} finally {
			long endTime = System.nanoTime();
			System.out.println(signature + "����ð�:" + (endTime - startTime) + "ns");
		}
	}
}
