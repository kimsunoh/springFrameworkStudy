package com.kitri.di.step09;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client 부분*/ //Spring
	/*
	 * 
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/di/step09/applicationContext.xml");
		MemberDao memberDao = context.getBean("mdao", MemberDao.class);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId("ksno123");
		memberDto.setName("김선오");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("입력 " + (cnt != 0 ? "성공!":"실패!!"));
		
		String sid = "ksno123";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("이름 : " + sdto.getName());
			System.out.println("아이디 : " + sdto.getId());
			System.out.println("가입일 : " + sdto.getJoindate());			
		}
	}
}
