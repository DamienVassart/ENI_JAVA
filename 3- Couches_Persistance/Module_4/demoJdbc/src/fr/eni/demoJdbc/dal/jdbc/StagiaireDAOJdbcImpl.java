package fr.eni.demoJdbc.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demoJdbc.bo.Stagiaire;
import fr.eni.demoJdbc.dal.StagiaireDAO;

public class StagiaireDAOJdbcImpl implements StagiaireDAO {
	// Doit fournir les services pour gérer le cycle de vie
		// de l'objet stagiaire, c'est à dire permettre le
		// CRUD
	public void insert(Stagiaire s) {
		
	}
	
	public void update(Stagiaire s) {
		
	}
	
	public Stagiaire selectById(int noStagiaire) {
		return null;
	}
	
	public List<Stagiaire> selectAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		Connection connection = null;
		Statement stmt;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select idStagiaire, prenom, nom, email from stagiaires");
			Stagiaire s = null;
			while(rs.next()) {
				s = new Stagiaire(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				stagiaires.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stagiaires;
	}
	
	public void delete(Stagiaire s) {
		
	}
}
