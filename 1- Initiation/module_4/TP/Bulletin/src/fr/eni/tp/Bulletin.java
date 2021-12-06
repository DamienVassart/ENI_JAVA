package fr.eni.tp;

import java.util.Scanner;

public class Bulletin {
	static final int EMPLOYE = 1;
	static final int CADRE = 2;
	
	static final double CSGI = 3.49 / 100;
	static final double CSGNI = 6.15 / 100;
	static final double MALADIE = 0.95 / 100;
	static final double VIEILLESSE = 8.44 / 100;
	static final double CHOMAGE = 3.05 / 100;
	static final double RETRAITE = 3.81 / 100;
	static final double AGFF = 1.02 / 100;
	
	public static void main(String[] args) {
		String lastName = null;
		String firstName = null;
		
		double gross = 0;
		double simpleRate = 0;
		double doubleRate = 0;
		double contributions = 0;
		double net = 0;
		int familyBonus = 0;
		double due = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(lastName == null || lastName.trim().isEmpty()) {
			System.out.println("Nom: ");
			lastName = scanner.nextLine();
		}
		
		while(firstName == null || firstName.trim().isEmpty()) {
			System.out.println("Prénom: ");
			firstName = scanner.nextLine();
		}
		
		System.out.println("Statut: ");
		int status = scanner.nextInt();
		
		System.out.println("Heures: ");
		int hours = scanner.nextInt();
		
		System.out.println("Taux: ");
		float rate = scanner.nextFloat();
		
		System.out.println("Enfants: ");
		int children = scanner.nextInt();
		
		if(hours > 180) {
			simpleRate = rate * 1.5 * (hours - 169 - (hours - 180));
			doubleRate = rate * 1.6 * (hours - 180);
			gross = 169 * rate + simpleRate + doubleRate;
		}
		else if(hours > 169 && hours <= 180) {
			simpleRate = rate* 1.5 * (hours - 169);
			gross = 169 * rate + simpleRate;
		}
		else if(hours <= 169) {
			gross = hours * rate;
		}

		contributions = gross * (CSGI + CSGNI + MALADIE + VIEILLESSE + CHOMAGE + RETRAITE + AGFF);
		
		net = gross - contributions;
		
		if(children == 1) {
			familyBonus = 20;
		}
		else if(children == 2) {
			familyBonus = 50;
		}
		else if(children > 2) {
			familyBonus = 70 + 20 * (children - 2);
		}
		
		due = net + familyBonus;
		
		System.out.println("Nom: " + lastName);
		System.out.println("Prénom: " + firstName);
		switch(status) {
			case EMPLOYE:
				System.out.println("Statut: Employé");
				break;
			case CADRE:
				System.out.println("Statut: Cadre");
				break;
			default: 
				System.out.println("Statut inconnu");
		}
		System.out.println("Heures majorées simples: " + simpleRate);
		System.out.println("Heures majorées doubles: " + doubleRate);
		System.out.println("Salaire brut de base: " + gross);
		System.out.println("Total des cotisations: " + contributions);
		if(familyBonus > 0) {
			System.out.println("Prime famille: " + familyBonus);
		}
		System.out.println("Net à payer: " + due);
		
		scanner.close();
	}

}
