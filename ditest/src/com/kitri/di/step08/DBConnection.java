package com.kitri.di.step08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBConnection {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
