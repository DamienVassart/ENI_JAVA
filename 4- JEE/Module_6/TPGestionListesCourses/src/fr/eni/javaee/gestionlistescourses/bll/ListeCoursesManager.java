package fr.eni.javaee.gestionlistescourses.bll;

import java.util.List;

import fr.eni.javaee.gestionlistescourses.BusinessException;
import fr.eni.javaee.gestionlistescourses.bo.Article;
import fr.eni.javaee.gestionlistescourses.bo.ListeCourses;
import fr.eni.javaee.gestionlistescourses.dal.DAOFactory;
import fr.eni.javaee.gestionlistescourses.dal.ListeCoursesDAO;

public class ListeCoursesManager {
	private ListeCoursesDAO listeCoursesDAO;

	public ListeCoursesManager(ListeCoursesDAO listeCoursesDAO) throws BusinessException {
		super();
		this.listeCoursesDAO = DAOFactory.getListeCoursesDAO();
	}
	
	public List<ListeCourses> selectionnerListes() throws BusinessException {
		return this.listeCoursesDAO.selectAll();
	}
	
	public ListeCourses selectionnerListe(int idListe) throws BusinessException {
		return this.listeCoursesDAO.selectById(idListe);
	}
	
	public ListeCourses ajouterListe(String nomListe, String nomArticle) throws BusinessException {
		BusinessException ex = new BusinessException();
		ListeCourses listeCourses = null;
		this.validerNomListe(nomListe, ex);
		this.validerNomArticle(nomArticle, ex);
		if(!ex.hasErreur()) {
			listeCourses = new ListeCourses(nomArticle);
			listeCourses.setNom(nomListe);
			
			Article article = new Article();
			listeCourses.getArticles().add(article);
			
			this.listeCoursesDAO.insert(listeCourses);
		}
		if(ex.hasErreur())
			throw ex;
		
		return listeCourses;
	}
	
	public void ajouterArticle(int idListe, String nom) throws BusinessException {
		BusinessException ex = new BusinessException();
		this.validerNomArticle(nom, ex);
		if(!ex.hasErreur()) {
			ListeCourses listeCourses = new ListeCourses();
			listeCourses.setId(idListe);
			
			Article article = new Article();
			article.setNom(nom);
			this.listeCoursesDAO.insert(listeCourses);
		} else {
			throw ex;
		}
	}
	
	public void supprimerListe(int idListe) throws BusinessException {
		this.listeCoursesDAO.delete(idListe);
	}
	
	public void supprimerArticle(int idArticle) throws BusinessException {
		this.listeCoursesDAO.deleteArticle(idArticle);
	}
	
	public void cocherArticle(int idArticle) throws BusinessException {
		this.listeCoursesDAO.checkArticle(idArticle);
	}
	
	public void decocherArticle(int idArticle) throws BusinessException {
		this.listeCoursesDAO.uncheckArticle(idArticle);
	}
	
	
	private void validerNomListe(String nom, BusinessException ex) {
		if(nom == null || nom.trim().equals("") || nom.trim().length() > 50)
			ex.ajouterErreur(CodesResultatBLL.REGLE_LISTE_ERREUR_NOM);
	}
	
	private void validerNomArticle(String nom, BusinessException ex) {
		if(nom == null || nom.trim().equals("") || nom.trim().length() > 50)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_ERREUR_NOM);
	}
}
