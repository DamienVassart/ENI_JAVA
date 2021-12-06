package fr.eni.papeterie.bo;

public class Stylo extends Article {
	
	private String couleur;
	
	/**
	 * Constructeur vide
	 * Appelle le constructeur vide de la classe Article 
	 */
	public Stylo() {
		super();
	}

	public Stylo(Integer idArticle, 
			String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public Stylo(
			String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return this.couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Stylo [couleur=" + this.couleur 
				+ ", getIdArticle()=" + this.getIdArticle() + ", getMarque()=" + this.getMarque()
				+ ", getReference()=" + this.getReference() + ", getDesignation()=" + this.getDesignation()
				+ ", getPrixUnitaire()=" + this.getPrixUnitaire() + ", getQteStock()=" + this.getQteStock() + "]";
	}

	

}
