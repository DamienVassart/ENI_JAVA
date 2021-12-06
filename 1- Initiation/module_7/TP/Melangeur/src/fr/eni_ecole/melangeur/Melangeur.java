package fr.eni_ecole.melangeur;

import java.util.Scanner;

public class Melangeur {
	
	public static String prompt(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public static String shuffle(String word) {
		char letters[] = word.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			int j = (int)(Math.random() * letters.length);
			char tmp = letters[i];
			letters[i] = letters[j];
			letters[j] = tmp;
		}
		return new String(letters);
	}
	
	public static String mixer(String s) {
		String[] sub = s.substring(1, s.length() - 1).split(" ");
		String[] result = new String[sub.length];
		for(int i = 0; i < sub.length; i++) {
			result[i] = shuffle(sub[i]);
		}
		return String.join(" ", result);
	}
	
	public static void printMixed(String s) {
		int l = s.length();
		char first = s.charAt(0);
		String middle = mixer(s);
		char last = s.charAt(l - 1);
		System.out.println(first + middle + last);
	}
	
	public static void main(String[] args) {
		String s = prompt("Saisissez une phrase: ");

		printMixed(s);
	}

}
