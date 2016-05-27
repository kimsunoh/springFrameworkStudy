package com.kitri.hello.spring2;

public class HelloServiceEng implements HelloService{

	@Override
	public String greeting(String name) {
		return "Hello " + name;
	}

}
