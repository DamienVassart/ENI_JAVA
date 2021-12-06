package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe modélisant un Gyroroue
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class Gyroroue extends CycleElectrique {
	
	public Gyroroue(String marque, String modele, LocalDate dateAchat, int autonomieKm) {
		super(marque, modele, dateAchat, autonomieKm);
	}
	
	/**
	 * Renvoie le tarif horaire de location
	 */
	@Override
	public double getTarifLocationHeure() {
		return 18.9;
	}
}
