package fr.eni.demoJdbc.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.demoJdbc.dal.Settings;

public class JdbcTools {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"), Settings.getProperty("password"));
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
	
}