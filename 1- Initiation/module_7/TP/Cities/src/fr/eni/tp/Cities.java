package fr.eni.tp;

import java.util.Scanner;

public class Cities {
	
	public static String promptForInitial(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		String initial = scan.nextLine();
		if(initial != "") {
			scan.close();
		}
		return initial;
	}
	
	public static String random() {
		int random = (int)(Math.random() * 100);
		return String.valueOf(random);
	}
	
	public static void printArray(String[] arr) {
		for(String item : arr) {
			System.out.println(item);
		}
	}
	
	public static String printSelected(String[] arr, String letter) {
		StringBuilder selected;
		selected = new StringBuilder("");
		for(String item : arr) {
			if(item.substring(0, 1).equalsIgnoreCase(letter)) {
				selected.append(item + "\n");
			}
		}
		return selected.length() > 0 ? selected.toString() : "Aucune ville à afficher";
	}
	
	public static String[] alter(String[] arr) {
		String[] altered = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			altered[i] = arr[i] + random();
		}
		return altered;
	}

	public static void main(String[] args) {
		String[] cities = {"Lille", "Lens", "Amiens", "Rouen", "Caen", "Rennes", "Nantes", "Niort", "Bordeaux", "Bayonne"};
		System.out.println("Liste des villes: \n");
		printArray(cities);
		
		System.out.println("-----------------------------------");
		String initial = null;
		do {
			initial = promptForInitial("Afficher les villes commençant par une lettre: ");
		} while(initial.length() == 0 || initial.length() > 1);
		System.out.println(printSelected(cities, initial));
		
		System.out.println("-----------------------------------");
		String[] altered = alter(cities);
		printArray(altered);
	}

}
