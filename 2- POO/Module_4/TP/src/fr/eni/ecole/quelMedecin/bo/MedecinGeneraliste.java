package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant le médecin généraliste
 * @author Damien Vassart
 *
 */

public class MedecinGeneraliste {
	public static final int MAX_CRENEAUX = 15;
	
	private String nom;
	private String prenom;
	private String telephone;
	private static int tarif = 25;
	private Adresse adresse;
	private Creneau[] creneaux = new Creneau[MAX_CRENEAUX];
	
	
	/**
	 * Constructeur créant une instance de MedecinGeneraliste dont les nom, prénom, numéro de téléphone et tarif sont passés en paramètres
	 * @param nom Nom du médecin
	 * @param prenom Prénom du médecin
	 * @param telephone Numéro de téléphone du médecin
	 * @param tarif Tarif d'une consultation
	 */
	public MedecinGeneraliste(String nom, String prenom, String telephone, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.setNumeroDeTelephone(telephone);
		this.adresse = adresse;
	}
	
	/**
	 * Getter pour nom et prenom
	 * @return les nom et prénom du médecin
	 */
	public String getNom() {
		return nom + ' ' + prenom;
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
	 * Getter pour adresse
	 * @return L'adresse du médecin
	 */
	public Adresse getAdresse() {
		return this.adresse;
	}
	
	public void ajouterCreneau(Creneau c) {
		if(this != c.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin");
		} else {
			int pos = 0;
			while(pos < this.creneaux.length && this.creneaux[pos] != null) 
				pos++;
			if(pos == this.creneaux.length)
				System.err.println("Aucun créneau de disponible");
			else
				this.creneaux[pos] = c;
		}
	}
	
	public void afficher() {
		System.out.println(getNom());
		System.out.println("Téléphone: " + getNumeroDeTelephone());
		System.out.printf("Tarif: %s €%n", getTarif());
		System.out.println("Adresse:");
		this.adresse.afficher();
		System.out.println("Créneaux:");
		for(int i = 0; i < this.creneaux.length; i++) {
			if(this.creneaux[i] != null) {
				this.creneaux[i].afficher();
			}
		}
	}
	
}
