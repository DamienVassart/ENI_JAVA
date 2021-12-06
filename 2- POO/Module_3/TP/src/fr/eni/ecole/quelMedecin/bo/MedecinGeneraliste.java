package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant le médecin généraliste
 * @author Damien Vassart
 *
 */

public class MedecinGeneraliste {
	
	private String nom;
	private String prenom;
	private String telephone;
	private static int tarif = 25;
	
	
	/**
	 * Constructeur créant une instance de MedecinGeneraliste dont les nom, prénom, numéro de téléphone et tarif sont passés en paramètres
	 * @param nom Nom du médecin
	 * @param prenom Prénom du médecin
	 * @param telephone Numéro de téléphone du médecin
	 * @param tarif Tarif d'une consultation
	 */
	public MedecinGeneraliste(String nom, String prenom, String telephone) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.setNumeroDeTelephone(telephone);
	}
	
	/**
	 * Getter pour telephone
	 * @return le numéro de téléphone du médecin
	 */
	public String getNumeroDeTelephone() {
		return this.telephone;
	}
	
	/**
	 * Setter pour le numéro de téléphone du médecin
	 * @param telephone le numéro de téléphone à modifier
	 */
	public void setNumeroDeTelephone(String telephone) {
		this.telephone = telephone;
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
	
	/**
	 * Getter pour nom et prenom
	 * @return les nom et prénom du médecin
	 */
	public String getNom() {
		return nom + ' ' + prenom;
	}
	
	public void afficher() {
		System.out.println(getNom());
		System.out.println("Téléphone: " + getNumeroDeTelephone());
		System.out.printf("Tarif: %s €%n", getTarif());
	}
	
}
