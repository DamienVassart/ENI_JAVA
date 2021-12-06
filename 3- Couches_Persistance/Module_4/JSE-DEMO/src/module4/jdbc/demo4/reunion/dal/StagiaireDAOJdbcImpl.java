package module4.jdbc.demo4.reunion.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module4.jdbc.demo4.reunion.bo.Stagiaire;

public class StagiaireDAOJdbcImpl {
	
	String sqlInsert = "insert into stagiaires (prenom, nom, email, motDePasse) values (?, ?, ?, ?)";
	String sqlUpdate = "update stagiaires set (prenom, nom, email, motDePasse) values (?, ?, ?, ?) where id = ?";
	String sqlDelete = "delete from stagiaires where id = ?";
	String sqlDeleteById = "delete from stagiaires where id = ?";
	String sqlSelectById = "select idStagiaire, nom, prenom, email, motDePasse from stagiaires where id = ?";
	String sqlSelectAll = "select idStagiaire, nom, prenom, email, motDePasse from stagiaires";
	
	public void insert(Stagiaire s) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		//ResultSet keys = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlInsert);
			
			int index = 1;
			stmt.setString(index++, s.getPrenom());
			stmt.setString(index++, s.getNom());
			stmt.setString(index++, s.getEmail());
			stmt.setString(index++, s.getMotDePasse());
			stmt.execute();
		} catch (SQLException ex) {
			throw new DALException(ex);
		} finally {
			//JdbcTools.close(keys);
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}

	public void update(Stagiaire s) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlUpdate);
			
			int index = 1;
			stmt.setString(index++, s.getPrenom());
			stmt.setString(index++, s.getNom());
			stmt.setString(index++, s.getEmail());
			stmt.setString(index++, s.getMotDePasse());
			stmt.setInt(index++, s.getNoStagiaire());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DALException(ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}
	
	public void delete(Stagiaire s) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlDelete);
			
			stmt.setInt(1, s.getNoStagiaire());
			stmt.execute();
		} catch (SQLException ex) {
			throw new DALException(ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}
	
	public void deleteById(int idStagiaire) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlDeleteById);
			
			stmt.setInt(1, idStagiaire);
			stmt.execute();
			
		} catch (SQLException ex) {
			throw new DALException(ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}

	public Stagiaire selectById(int idStagiaire) throws DALException {
		Stagiaire s = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlSelectById);
			
			stmt.setInt(1, idStagiaire);
			stmt.execute();
		} catch (SQLException ex) {
			throw new DALException(ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
		
		return s;
	}

	public List<Stagiaire> selectAll() throws DALException{
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Stagiaire s = null;
			while(rs.next()) {
					s = new Stagiaire(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					stagiaires.add(s);
				} 
			} catch (SQLException ex) {
				throw new DALException(ex);
			} finally {
				JdbcTools.close(rs);
				JdbcTools.close(stmt);
				JdbcTools.close(connection);
			}
		
		return stagiaires;
	}
}
