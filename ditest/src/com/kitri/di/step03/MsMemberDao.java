package com.kitri.di.step03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MsMemberDao extends MemberDao{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.misrosoft.jdbc.sqlserver.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.12.100:1433;DatabaseName=dbname", "kitri", "kitri");
		return conn;
	}	
}