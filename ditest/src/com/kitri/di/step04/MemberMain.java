package com.kitri.di.step04;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client 부분*/
	/*
	 * Main 이 바뀌는 일이 없어 졌다.
	 * Dao가 바뀌는 일이 없어짐
	 * >Helper Class(DBConnection)가 생겨서 바뀌는 정보를 관리해 주는 Class가 생긴다. 
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new MemberDao();
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
	/*
	 *  Helper Class를 변경을 해줘야 하는 경우가 많이 생긴다.
	 * */
}
