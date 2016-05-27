package com.kitri.aop.dao;

import java.sql.SQLException;
import java.util.List;

import com.kitri.aop.model.MemberDto;

public interface MemberDao {
	int registerMember(MemberDto memberDto) throws SQLException;
	MemberDto getMember(String id) throws SQLException;
	List<MemberDto> listMember() throws SQLException;
}
