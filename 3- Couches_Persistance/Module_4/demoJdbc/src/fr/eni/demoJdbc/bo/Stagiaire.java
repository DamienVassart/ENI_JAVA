package fr.eni.demoJdbc.bo;

public class Stagiaire {
	
	private int noStagiaire;	
	private String prenom, nom, email;
	
	//Constructeur vide
	public Stagiaire(){
	}
	
	//Constructeur avec paramètres
	public Stagiaire(int noStagiaire, String prenom, String nom, String email) {		
		super();
		this.noStagiaire = noStagiaire;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}

	//Getters et Setters
	public int getNoStagiaire() {
		return noStagiaire;
	}
	
	

	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Stagiaire [noStagiaire=" + noStagiaire + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
	}
	
	
}
