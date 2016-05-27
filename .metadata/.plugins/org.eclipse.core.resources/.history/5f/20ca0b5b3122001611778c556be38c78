package com.kitri.di.step06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraDBConnection implements DBConnection {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl", "kitri", "kitri");		
	}

}
