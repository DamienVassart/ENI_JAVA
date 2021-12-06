package fr.eni.tp;

import java.util.Scanner;

/**
 * 
 * @author dvassart2021
 * Program returning checks statistics after submission
 *
 */

public class Cheques {

	public static void main(String[] args) {
		// Checks submission variables
		int checkId = 0;
		int numberOfChecks = 0;
		double amount = 0;
		double total = 0;
		double average = 0;
		
		// Smaller than 200€ variables
		int smaller = 0;
		double smallerTotal = 0;
		
		// Bigger than 200€ variables
		int bigger = 0;
		double biggerTotal = 0;
		
		// Smallest check variables
		int smallestId = 0;
		double smallestAmount = Double.POSITIVE_INFINITY;
		
		// Biggest check variables
		int biggestId = 0;
		double biggestAmount = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		// Check submission
		do {
			System.out.println("Numéro de chèque: ");
			checkId = scanner.nextInt();
			// If check number ≠ 0:
			if(checkId != 0) {
				numberOfChecks++;
				System.out.println("Montant: ");
				amount = scanner.nextDouble();
				total += amount;
				if(amount < 200) {
					smaller++;
					smallerTotal += amount;
				}
				if(amount >= 200) {
					bigger++;
					biggerTotal += amount;
				}
				if(amount < smallestAmount) {
					smallestId = checkId;
					smallestAmount = amount;
				}
				if(amount > biggestAmount) {
					biggestId = checkId;
					biggestAmount = amount;
				}
				
			}
		} while(checkId != 0);
		
		average = total / numberOfChecks;
		
		// Display returned statistics:
		System.out.println("-------------- Récapitulatif des saisies -----------------");
		System.out.println("Nombre de chèques: " + numberOfChecks);
		System.out.println("Montant total: " + total + "€");
		System.out.println("Montant moyen: " + average + "€");
		System.out.println("Nombre de petits chèques (< 200€): " + smaller + " (montant total: " + smallerTotal + "€)");
		System.out.println("Nombre de gros chèques (>= 200€): " + bigger + " (montant total: " + biggerTotal + "€)");
		System.out.println("Plus petit chèque: #" + smallestId + " (" + smallestAmount + "€)");
		System.out.println("Plus gros chèque: #" + biggestId + " (" + biggestAmount +"€)");
		
		scanner.close();
	}

}
