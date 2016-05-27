package com.kitri.di.step02;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client �κ�*/
	/*����̹� �ε��� �������� �Ǹ�(Oracle, MisoSql ��)������ �����*/
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new MemberDao();
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
