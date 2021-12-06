package fr.eni.tp;

import java.util.Scanner;
import java.lang.Math;

/**
 * 
 * @author dvassart2021
 * Displays the n first prime numbers (n = 1000 by default)
 */

public class PrimeNumbers {
	
	public static int chooseLimit(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		else if(n <= 1 || n%2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i+=2) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void displayPrimeNumbers(int limit) {
		for(int i = 0; i <= limit; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		int limit = 1;
		while(limit == 1) {
			limit = chooseLimit("Choisissez la limite: (0 pour aller jusqu'à 1000)");
		}
		
		if(limit != 0) {
			displayPrimeNumbers(limit);
		}
		else {
			displayPrimeNumbers(1000);
		}

	}

}
