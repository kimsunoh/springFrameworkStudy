package com.kitri.di.step10;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client �κ�*/ //step09�� annotation����
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String id = "ksno123";
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberDaoFactory.class);
		MemberDao memberDao = context.getBean("mdao", MemberDao.class);
		MemberDao memberDao2 = context.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao + "\t" + memberDao2);
		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);
		memberDto.setName("�輱��");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("�Է� " + (cnt != 0 ? "����!":"����!!"));
		
		String sid = id;
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("�̸� : " + sdto.getName());
			System.out.println("���̵� : " + sdto.getId());
			System.out.println("������ : " + sdto.getJoindate());			
		}
	}
}