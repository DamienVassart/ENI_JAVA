package fr.eni.papeterie.bo;

public class Ramette extends Article {
	
	private int grammage;
	
	/**
	 * Constructeur vide
	 * Appelle le constructeur vide de la classe Article 
	 */
	public Ramette() {
		super();
	}

	public Ramette(Integer idArticle, 
			String marque, String reference, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public Ramette(
			String marque, String reference, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	/**
	 * @return the grammage
	 */
	public int getGrammage() {
		return this.grammage;
	}

	/**
	 * @param grammage the grammage to set
	 */
	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}
	
	@Override
	public String toString() {
		return "Ramette [grammage=" + this.grammage 
				+ ", getIdArticle()=" + this.getIdArticle() + ", getMarque()=" + this.getMarque()
				+ ", getReference()=" + this.getReference() + ", getDesignation()=" + this.getDesignation()
				+ ", getPrixUnitaire()=" + this.getPrixUnitaire() + ", getQteStock()=" + this.getQteStock() + "]";
	}

	
}
