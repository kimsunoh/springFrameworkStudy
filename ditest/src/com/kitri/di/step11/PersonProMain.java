package com.kitri.di.step11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonProMain {

	public static void main(String[] args) {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("com/kitri/di/step11/applicationContext_pro.xml");
		Person p1 = context1.getBean("p1",Person.class);
		System.out.println("======p1=====");
		System.out.println(p1);
		
		Person p2 = context1.getBean("p2",Person.class);
		System.out.println("======p2=====");
		System.out.println(p2);

		Person p3 = context1.getBean("p3",Person.class);
		System.out.println("======p3=====");
		System.out.println(p3);

		Person p4 = context1.getBean("p4",Person.class);
		System.out.println("======p4=====");
		System.out.println(p4);

		Person p5 = context1.getBean("p5",Person.class);
		System.out.println("======p5=====");
		System.out.println(p5);
		
		Person p6 = context1.getBean("p6",Person.class);
		System.out.println("======p6=====");
		System.out.println(p6);
		
		Person p7 = context1.getBean("p7",Person.class);
		System.out.println("======p7=====");
		System.out.println(p7);
		
		Person p8 = context1.getBean("p8",Person.class);
		System.out.println("======p8=====");
		System.out.println(p8);

		Person p9 = context1.getBean("p9",Person.class);
		System.out.println("======p9=====");
		System.out.println(p9);
	}

}
