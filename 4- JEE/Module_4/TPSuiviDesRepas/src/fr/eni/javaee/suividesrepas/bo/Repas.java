package fr.eni.javaee.suividesrepas.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Repas {
	private int identifiant;
	private LocalDate date;
	private LocalTime heure;
	private List<Aliment> listeAliments;
	
	public Repas(int identifiant, LocalDate date, LocalTime heure, List<Aliment> listeAliments) {
		super();
		this.identifiant = identifiant;
		this.date = date;
		this.heure = heure;
		this.listeAliments = listeAliments;
	}
	
	public Repas(LocalDate date, LocalTime heure, List<Aliment> listeAliemnts) {
		super();
		this.date = date;
		this.heure = heure;
		this.listeAliments = listeAliemnts;
	}

	public Repas() {
	}

	public int getIdentifiant() {
		return this.identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getHeure() {
		return this.heure;
	}
	
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	public List<Aliment> getListeAliments() {
		return this.listeAliments;
	}
	
	public void setListeAliemnts(List<Aliment> listeAliments) {
		this.listeAliments = listeAliments;
	}

	@Override
	public String toString() {
		return "Repas [identifiant=" + this.identifiant + ", date=" + this.date + ", heure=" + this.heure + ", listeAliemnts="
				+ this.listeAliments + "]";
	}
	
	
}
