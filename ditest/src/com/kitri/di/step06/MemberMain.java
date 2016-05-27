package com.kitri.di.step06;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client 부분*/
	/*
	 * Main에서 생성하던 것을 밖으로 뺌
	 * Oracle에서 MS로 바뀔때 Factory만 수정해 주면 됨. 
	 * Main이 바뀌는 일이 없음
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDaoFactory factory = new MemberDaoFactory();
		MemberDao memberDao = factory.getMemberDao();
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
