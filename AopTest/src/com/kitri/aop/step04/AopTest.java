package com.kitri.aop.step04;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.aop.controller.MemberController;
import com.kitri.aop.model.MemberDto;

public class AopTest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/kitri/aop/step04/config/applicationContext.xml");
		MemberController control = context.getBean("mcontrol", MemberController.class);

		String id = "ksno";
		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);
		memberDto.setName("����");
		
		int cnt = control.registerMember(memberDto);
		System.out.println("��� " + (cnt != 0 ? "����" : "����!" ));
		
		MemberDto sdto = control.getMember(id);
		System.out.println("======>�˻� ���<=======");
		if(sdto != null)
			System.out.println(sdto);
		else
			System.out.println(id + "�� �������� �ʽ��ϴ�.");
		
		List<MemberDto> list = control.listMember();
		System.out.println("======>��ü ȸ�� ���<=======");
		for(MemberDto lDto : list){
			System.out.println(lDto);
		}
	}
}