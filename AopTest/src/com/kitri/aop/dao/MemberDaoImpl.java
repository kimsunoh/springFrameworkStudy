package com.kitri.aop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.kitri.aop.model.MemberDto;

public class MemberDaoImpl implements MemberDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int registerMember(MemberDto memberDto) throws SQLException{
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		String sql = "insert into springtest(id, name, joindate)\n";
		sql += " values(?, ?, sysdate) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDto.getId());
		pstmt.setString(2, memberDto.getName());
		cnt = pstmt.executeUpdate();

		return cnt;
	}

	@Override
	public MemberDto getMember(String id)  throws SQLException{
		MemberDto memberDto = new MemberDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		String sql = "select * \n";
		sql += "from springtest \n";
		sql += "where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			memberDto.setId(id);
			memberDto.setJoindate(rs.getString("joindate"));
			memberDto.setName(rs.getString("name"));
		}
		
		return memberDto;
	}

	@Override
	public List<MemberDto> listMember()  throws SQLException{
		List<MemberDto> memberlist = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		String sql = "select * \n";
		sql += "from springtest \n";
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			MemberDto memberDto = new MemberDto();
			memberDto.setId(rs.getString("id"));
			memberDto.setJoindate(rs.getString("joindate"));
			memberDto.setName(rs.getString("name"));
			
			memberlist.add(memberDto);
		}
		
		return memberlist;
	}

}