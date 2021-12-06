package fr.eni.papeterie.bo;

public abstract class Article {
	
	private Integer idArticle;
	private String marque;
	private String reference;
	private String designation;
	private float prixUnitaire;
	private int qteStock;
	
	/**
	 * Constructeur Vide
	 * Sera appelé par les constructeurs vides des classes Stylo et Ramette
	 */
	public Article() {
		super();
	}
	
	/**
	 * Constructeur créant une instance d'Article pour un article DEJA PRESENT en BDD (<=> qui a déjà un id)
	 * Utilisable sur les requêtes SELECT, UPDATE, DELETE
	 * @param idArticle
	 * @param marque
	 * @param reference
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Article(Integer idArticle, 
			String marque, String reference, String designation, float prixUnitaire, int qteStock) {
		super();
		this.idArticle = idArticle;
		this.marque = marque;
		this.reference = reference;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	/**
	 * Constructeur créant une instance d'Article pour un article PAS ENCORE PRESENT en BDD (<=> pas encore d'id)
	 * Utilisable sur les requêtes INSERT
	 * @param marque
	 * @param reference
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Article(
			String marque, String reference, String designation, float prixUnitaire, int qteStock) {
		// on fait appel au constructeur crée précédemment
		this(null, marque, reference, designation, prixUnitaire, qteStock);
	}

	/**
	 * @return the idArticle
	 */
	public Integer getIdArticle() {
		return this.idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return this.marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return this.designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the prixUnitaire
	 */
	public float getPrixUnitaire() {
		return this.prixUnitaire;
	}

	/**
	 * @param prixUnitaire the prixUnitaire to set
	 */
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return this.qteStock;
	}

	/**
	 * @param qteStock the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + this.idArticle + ", marque=" + this.marque 
				+ ", reference=" + this.reference + ", designation=" + this.designation 
				+ ", prixUnitaire=" + this.prixUnitaire + ", qteStock=" + this.qteStock + "]";
	}
	
}
