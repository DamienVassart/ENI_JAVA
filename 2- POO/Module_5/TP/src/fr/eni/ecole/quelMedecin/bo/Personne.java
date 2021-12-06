package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant une personne
 * @author Damien Vassart
 *
 */
public class Personne {
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected Adresse adresse;
	
	/**
	 * Constructeur créant une instance de Personne et prenant en paramètres les nom, prénom, numéro de téléphone et adresse de la personne
	 * @param nom Nom de la personne
	 * @param prenom Prénom de la personne
	 * @param telephone Numéro de téléphone de la personne
	 * @param adresse Adresse postale de la personne
	 */
	public Personne(String nom, String prenom, String telephone, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.printf("Nom: %s %s%nTéléphone: %s%n", this.nom, this.prenom, this.telephone);
	}
}
