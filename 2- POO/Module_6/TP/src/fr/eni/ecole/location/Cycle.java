package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe abstraite modélisant un Cycle
 * @author Damien Vassart
 * @version 1.0
 *
 */
public abstract class Cycle {
	private String marque;
	private String modele;
	private LocalDate dateAchat;
	
	/**
	 * Constructeur de cycle
	 * @param marque Marque du cycle
	 * @param modele Modele du cycle
	 * @param dateAchat Date d'achat du cycle
	 */
	public Cycle(String marque, String modele, LocalDate dateAchat) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;
	}
	
	/**
	 * Calcule l'age du cycle en fonction de sa date d'achat
	 * @return l'age du cycle
	 */
	public int age() {
		return dateAchat.until(LocalDate.now()).getYears();
	}
	
	/**
	 * Indique le tarif de location à l'heure
	 * @return le tarif de location horaire
	 */
	public abstract double getTarifLocationHeure();
	
	@Override
	public String toString() {
		int age = this.age();
		return String.format("%s %s %s (%dan%s)", 
				this.getClass().getSimpleName(), this.marque, this.modele, age, age > 1 ? "s" : ""
					);
	}
}
