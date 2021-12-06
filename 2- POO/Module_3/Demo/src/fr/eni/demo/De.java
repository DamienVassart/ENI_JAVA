package fr.eni.demo;

import java.util.Random;

/**
 * Classe modélisant un dé à jouer
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class De {
	private int nbFaces;
	private int faceTiree;
	private static Random rand = new Random();

	/**
	 * Constructeur créant une instance de De dont le nombre de faces est passé en paramètre
	 * @param nbFaces nombre de faces à utiliser pour le dé à créer
	 * @throws Exception si le nombre de faces {@code nbFaces} est inférieur à 2
	 */
	public De(int nbFaces) throws Exception {
		this.setNbFaces(nbFaces);
		this.lancer();
	}
	
	
	/**
	 * Constructeur créant une instance de De à 6 faces
	 * @throws Exception ne doit pas être levée
	 */
	public De() throws Exception {
		this(6);
	}

	/**
	 * Lance le dé et retourne la face tirée aléatoirement
	 * @return la face tirée aléatoirement
	 */
	public int lancer() {
		this.faceTiree = De.rand.nextInt(nbFaces) + 1;
		return this.faceTiree;
	}


	/**
	 * Getter pour nbFaces: retourne le nombre de faces pour ce dé
	 * @return the nbFaces
	 */
	public int getNbFaces() {
		return nbFaces;
	}


	/**
	 * Setter pour nbFaces: modifie le nombre de faces pour ce dé
	 * @param nbFaces the nbFaces to set
	 * @throws Exception si le nombre de faces {@code nbFaces} est inférieur à 2
	 */
	public void setNbFaces(int nbFaces) throws Exception {
		De.verifNbFaces(nbFaces);
		this.nbFaces = nbFaces;
	}


	private static void verifNbFaces(int nbFaces) throws Exception {
		if(nbFaces <= 1)
			throw new Exception("Un dé doit avoir au moins 2 faces");
		
	}


	/**
	 * Getter pour faceTiree: retourne la dernière face tirée par ce dé
	 * @return the faceTiree
	 */
	public int getFaceTiree() {
		return faceTiree;
	}

}
