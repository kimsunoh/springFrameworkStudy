package com.kitri.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
	
	MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public int idCheck(String id) {
		return memberDao.idCheck(id);
	}
	
	@Override
	public List<ZipDto> zipSearch(String dong) {
		return memberDao.zipSearch(dong);
	}
	
	@Override
	public int register(MemberDto memberDto) {
		return memberDao.register(memberDto);
	}
	
	@Override
	public MemberDto getMember(String id) {
		return null;
	}
	
	@Override
	public int modify(MemberDto memberDto) {
		return 0;
	}
	
	@Override
	public int delete(String id) {
		return 0;
	}
	
	@Override
	public MemberDto login(String id, String pass) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return memberDao.login(map);
	}
}
