package com.kitri.di.step08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MsDBConnetion implements DBConnection {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://192.168.12.100:1433;DatabaseName=dbname", "kitri",
				"kitri");
		return conn;
	}

}
