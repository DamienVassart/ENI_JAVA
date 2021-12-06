package module4.jdbc.demo1.reunion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection ok");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}

}
