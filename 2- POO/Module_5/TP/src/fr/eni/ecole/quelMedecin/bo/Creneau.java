package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un créneau
 * @author Damien Vassart
 *
 */

public class Creneau {
	private LocalTime heureDebut;
	private int duree;
	private Medecin medecin;
	
	/**
	 * Constructeur créant une instance de Creneau, prenant en paramètre l'heure de début, la durée et le médecin
	 * @param heureDebut Heure de début
	 * @param duree Durée en minutes
	 * @param medecin Médecin concerné
	 */
	public Creneau(LocalTime heureDebut, int duree, Medecin medecin) {
		this.heureDebut = heureDebut;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}
	
	public void afficher() {
		String heureDebut = this.heureDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
		String heureFin = this.heureDebut.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
		System.out.printf("Heure de début: %s%nHeure de fin: %s%nDurée: %d minutes%n", heureDebut, heureFin, this.duree);
	}
	
	/**
	 * Getter pour medecin
	 * @return Le médecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}
}
