package com.kitri.di.step05;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client �κ�*/
	/*
	 * Ŭ���̾�Ʈ ������ � DB�� ������� ���ؼ� �Ѱ���. (Interface�� �����ؼ� �Ѱ��ָ� MsDBConnection�� �Ѱ��൵ ��)
	 * �������� �ƹ��͵� �ȹٲ��� �ǰ� ��
	 * */
	
	/* 
	 * DBConnection�� �ʿ��� ���� ��������, ��ü�� �����ϴ� ���� Ŭ���̾�Ʈ, 
	 * Ŭ���̾�Ʈ�� �������� �������� �����Ѵ�.
	 * */ 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnection dbc = new OraDBConnection();
		MemberDao memberDao = new MemberDao(dbc);
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
	/*
	 * Main�� �ٲ�� ���� �߻�
	 * */
}