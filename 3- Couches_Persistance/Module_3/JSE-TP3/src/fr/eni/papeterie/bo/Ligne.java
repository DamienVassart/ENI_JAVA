package fr.eni.papeterie.bo;

public class Ligne {

	private Article article;
	private int qte;

	public Ligne(Article article, int qte) {
		this.article = article;
		this.qte = qte;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return this.article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the qte
	 */
	public int getQte() {
		return this.qte;
	}

	/**
	 * @param qte the qte to set
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public float getPrixUnitaire() {
		return this.article.getPrixUnitaire();
	}

	@Override
	public String toString() {
		return "Ligne [article=" + this.article + ", qte=" + this.qte + "]";
	}

	

}
