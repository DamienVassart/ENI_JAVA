package fr.eni.javaee.suividesrepas.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;
import fr.eni.javaee.suividesrepas.dal.DAOFactory;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;


/**
 * 
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class RepasManager {
	private RepasDAO repasDAO;
	
	public RepasManager() {
		super();
		this.repasDAO = DAOFactory.getRepasDAO();
	}
	
	public Repas ajouter(LocalDate date, LocalTime heure, List<String> listeAliments) throws BusinessException {
		BusinessException ex = new BusinessException();
		Repas repas = null;
		
		this.validerHorodatage(date, heure, ex);
		this.validerRepas(listeAliments, ex);
		
		if(!ex.hasErreur()) {
			repas = new Repas();
			repas.setDate(date);
			repas.setHeure(heure);
			for(String aliment : listeAliments) {
				repas.getListeAliments().add(new Aliment(aliment));
			}
			this.repasDAO.insert(repas);
		}
		if(ex.hasErreur())
			throw ex;
		
		return repas;
	}
	
	public List<Repas> selectionnerTousLesRepas() throws BusinessException {
		return this.repasDAO.selectAll();
	}
	
	private void validerHorodatage(LocalDate date, LocalTime heure, BusinessException ex) {
		if(date.isAfter(LocalDate.now()) || (date.isEqual(LocalDate.now()) && heure.isAfter(LocalTime.now())))
			ex.ajouterErreur(CodesResultatBLL.REGLE_DATE_ERREUR);
	}

	private void validerRepas(List<String> listeAliments, BusinessException ex) {
		if(listeAliments == null || listeAliments.size() == 0)
			ex.ajouterErreur(CodesResultatBLL.REGLE_LISTE_ALIMENTS_ERREUR);
	}
	
}
