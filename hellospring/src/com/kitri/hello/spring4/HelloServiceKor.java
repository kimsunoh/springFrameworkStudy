package com.kitri.hello.spring4;

public class HelloServiceKor implements HelloService{

	@Override
	public String greeting(String name) {
		return "�ȳ� " + name;
	}
	
}
