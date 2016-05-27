package com.kitri.di.step09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	/* 
	 * 서버쪽 부분
	 *  */
	private DataSource dataSource;
	
	public MemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int join(MemberDto memberDto) throws ClassNotFoundException, SQLException{
		int cnt = 0;
		Connection conn = dataSource.getConnection();
		String sql = "insert into springtest(id, name, joindate)\n";
		sql += " values(?, ?, sysdate) ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDto.getId());
		pstmt.setString(2, memberDto.getName());
		cnt = pstmt.executeUpdate();

		return cnt;
	}
	
	public MemberDto search(String id) throws ClassNotFoundException, SQLException{
		MemberDto memberDto = new MemberDto();
		Connection conn = dataSource.getConnection();
		String sql = "select * \n";
		sql += "from springtest \n";
		sql += "where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			memberDto.setId(id);
			memberDto.setJoindate(rs.getString("joindate"));
			memberDto.setName(rs.getString("name"));
		}
		
		return memberDto;
	}
}
