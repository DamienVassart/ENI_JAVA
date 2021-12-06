package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe modélisant un Velo
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class Velo extends Cycle {
	private int nbVitesses;
	
	public Velo(String marque, String modele, LocalDate dateAchat, int nbVitesses) {
		super(marque, modele, dateAchat);
		this.nbVitesses = nbVitesses;
	}
	
	/**
	 * Renvoie le tarif horaire de location
	 */
	@Override
	public double getTarifLocationHeure() {
		return 4.9;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d vitesse%s", 
				super.toString(), this.nbVitesses, this.nbVitesses > 1 ? "s" : "");
		
	}
}
