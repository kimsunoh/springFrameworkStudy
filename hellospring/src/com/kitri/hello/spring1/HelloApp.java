package com.kitri.hello.spring1;

public class HelloApp {

	public static void main(String[] args) {
//		HelloServiceKor helloKor = new HelloServiceKor();
//		String greet = helloKor.greetingKor("�輱��");

		HelloServiceEng helloEng = new HelloServiceEng();
		String greet = helloEng.greetingEng("�輱��");
		
		System.out.println(greet);
		
		/*������ �ٸ� ����� ���� �༮�� ȣ���Ҷ� ��ü�ҽ��� ��ȯ�ؾ��ϴ� ������ �����.
		 * ���Ѱ��տ� ���� ���� �߻�*/
	}
}