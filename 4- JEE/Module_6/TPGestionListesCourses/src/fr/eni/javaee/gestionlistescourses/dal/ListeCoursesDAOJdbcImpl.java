package fr.eni.javaee.gestionlistescourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.gestionlistescourses.BusinessException;
import fr.eni.javaee.gestionlistescourses.bo.Article;
import fr.eni.javaee.gestionlistescourses.bo.ListeCourses;

public class ListeCoursesDAOJdbcImpl implements ListeCoursesDAO {
	
	private static final String SQL_INSERT_LISTE = "INSERT INTO Listes (nom) VALUES (?);";
	private static final String SQL_DELETE_LISTE = "DELETE FROM Listes WHERE id = ?;";
	private static final String SQL_SELECT_ALL_LISTES = "SELECT (id, nom) FROM Listes;";
	private static final String SQL_SELECT_LISTE_BY_ID = "SELECT l.id AS id_liste, l.nom AS nom_liste, a.id AS id_article, a.nom AS nom_article, a.coche FROM Listes l LEFT JOIN Articles a ON l.id = a.id_liste WHERE l.id = ?;";
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO Articles (nom, id_liste) VALUES (?, ?);";
	private static final String SQL_DELETE_ARTICLE = "DELETE FROM Articles WHERE id = ?;";
	private static final String SQL_CHECK_ARTICLE = "UPDATE Articles SET coche = 1 WHERE id = ?;";
	private static final String SQL_UNCHECK_ARTICLE = "UPDATE Articles SET coche = 0 WHERE id = ?;";

	@Override
	public void insert(ListeCourses listeCourses) throws BusinessException {
		if (listeCourses == null) {
			BusinessException exNull = new BusinessException();
			exNull.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw exNull;
		}
		
		try (Connection cn = ConnectionProvider.getConnection()) {
			try {
				cn.setAutoCommit(false);
				PreparedStatement ps;
				ResultSet rs;
				
				ps = cn.prepareStatement(SQL_INSERT_LISTE, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, listeCourses.getNom());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if(rs.next())
					listeCourses.setId(rs.getInt(1));
				rs.close();
				ps.close();
				
				if(listeCourses.getArticles().size() == 1) {
					ps = cn.prepareStatement(SQL_INSERT_ARTICLE);
					ps.setString(1, listeCourses.getArticles().get(0).getNom());
					ps.setInt(2, listeCourses.getId());
					ps.executeUpdate();
					ps.close();
				}
				cn.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				cn.rollback();
				throw ex;
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw exEchec;
		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_DELETE_LISTE);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.DELETE_LISTE_ECHEC);
			throw exEchec;
		}
	}

	@Override
	public List<ListeCourses> selectAll() throws BusinessException {
		List<ListeCourses> listesCourses = new ArrayList<>();
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL_LISTES);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listesCourses.add(new ListeCourses(rs.getInt("id"), rs.getString("nom")));
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.SELECT_LISTES_COURSES_ECHEC);
			throw exEchec;
		}
		return listesCourses;
	}

	@Override
	public ListeCourses selectById(int id) throws BusinessException {
		ListeCourses listeCourses = new ListeCourses();
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_LISTE_BY_ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				listeCourses.setId(rs.getInt("id_liste"));
				listeCourses.setNom(rs.getString("nom_liste"));
				if(rs.getString("nom_article") != null)
					listeCourses.getArticles().add(new Article(rs.getInt("id_article"), rs.getString("nom_article"), rs.getBoolean("coche")));
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.SELECT_LISTE_COURSES_ECHEC);
			throw exEchec;
		}
		return listeCourses;
	}

	@Override
	public void deleteArticle(int idArticle) throws BusinessException {
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_DELETE_ARTICLE);
			ps.setInt(1, idArticle);
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.DELETE_ARTICLE_ECHEC);
			throw exEchec;
		}
	}

	@Override
	public void checkArticle(int idArticle) throws BusinessException {
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_CHECK_ARTICLE);
			ps.setInt(1, idArticle);
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.CHECK_ARTICLE_ECHEC);
			throw exEchec;
		}
	}

	@Override
	public void uncheckArticle(int idArticle) throws BusinessException {
		try(Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_UNCHECK_ARTICLE);
			ps.setInt(1, idArticle);
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.UNCHECK_ARTICLE_ECHEC);
			throw exEchec;
		}
	}
	
}
