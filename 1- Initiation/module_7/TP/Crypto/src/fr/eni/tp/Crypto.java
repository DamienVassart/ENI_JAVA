package fr.eni.tp;

import java.util.Scanner;

public class Crypto {
	// Scan string input
	public static String prompt(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	// Compute char code from plain text char code with matching encryption key char code
	public static int computeCharCode(int a, int b) {
		int sum = a + (b - 65);
		int charCode = sum <= 90 ? sum : 65 + (sum % 90) - 1;
		return charCode;
	}
	
	// Encrypt plain text according to the encryption key
	public static String encrypt(char[] plainText, char[] key) {
		String cipherText = "";
		for(int i = 0; i < plainText.length; i++) {
			int plainTextCode = (int)(plainText[i]);
			int keyCode = (int)(key[i % key.length]); 
			cipherText += (char)(computeCharCode(plainTextCode, keyCode));
		}
		return cipherText;
	}

	public static void main(String[] args) {
		// Prompt for plain text
		String plainText = null;
		do {
			plainText = prompt("Saisissez le texte à chiffrer: ").toUpperCase();
		} while(plainText == "");
		
		// Prompt for encryption key
		String key = null;
		do {
			key = prompt("Saisissez la clé de chiffrement: ").toUpperCase();
		} while(key == "" || key.length() > 8);
		
		// Print cipher text
		System.out.println(encrypt(plainText.toCharArray(), key.toCharArray()));
		
	}

}
