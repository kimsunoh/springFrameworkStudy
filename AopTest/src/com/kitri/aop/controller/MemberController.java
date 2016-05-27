package com.kitri.aop.controller;

import java.sql.SQLException;
import java.util.List;

import com.kitri.aop.model.MemberDto;
import com.kitri.aop.service.MemberService;

public class MemberController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public int registerMember(MemberDto memberDto) throws SQLException {
		return memberService.registerMember(memberDto);
	}

	public MemberDto getMember(String id) throws SQLException {
		return memberService.getMember(id);
	}

	public List<MemberDto> listMember() throws SQLException {
		return memberService.listMember();
	}
}
