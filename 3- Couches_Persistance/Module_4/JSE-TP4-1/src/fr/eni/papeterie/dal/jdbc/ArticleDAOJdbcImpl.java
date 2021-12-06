package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.JdbcTools;

/**
 * @author Damien Vassart
 * @version 1.0
 * 
 */
public class ArticleDAOJdbcImpl {
	
	// Constantes pour les types d'articles
	private static final String RAMETTE = "RAMETTE";
	private static final String STYLO = "STYLO";
	
	// Requêtes SQL
	private String sqlSelectById = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM Articles WHERE idArticle = ?";
	private String sqlSelectAll = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM Articles";
	private String sqlUpdate = "UPDATE Articles SET reference = ?, marque = ?, designation = ?, prixUnitaire = ?, qteStock = ?, grammage = ?, couleur = ? WHERE idArticle = ?";
	private String sqlInsert = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private String sqlDelete = "DELETE FROM Articles WHERE idArticle = ?";
	
	/**
	 * Renvoie un article séléctionné d'après son identifiant (idArticle)
	 * @param idArticle
	 * @return un article
	 * @throws DALException
	 */
	public Article selectById(int idArticle) throws DALException {
		Article a = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlSelectById);
			
			stmt.setInt(1, idArticle);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String typeArticle = rs.getString(9);
				switch(typeArticle) {
					case RAMETTE:
						a = new Ramette(rs.getInt(1), 
								rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getFloat(5), rs.getInt(6), 
								rs.getInt(7));
						break;
					case STYLO:
						a = new Stylo(rs.getInt(1), 
								rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getFloat(5), rs.getInt(6), 
								rs.getString(8));
						break;
				}
			}
		} catch (SQLException ex) {
			throw new DALException("La requête a échoué", ex);
		} finally {
			JdbcTools.close(rs);
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
		
		return a;
	}
	
	/**
	 * Renvoie la liste de tous les articles
	 * @return Une liste d'articles
	 * @throws DALException
	 */
	public List<Article> selectAll() throws DALException {
		List<Article> listeArticles = new ArrayList<Article>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			
			Article a = null;
			while(rs.next()) {
				String typeArticle = rs.getString(9);
				switch(typeArticle) {
					case RAMETTE:
						a = new Ramette(rs.getInt(1), 
								rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getFloat(5), rs.getInt(6), 
								rs.getInt(7));
						break;
					case STYLO:
						a = new Stylo(rs.getInt(1), 
								rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getFloat(5), rs.getInt(6), 
								rs.getString(8));
						break;
			}
				
				listeArticles.add(a);
			}
			
		} catch (SQLException ex) {
			throw new DALException("La requête a échoué", ex);
		} finally {
			JdbcTools.close(rs);
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
		
		return listeArticles;
	}
	
	/**
	 * Met à jour les données d'un article
	 * @param a L'article à mettre à jour
	 * @throws DALException
	 */
	public void update(Article a) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlUpdate);
			
			int index = 1;
			
			stmt.setString(index++, a.getReference());
			stmt.setString(index++, a.getMarque());
			stmt.setString(index++, a.getDesignation());
			stmt.setFloat(index++, a.getPrixUnitaire());
			stmt.setInt(index++, a.getQteStock());
			
			if(a instanceof Ramette) {
				Ramette r = (Ramette) a;
				stmt.setInt(index++, r.getGrammage());
				stmt.setNull(index++, Types.VARCHAR);
			}
			if(a instanceof Stylo) {
				Stylo s = (Stylo) a;
				stmt.setNull(index++, Types.INTEGER);
				stmt.setString(index++, s.getCouleur());
			}
			
			stmt.setInt(index++, a.getIdArticle());
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new DALException("L'article n'a pas pu être modifié", ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}
	
	/**
	 * Insère un nouvel article dans la table Articles
	 * @param a Un nouvel article
	 * @throws DALException
	 */
	public void insert(Article a) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			int index = 1;
			
			stmt.setString(index++, a.getReference());
			stmt.setString(index++, a.getMarque());
			stmt.setString(index++, a.getDesignation());
			stmt.setFloat(index++, a.getPrixUnitaire());
			stmt.setInt(index++, a.getQteStock());
			
			if(a instanceof Ramette) {
				Ramette r = (Ramette) a;
				stmt.setInt(index++, r.getGrammage());
				stmt.setNull(index++, Types.VARCHAR);
				stmt.setString(index++, RAMETTE);
			}
			if(a instanceof Stylo) {
				Stylo s = (Stylo) a;
				stmt.setNull(index++, Types.INTEGER);
				stmt.setString(index++, s.getCouleur());
				stmt.setString(index++, STYLO);
			}
			
			int nbRows = stmt.executeUpdate();
			if(nbRows == 1) {
				rs = stmt.getGeneratedKeys();
				if(rs.next())
					a.setIdArticle(rs.getInt(1));
			}
			
		} catch (SQLException ex) {
			throw new DALException("L'article n'a pas pu être ajouté", ex);
		} finally {
			JdbcTools.close(rs);
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
	}
	
	/**
	 * Supprime un article de la table Articles
	 * @param idArticle L'identifiant de l'article à supprimer
	 * @throws DALException
	 */
	public void delete(int idArticle) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = JdbcTools.getConnection();
			stmt = connection.prepareStatement(sqlDelete);
			
			stmt.setInt(1, idArticle);
			stmt.execute();
		} catch (SQLException ex) {
			throw new DALException("L'article n'a pas pu être supprimé", ex);
		} finally {
			JdbcTools.close(stmt);
			JdbcTools.close(connection);
		}
		
	}

}
