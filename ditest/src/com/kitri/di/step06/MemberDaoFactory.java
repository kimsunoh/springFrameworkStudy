package com.kitri.di.step06;

public class MemberDaoFactory {
	private MemberDao memberDao;
	
	public MemberDao getMemberDao(){
		memberDao = new MemberDao(getOraDBConnection());
		//DBConnection�� ���� Dao���� ��������
		return memberDao;
	}
	
	private DBConnection getOraDBConnection(){
		return new OraDBConnection();
	}

	private DBConnection getMSDBConnection(){
		return new MsDBConnetion();
	}
}