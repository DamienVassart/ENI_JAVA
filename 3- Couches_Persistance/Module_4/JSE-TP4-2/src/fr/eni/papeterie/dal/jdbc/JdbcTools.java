package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.papeterie.dal.Settings;

public class JdbcTools {
	
	public static Connection getConnection() throws SQLException {
		Connection connection;
		String url = Settings.getProperty("url");
		String user = Settings.getProperty("user");
		String password = Settings.getProperty("password");
		
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	public static void close(AutoCloseable resource) {
		if(resource != null) {
			try {
				resource.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
