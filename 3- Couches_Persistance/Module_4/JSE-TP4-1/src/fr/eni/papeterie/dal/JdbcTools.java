package fr.eni.papeterie.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

	public static Connection getConnection() throws SQLException {
		Connection connection;
		String url = "jdbc:mysql://localhost:3306/papeterie_db";
		String user = "root";
		String password = "";
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
