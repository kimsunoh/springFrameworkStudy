package com.kitri.di.step03;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client �κ�*/
	/*
	 * �ٽ� ����ü�� ������ �����.
	 * �ٽ� ����ü�� ��� ����ȴ�.
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new OraMemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId("ksno1234");
		memberDto.setName("�輱��");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("�Է� " + (cnt != 0 ? "����!":"����!!"));
		
		String sid = "ksno1234";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("�̸� : " + sdto.getName());
			System.out.println("���̵� : " + sdto.getId());
			System.out.println("������ : " + sdto.getJoindate());			
		}
	}
}
