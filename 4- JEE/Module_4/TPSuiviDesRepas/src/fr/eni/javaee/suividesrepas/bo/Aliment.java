package fr.eni.javaee.suividesrepas.bo;

public class Aliment {
	private int identifiant;
	private String nom;
	
	public Aliment(int identifiant, String nom) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
	}
	
	public Aliment(String nom) {
		super();
		this.nom = nom;
	}
	
	public Aliment() {
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public String toString() {
		return "Aliment [identifiant=" + this.identifiant + ", nom=" + this.nom + "]";
	}
	
	
}
