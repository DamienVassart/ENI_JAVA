package fr.eni.javaee.gestionlistescourses.bo;

import java.io.Serializable;
import java.util.List;

public class ListeCourses implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private List<Article> articles;
	
	public ListeCourses() {
		super();
	}
	
	public ListeCourses(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public ListeCourses(String nom) {
		super();
		this.nom = nom;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "ListeCourses [id=" + id + ", nom=" + nom + "]";
	}
	
}
