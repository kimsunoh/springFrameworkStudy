package com.kitri.member.model;

import java.util.List;

public interface MemberService {
	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int register(MemberDto memberDto);
	
	
	MemberDto getMember(String id);
	int modify(MemberDto memberDto);
	int delete(String id);
	
	MemberDto login(String id, String pass);
}
