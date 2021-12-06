package fr.eni.demo;

import java.util.Scanner;

public class Methodes {

	public static String prompt(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public static void main(String[] args) {
		String name = prompt("Nom: ");
		System.out.println(name);

	}

}
