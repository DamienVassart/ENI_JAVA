package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant le patient
 * @author Damien Vassart
 *
 */

public class Patient {
	private String nom;
	private String prenom;
	private String telephone;
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;
	
	/**
	 * Constructeur créant une instance de Patient, prenant en paramètres les informations le concernant
	 * @param nom Nom du patient
	 * @param prenom Prénom du patient
	 * @param telephone Numéro de téléphone du patient
	 * @param sexe Sexe du patient
	 * @param numSecu Numéro de sécu du patient
	 * @param dateNaissance Date de naissance du patient
	 * @param commentaires Commentaires éventuels
	 */
	public Patient(String nom, String prenom, String telephone, char sexe, long numSecu, LocalDate dateNaissance, String commentaires) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.telephone = telephone;
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
	}
	
	public void afficher() {
		String sexe = this.sexe == 'F' ? "Feminin" : "Masculin";
		String dateNaissance = this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		String commentaires = this.commentaires == null ? "Neant" : this.commentaires;
		System.out.printf(
					"%s %s%n Téléphone: %s%n Sexe: %s%n Numéro de sécurité sociale: %d%n Date de naissance: %s%n Commentaires: %s%n",
					this.nom, this.prenom, this.telephone, sexe, this.numSecu, dateNaissance, commentaires
				);
	}
	
}
