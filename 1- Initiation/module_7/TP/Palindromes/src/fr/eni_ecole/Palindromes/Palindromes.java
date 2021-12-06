package fr.eni_ecole.Palindromes;

import java.util.Scanner;

public class Palindromes {
	
	public static String promptForString(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		if(s != "") {
			scan.close();
		}
		return s;
	}
	
	public static String reverseString(String s) {
		StringBuilder reversed;
		reversed = new StringBuilder("");
		String[] strArray = s.split("");
		for(int i = strArray.length - 1; i >= 0; i--) {
			reversed.append(strArray[i]);
		}
		return reversed.toString();
	}
	
	public static String isPalindrome(String s) {
		String answer = s.equalsIgnoreCase(reverseString(s)) ? "est" : "n'est pas";
		return answer + " un palindrome";
	}

	public static void main(String[] args) {
		String s = null;
		do {
			s = promptForString("Saisissez une phrase: ");
		} while (s == "");
		
		System.out.println("La phrase " + isPalindrome(s.replace(" ", "")));
		
	}

}
