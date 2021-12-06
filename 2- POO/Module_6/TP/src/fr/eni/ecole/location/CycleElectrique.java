package fr.eni.ecole.location;

import java.time.LocalDate;

public abstract class CycleElectrique extends Cycle {
	private int autonomieKm;
	
	public CycleElectrique(String marque, String modele, LocalDate dateAchat, int autonomieKm) {
		super(marque, modele, dateAchat);
		this.autonomieKm = autonomieKm;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d km d'autonomie ", super.toString(), this.autonomieKm);
		
	}
}
