package fr.eni.tp;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Calendar {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		String option;
		
		do {
			displayMonth(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
			
			System.out.println("- : mois précédent; + : mois suivant; d : saisir année et mois; q : quitter");
			option = scan.nextLine();
			
			switch(option) {
			case "-":
				date.add(GregorianCalendar.MONTH, -1);
				break;
			case "+":
				date.add(GregorianCalendar.MONTH, 1);
				break;
			case "d":
				System.out.println("Année:");
				int year = scan.nextInt();
				scan.nextLine();
				System.out.println("Mois:");
				int month = scan.nextInt();
				scan.nextLine();
				date.set(year, month, 1);
				break;
			case "q":
				System.out.println("Au revoir !");
				break;
			default:
				System.out.println("Saisie invalide");
				break;
		}
			
		} while(!option.equals("q"));
		
	}
	
	private static void displayMonth(int year, int month) {
		GregorianCalendar date = new GregorianCalendar(year, month, 1);
		
		System.out.printf("  * %s %d *%n",
				date.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
				date.get(GregorianCalendar.YEAR)
				);
		System.out.println("--------------------");
		System.out.println("L  Ma Me J  V  S  D");
		
		int dayOfWeek = date.get(GregorianCalendar.DAY_OF_WEEK);
		int offset = Math.abs((dayOfWeek + 7) - 9);
		String blankSpace = (" ").repeat(3 * offset);
		System.out.print(blankSpace);
		
		int nbDays = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		for(int i = 1; i <= nbDays; i++) {
			System.out.printf("%02d ", date.get(GregorianCalendar.DAY_OF_MONTH));
			date.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY)
				System.out.println();
		}
		System.out.println();
	}

}
