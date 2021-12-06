package fr.eni.demoJdbc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			String url = Settings.getProperty("url");
			String user = Settings.getProperty("user");
			String password = Settings.getProperty("password");
			// Obtenir une connexion
			connection = DriverManager.getConnection(url, user, password);
			
			// Créer un statement
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select prenom, nom, email from stagiaires");
			while(rs.next()) {
				System.out.println(rs.getString("prenom") + " " + rs.getString("nom") + " " + rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
