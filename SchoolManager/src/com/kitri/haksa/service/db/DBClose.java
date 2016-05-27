package com.kitri.haksa.service.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		//�ڱ���� �ڱⰡ �༭ ���� ���̹Ƿ� static���� �ص� ������.
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
