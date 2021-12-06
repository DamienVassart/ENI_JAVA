package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un rendez-vous
 * @author Damien Vassart
 *
 */

public class RendezVous {
	private Creneau creneau;
	private Patient patient;
	private LocalDate date;
	
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	public void afficher() {
		this.creneau.afficher();
		this.patient.afficher();
		String date = this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		System.out.println(date);
	}
}
