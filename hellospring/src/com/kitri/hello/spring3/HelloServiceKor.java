package com.kitri.hello.spring3;

public class HelloServiceKor implements HelloService{

	@Override
	public String greeting(String name) {
		return "¾È³ç " + name;
	}
	
}
