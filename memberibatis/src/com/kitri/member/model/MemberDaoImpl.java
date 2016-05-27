package com.kitri.member.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kitri.ibatis.SqlMapConfig;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		try {
			return (int) SqlMapConfig.getSqlMapClient().queryForObject("mb.idcount", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;	/*idcheck니깐 id가 있으면 1을 return, id를 사용하지 못하게 하려고*/
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		try {
			return (List<ZipDto>) SqlMapConfig.getSqlMapClient().queryForList("mb.searchdong", dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int register(MemberDto memberDto) {
		try {
			return SqlMapConfig.getSqlMapClient().update("mb.register",memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
	public MemberDto login(Map<String, String> map) {
		try {
			return (MemberDto) SqlMapConfig.getSqlMapClient().queryForObject("lg.login", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
