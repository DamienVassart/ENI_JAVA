package module4.jdbc.demo1.reunion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demoJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/eval_db";
			String user = "root";
			String password = "";
			
			connection = DriverManager.getConnection(url, user, password);
			
			stmt = connection.createStatement();
			
			String sql = "select idStagiaire, nom, prenom, email from stagiaires";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			StringBuffer msg;
			
			while(rs.next()) {
				msg = new StringBuffer();
				msg.append("idStagiaire: ");
				msg.append(rs.getInt("idStagiaire"));
				msg.append(", prénom: ");
				msg.append(rs.getString("prenom"));
				msg.append(", nom: ");
				msg.append(rs.getString("nom"));
				msg.append(", email: ");
				msg.append(rs.getString("email"));
				System.out.println(msg.toString());
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
