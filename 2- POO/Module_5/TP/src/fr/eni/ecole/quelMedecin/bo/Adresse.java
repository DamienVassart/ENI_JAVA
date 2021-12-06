package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant l'adresse
 * @author Damien Vassart
 *
 */

public class Adresse {
	private String mentionsComplementaires;
	private int numeroVoie;
	private String complementNumero;
	private String nomVoie;
	private int codePostal;
	private String localite;
	
	/**
	 * Constructeur complet
	 * @param mentionsComplementaires Complément d'adresse (interphone, appartement, étage, ...)
	 * @param numeroVoie Numéro dans la voie
	 * @param complementNumero Suffixe de numéro (bis, ter, ...)
	 * @param nomVoie Type et nom de la voie
	 * @param codePostal Code postal
	 * @param localite Nom de la localité
	 */
	public Adresse(String mentionsComplementaires, int numeroVoie, String complementNumero, String nomVoie, int codePostal, String localite) {
		this.mentionsComplementaires = mentionsComplementaires;
		this.numeroVoie = numeroVoie;
		this.complementNumero = complementNumero;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.localite = localite;
	}
	
	/**
	 * Constructeur sans les mentions complémentaires
	 * @param numeroVoie Numéro dans la voie
	 * @param complementNumero Suffixe de numéro (bis, ter, ...)
	 * @param nomVoie Type et nom de la voie
	 * @param codePostal Code postal
	 * @param localite Nom de la localité
	 */
	public Adresse(int numeroVoie, String complementNumero, String nomVoie, int codePostal, String localite) {
		this(null, numeroVoie, complementNumero, nomVoie, codePostal, localite);
	}
	
	public void afficher() {
		String mentionsComplementaires = this.mentionsComplementaires != null ? this.mentionsComplementaires + "\n" : "";
		String complementNumero = this.complementNumero != null ? this.complementNumero : "";
		
		System.out.printf(
				"%s%d%s %s%n%05d %s%n", 
				mentionsComplementaires, this.numeroVoie, complementNumero, this.nomVoie, this.codePostal, this.localite
				);
	}
}
