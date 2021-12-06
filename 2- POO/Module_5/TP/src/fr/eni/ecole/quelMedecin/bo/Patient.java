package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant le patient
 * @author Damien Vassart
 *
 */

public class Patient extends Personne {
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
	public Patient(String nom, String prenom, String telephone, char sexe, long numSecu, LocalDate dateNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, telephone, adresse);
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
					"Sexe: %s%nNuméro de sécurité sociale: %d%nDate de naissance: %s%nCommentaires: %s%n",
					sexe, this.numSecu, dateNaissance, commentaires);
		System.out.println("Adresse:");
		this.adresse.afficher();
	}
	
}
