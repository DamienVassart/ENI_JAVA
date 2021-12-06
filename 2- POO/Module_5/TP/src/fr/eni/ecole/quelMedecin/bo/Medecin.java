package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant un médecin
 * @author Damien Vassart
 *
 */
public class Medecin extends Personne {
	public static final int MAX_CRENEAUX = 15;
	
	private Creneau[] creneaux = new Creneau[MAX_CRENEAUX];
	
	/**
	 * Constructeur créant une instance de Medecin
	 * @param nom Nom du médecin
	 * @param prenom Prénom du médecin
	 * @param telephone Numéro de téléphone du médecin
	 * @param adresse Adresse postale du médecin
	 */
	public Medecin(String nom, String prenom, String telephone, Adresse adresse) {
		super(nom, prenom, telephone, adresse);
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
	 * Affiche l'adresse postale et les créneaux du médecin
	 */
	public void afficherAdresseEtCreneaux() {
		System.out.println("Adresse:");
		this.adresse.afficher();
		System.out.println("Créneaux:");
		for(int i = 0; i < this.creneaux.length; i++) {
			if(this.creneaux[i] != null) {
				this.creneaux[i].afficher();
			}
		}
	}
	
	/**
	 * Permet l'ajout d'un créneau
	 * @param c Créneau à ajouter
	 */
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
}
