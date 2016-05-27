package com.kitri.hello.spring4;

public class HelloServiceEng implements HelloService{

	@Override
	public String greeting(String name) {
		return "Hello " + name;
	}

}
