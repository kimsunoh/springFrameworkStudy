package com.kitri.hello.spring3;

public class HelloServiceFactory {
	private static HelloService helloServiceKor;
	private static HelloService helloServiceEng;
	
	static{
		helloServiceKor = new HelloServiceKor();
		helloServiceEng = new HelloServiceEng();
	}
	
	private HelloServiceFactory (){}

	public static HelloService getHelloServiceKor() {
		return helloServiceKor;
	}

	public static HelloService getHelloServiceEng() {
		return helloServiceEng;
	}
}