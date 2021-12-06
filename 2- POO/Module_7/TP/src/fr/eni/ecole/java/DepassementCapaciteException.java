package fr.eni.ecole.java;

/**
 * Classe modélisant une exception contrôlée pour un dépassement de capacité
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class DepassementCapaciteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DepassementCapaciteException() {
		super("Le résultat dépasse la capacité de la calculatrice");
	}

}
