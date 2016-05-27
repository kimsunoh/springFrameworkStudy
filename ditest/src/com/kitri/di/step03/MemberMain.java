package com.kitri.di.step03;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client 부분*/
	/*
	 * 핵심 구현체가 여러개 생긴다.
	 * 핵심 구현체가 계속 변경된다.
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new OraMemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId("ksno1234");
		memberDto.setName("김선오");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("입력 " + (cnt != 0 ? "성공!":"실패!!"));
		
		String sid = "ksno1234";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("이름 : " + sdto.getName());
			System.out.println("아이디 : " + sdto.getId());
			System.out.println("가입일 : " + sdto.getJoindate());			
		}
	}
}
