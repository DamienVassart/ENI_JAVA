package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	
	private float montant;

	private List<Ligne> lignesPanier = new ArrayList<Ligne>();
	
	/**
	 * @return the montant
	 */
	public float getMontant() {
		montant = 0;
		for(Ligne ligne : lignesPanier) {
			montant += ligne.getPrixUnitaire() * ligne.getQte();
		}
		return this.montant;
	}

	public Ligne getLigne(int index) {
		return this.lignesPanier.get(index);
	}
	
	/**
	 * @return the lignesPanier
	 */
	public List<Ligne> getLignesPanier() {
		return this.lignesPanier;
	}
	
	public void addLigne(Article article, int qte) {
		this.lignesPanier.add(new Ligne(article, qte));
	}

	public void updateLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
	}

	public void removeLigne(int index) {
		this.lignesPanier.remove(index);
	}

	@Override
	public String toString() {
		return "Panier [montant=" + this.getMontant() + ", lignesPanier=" + this.lignesPanier + "]";
	}

}
