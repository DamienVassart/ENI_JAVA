package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {
	
	private static ArticleDAO daoArticle;
	
	public CatalogueManager() throws BLLException {
		daoArticle = DAOFactory.getArticleDAO();
	}
	
	/**
	 * Indique si un article est valide pour une insertion ou une modification
	 * @param a L'article à valider
	 * @throws BLLException
	 */
	public void validerArticle(Article a) throws BLLException {
		
		StringBuffer msgErr = new StringBuffer();
		boolean valide = true;
		
		if(a.getReference() == null)
		{
			valide = false;
			msgErr.append("La référence doit être spécifiée\n");
		}
		if(a.getMarque() == null) {
			valide = false;
			msgErr.append("La marque doit être spécifiée\n");
		}
		if(a.getDesignation() == null) {
			valide = false;
			msgErr.append("La désignation doit être spécifiée\n");
		}
		if(a.getPrixUnitaire() <= 0) {
			valide = false;
			msgErr.append("Le prix unitaire doit être une valeur positive\n");
		}
		if(a.getQteStock() <= 0) {
			valide = false;
			msgErr.append("La quantité doit être une valeur positive\n");
		}

		if(a instanceof Ramette) {
			Ramette r = (Ramette) a;
			if(r.getGrammage() < 0) {
				valide = false;
				msgErr.append("Le grammage doit être une valeur positive\n");
			}
		}
		if(a instanceof Stylo) {
			Stylo s = (Stylo) a;
			if(s.getCouleur() == null) {
				valide = false;
				msgErr.append("La couleur doit être spécifiée\n");
			} 
		}
		
		if(!valide)
			throw new BLLException(msgErr.toString());
	}
	
	public void addArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.insert(a);
		} catch (DALException ex) {
			throw new BLLException("L'article n'a pas pu être inséré", ex);
		}
	}
	
	public void updateArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.update(a);
		} catch (DALException ex) {
			throw new BLLException("L'article n'a pas pu être modifié", ex);
		}
	}
	
	public void removeArticle(Article a) throws BLLException {
		int idArticle = a.getIdArticle();
		try {
			daoArticle.delete(idArticle);
		} catch (DALException ex) {
			throw new BLLException("L'article n'a pas pu être supprimé", ex);
		}
	}
	
	public List<Article> getCatalogue() throws BLLException {
		List<Article> listeArticles = null;
		try {
			listeArticles = daoArticle.selectAll();
		} catch (DALException ex) {
			throw new BLLException("La catalogue n'a pas pu être récupéré", ex);
		}
		return listeArticles;
	}
	
	public Article getArticle(int idArticle) throws BLLException {
		Article a = null;
		try {
			a = daoArticle.selectById(idArticle);
		} catch (DALException ex) {
			throw new BLLException("L'article n'a pas pu être récupéré", ex);
		}
		return a;
	}

}
