package com.kitri.haksa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.haksa.service.db.HaksaService;
import com.kitri.haksa.service.db.HaksaServiceImpl;

public class HaksaDBMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/haksa/config/applicationContext.xml");
		HaksaService hs = context.getBean("hservice", HaksaServiceImpl.class);
		hs.menu();
	}
}
