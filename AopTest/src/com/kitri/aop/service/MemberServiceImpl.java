package com.kitri.aop.service;

import java.sql.SQLException;
import java.util.List;

import com.kitri.aop.dao.MemberDao;
import com.kitri.aop.model.MemberDto;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) throws SQLException{
		this.memberDao = memberDao;
	}

	@Override
	public int registerMember(MemberDto memberDto) throws SQLException {
		return memberDao.registerMember(memberDto);
	}

	@Override
	public MemberDto getMember(String id) throws SQLException {
		return memberDao.getMember(id);
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		return memberDao.listMember();
	}

}
