package fr.eni.javaee.gestionlistescourses.dal;

public class CodesResultatDAL {
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de la récupération des listes de courses
	 */
	public static final int SELECT_LISTES_COURSES_ECHEC=10002;
	
	/**
	 * Echec de la récupération d'une liste de courses
	 */
	public static final int SELECT_LISTE_COURSES_ECHEC=10003;
	
	/**
	 * Echec de la suppression d'une liste
	 */
	public static final int DELETE_LISTE_ECHEC=10004;
	
	/**
	 * Echec de la suppression d'un article
	 */
	public static final int DELETE_ARTICLE_ECHEC=10005;
	
	/**
	 * Impossible de cocher l'article
	 */
	public static final int CHECK_ARTICLE_ECHEC=10006;
	
	/**
	 * Impossible de décocher l'article
	 */
	public static final int UNCHECK_ARTICLE_ECHEC=10007;
}
