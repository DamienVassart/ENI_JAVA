package module4.jdbc.demo4.reunion.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JdbcTools {

	static Connection getConnection() throws SQLException {
		Connection connection;
		String url = "jdbc:mysql://localhost:3306/eval_db";
		String user = "root";
		String password = "";
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	static void close(AutoCloseable resource) {
		if(resource != null) {
			try {
				resource.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
