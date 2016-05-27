package com.kitri.hello.spring2;

public class HelloApp {
	
	/*
	 * 1번에 비해서는 느슨한 결합, 하지만 여전히 생성시 호출하는 클래스가 바뀌어야만 가능하다.
	 * */
	public static void main(String[] args) {
		HelloService hello = new HelloServiceKor();
//		HelloService hello = new HelloServiceEng();

		String greet = hello.greeting("Kim");
		
		System.out.println(greet);
	}
}