package com.kitri.hello.spring2;

public class HelloApp {
	
	/*
	 * 1���� ���ؼ��� ������ ����, ������ ������ ������ ȣ���ϴ� Ŭ������ �ٲ��߸� �����ϴ�.
	 * */
	public static void main(String[] args) {
		HelloService hello = new HelloServiceKor();
//		HelloService hello = new HelloServiceEng();

		String greet = hello.greeting("Kim");
		
		System.out.println(greet);
	}
}