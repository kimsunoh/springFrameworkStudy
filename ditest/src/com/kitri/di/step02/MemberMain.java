package com.kitri.di.step02;

import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain { /*Client 부분*/
	/*드라이버 로딩이 여러개가 되면(Oracle, MisoSql 등)문제가 생긴다*/
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
}
