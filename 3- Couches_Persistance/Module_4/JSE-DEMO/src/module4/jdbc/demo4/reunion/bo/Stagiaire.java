package module4.jdbc.demo4.reunion.bo;

public class Stagiaire {
	
	private Integer noStagiaire;	
	private String prenom, nom, email, motDePasse;
	
//	//Constructeur vide
//	public Stagiaire(){
//	}
	
	//Constructeur avec paramètres
	public Stagiaire(Integer noStagiaire, String prenom, String nom, String email, String motDePasse) {		
		super();
		this.noStagiaire = noStagiaire;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	//Getters et Setters
	public Integer getNoStagiaire() {
		return this.noStagiaire;
	}

	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + this.noStagiaire + ", prenom=" + this.prenom + ", nom=" + this.nom + ", email=" + this.email + ", motDePasse=" + this.motDePasse + "]";
	}
	
	
}