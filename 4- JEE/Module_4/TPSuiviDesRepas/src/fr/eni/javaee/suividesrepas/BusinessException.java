package fr.eni.javaee.suividesrepas;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErreur;

	public BusinessException() {
		this.listeCodesErreur = new ArrayList<>();
	}
	
	public void ajouterErreur(int code) {
		if(!listeCodesErreur.contains(code))
			listeCodesErreur.add(code);
	}
	
	public boolean hasErreur() {
		return this.listeCodesErreur.size() > 0;
	}

	public List<Integer> getListeCodesErreur() {
		return this.listeCodesErreur;
	}
}
