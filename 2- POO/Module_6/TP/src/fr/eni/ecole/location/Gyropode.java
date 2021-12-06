package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe modélisant un gyropode
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class Gyropode extends CycleElectrique {
	private int tailleMinCm;
	
	public Gyropode(String marque, String modele, LocalDate dateAchat, int autonomieKm, int tailleMinCm) {
		super(marque, modele, dateAchat, autonomieKm);
		this.tailleMinCm = tailleMinCm;
	}
	
	/**
	 * Renvoie le tarif horaire de location
	 */
	@Override
	public double getTarifLocationHeure() {
		return 29.9;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%dm%d min]", super.toString(), this.tailleMinCm/100, this.tailleMinCm%100);
		
	}
}
