package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant le médecin généraliste
 * @author Damien Vassart
 *
 */

public class MedecinGeneraliste extends Medecin {
	private static int tarif = 25;
	
	
	/**
	 * Constructeur créant une instance de MedecinGeneraliste dont les nom, prénom, numéro de téléphone et tarif sont passés en paramètres
	 * @param nom Nom du médecin
	 * @param prenom Prénom du médecin
	 * @param telephone Numéro de téléphone du médecin
	 * @param tarif Tarif d'une consultation
	 */
	public MedecinGeneraliste(String nom, String prenom, String telephone, Adresse adresse) {
		super(nom, prenom, telephone, adresse);
	}
	
	/**
	 * Getter pour tarif
	 * @return le tarif d'une consultation
	 */
	public int getTarif() {
		return MedecinGeneraliste.tarif;
	}
	
	/**
	 * Setter pour le tarif d'une consultation
	 * @param tarif le tarif d'une consultation
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
	
	public void afficher() {
		super.afficher();
		System.out.printf("Tarif: %s €%n", getTarif());
		this.afficherAdresseEtCreneaux();
	}
	
}
