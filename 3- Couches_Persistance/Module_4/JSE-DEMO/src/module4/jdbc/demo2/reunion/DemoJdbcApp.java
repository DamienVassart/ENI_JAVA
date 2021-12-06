package module4.jdbc.demo2.reunion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbcApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;

		try {

			// Obtenir une connexion
			String url = "jdbc:mysql://localhost:3306/eval_db";
			String user = "root";
			String password = "";
			connection = DriverManager.getConnection(url, user, password);

			// Créer une requête
			stmt = connection.createStatement();

			// Executer une requête
			ResultSet rs = stmt.executeQuery("select prenom, nom, email from stagiaires");
			
			while(rs.next()){
				System.out.println(rs.getString("prenom")+"-"+ rs.getString("nom")+" -"+ rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				// Fermer la connexion
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}