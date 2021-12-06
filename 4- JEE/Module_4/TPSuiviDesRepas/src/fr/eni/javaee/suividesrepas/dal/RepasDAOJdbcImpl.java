package fr.eni.javaee.suividesrepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {
	
	private static final String SQL_INSERT_REPAS = "INSERT INTO Repas (date, heure) VALUES (?, ?);";
	private static final String SQL_INSERT_ALIMENT = "INSERT INTO Aliments (nom, id_repas) VALUES (?, ?);";
	private static final String SQL_SELECT_ALL_REPAS = "SELECT "
													+ "r.id_repas, "
													+ "r.date_repas, "
													+ "r.heure_repas, "
													+ "a.nom "
													+ "FROM Repas r "
													+ "INNER JOIN Aliments a "
													+ "ON r.identifiant = a.id_repas "
													+ "ORDER BY r.date_repas DESC, r.heure_repas DESC;";

	@Override
	public void insert(Repas repas) throws BusinessException {
		if(repas == null) {
			BusinessException exNull = new BusinessException();
			exNull.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw exNull;
		}
		
		try (Connection cn = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement ps = cn.prepareStatement(SQL_INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setDate(1, java.sql.Date.valueOf(repas.getDate()));
				ps.setTime(2, java.sql.Time.valueOf(repas.getHeure()));
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next())
					repas.setIdentifiant(rs.getInt(1));
				rs.close();
				ps.close();
				
				ps = cn.prepareStatement(SQL_INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);
				for(Aliment a : repas.getListeAliments()) {
					ps.setString(1, a.getNom());
					ps.setInt(2, repas.getIdentifiant());
					ps.executeUpdate();
					rs = ps.getGeneratedKeys();
					if(rs.next())
						a.setIdentifiant(rs.getInt(1));
					rs.close();
				}
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
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
	public List<Repas> selectAll() throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL_REPAS);
			ResultSet rs = ps.executeQuery();
			Repas r = new Repas();
			
			while(rs.next()) {
				r.setIdentifiant(rs.getInt("id_repas"));
				r.setDate(rs.getDate("date_repas").toLocalDate());
				r.setHeure(rs.getTime("heure_repas").toLocalTime());
				listeRepas.add(r);
				
				Aliment a = new Aliment();
				a.setNom(rs.getString("nom"));
				r.getListeAliments().add(a);
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException exEchec = new BusinessException();
			exEchec.ajouterErreur(CodesResultatDAL.SELECT_REPAS_ECHEC);
			throw exEchec;
		}
		
		return listeRepas;
	}

}
