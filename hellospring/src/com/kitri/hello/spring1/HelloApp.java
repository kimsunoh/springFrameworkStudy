package com.kitri.hello.spring1;

public class HelloApp {

	public static void main(String[] args) {
//		HelloServiceKor helloKor = new HelloServiceKor();
//		String greet = helloKor.greetingKor("김선오");

		HelloServiceEng helloEng = new HelloServiceEng();
		String greet = helloEng.greetingEng("김선오");
		
		System.out.println(greet);
		
		/*같지만 다른 기능을 쓰는 녀석을 호출할때 전체소스를 변환해야하는 문제가 생긴다.
		 * 강한결합에 의한 문제 발생*/
	}
}
