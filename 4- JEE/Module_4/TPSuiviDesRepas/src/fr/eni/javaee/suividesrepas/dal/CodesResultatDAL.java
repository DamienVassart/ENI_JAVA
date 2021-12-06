package fr.eni.javaee.suividesrepas.dal;

public abstract class CodesResultatDAL {
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de la récupération de la liste des repas
	 */
	public static final int SELECT_REPAS_ECHEC=10002;
	
}
