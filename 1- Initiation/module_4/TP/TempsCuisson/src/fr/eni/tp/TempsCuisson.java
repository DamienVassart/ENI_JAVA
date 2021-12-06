package fr.eni.tp;

import java.util.Scanner;

/**
 * 
 * @author dvassart2021
 * Calcule le temps de cuisson selon le type de viande, le mode de cuisson désiré et le poids
 *
 */

public class TempsCuisson {
	static final int BOEUF = 1;
	static final int PORC = 2;
	
	static final int BLEU = 1;
	static final int A_POINT = 2;
	static final int BIEN_CUIT = 3;
	
	static final int BLEU_BOEUF = 20;
	static final int A_POINT_BOEUF = 34;
	static final int BIEN_CUIT_BOEUF = 50;
	static final double BLEU_PORC = 32.5
	static final double A_POINT_PORC = 62.5;
	static final int BIEN_CUIT_PORC = 100;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type de viande (1: Boeuf, 2: Porc):");
		int type = scanner.nextInt();
		
		System.out.println("Mode de cuisson (1: Bleu, 2: A Point, 3: Bien Cuit):");
		int cuisson = scanner.nextInt();
		
		System.out.println("Poids (en g): ");
		int poids = scanner.nextInt();
		
		int temps = 0;
		
		if(type == BOEUF) {
			switch(cuisson) {
				case BLEU:
					temps = (int)(BLEU_BOEUF * poids / 1000 * 60);
					break;
				case A_POINT:
					temps = (int)(A_POINT_BOEUF * poids / 1000 * 60);
					break;
				case BIEN_CUIT:
					temps = (int)(BIEN_CUIT_BOEUF * poids / 1000 * 60);
					break;
				default:
					System.out.println("Mode de cuisson inconnu");
					break;
			}
		}
		else if(type == PORC) {
			switch(cuisson) {
				case BLEU:
					temps = (int)(BLEU_PORC * poids / 1000 * 60);
					break;
				case A_POINT:
					temps = (int)(A_POINT_PORC * poids / 1000 * 60);
					break;
				case BIEN_CUIT:
					temps = (int)(BIEN_CUIT_PORC * poids / 1000 * 60);
					break;
				default:
					System.out.println("Mode de cuisson inconnu");
					break;	
			}
		}
		else {
			System.out.println("Type de viande inconnu");
		}
		System.out.println("Temps de cuisson: " + temps + "s");
	}
}
