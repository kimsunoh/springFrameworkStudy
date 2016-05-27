package com.kitri.di.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	/*DB�� ������ �ٲ�� 10������ 10������ �����ؾ��Ѵ�.*/
	public int join(MemberDto memberDto) throws ClassNotFoundException, SQLException{
		int cnt = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl", "kitri", "kitri");
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
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl", "kitri", "kitri");
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
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId("ksno123");
		memberDto.setName("�輱��");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("�Է� " + (cnt != 0 ? "����!":"����!!"));
		
		String sid = "ksno123";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("�̸� : " + sdto.getName());
			System.out.println("���̵� : " + sdto.getId());
			System.out.println("������ : " + sdto.getJoindate());			
		}
	}
}