package fr.eni.ecole.quelMedecin.bo;


/**
 * Classe modélisant un médecin spécialiste
 * @author Damien Vassart
 *
 */
public class MedecinSpecialiste extends Medecin {
	private String specialite;
	private int tarif;
	
	/**
	 * Constructeur créant une instance de MedecinSpecialiste
	 * @param nom Nom du médecin
	 * @param prenom Prénom du médecin
	 * @param telephone Numéro de téléphone du Médecin
	 * @param adresse Addresse postale du médecin
	 * @param specialite Spécialité du médecin
	 * @param tarif Tarif d'une consultation
	 */
	public MedecinSpecialiste(String nom, String prenom, String telephone, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, telephone, adresse);
		this.specialite = specialite;
		this.tarif = tarif;
	}
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.printf("Spécialité: %s%nTarif: %d%n", this.specialite, this.tarif);
		this.afficherAdresseEtCreneaux();
	}
}
