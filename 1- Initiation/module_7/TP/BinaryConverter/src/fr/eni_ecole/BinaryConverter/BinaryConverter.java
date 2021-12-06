package fr.eni_ecole.BinaryConverter;

import java.util.Scanner;

public class BinaryConverter {
	
	public static int promptForInt(int min, int max) {
		System.out.printf("Saisissez un entier entre %d et %d: ", min, max);
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n >= min && n <= max) {
			scan.close();
		}
		return n;
	}
	
	public static int nibbles(int n) {
		float bits = 0;
		while(Math.pow(2, bits) <= n) {
			bits++;
		}
		return (int) Math.ceil(bits / 4);
	}
	
	public static String addSpaces(String s, int n) {
		StringBuilder r;
		r = new StringBuilder("");
		for(int i = 0; i < (n - 1); i++) {
			r.append(s.substring(4 * i, 4 * (i + 1)) + " ");
		}
		r.append(s.substring(4 * (n - 1)));
		return r.toString();
	}
	
	public static String binaryString(int n) {
		StringBuilder r;
		r = new StringBuilder("");
		int maxPow = nibbles(n) * 4 - 1;
		int total = 0;
		for(int i = maxPow; i >= 0; i--) {
			int digit = (int) Math.pow(2, i);
			if(digit > n || total + digit > n) {
				r.append("0");
			}
			else {
				total += digit;
				r.append("1");
			}
		}
		return addSpaces(r.toString(), nibbles(n));
	}

	public static void main(String[] args) {
		int n = -1;
		do {
			n = promptForInt(0, 255);
		} while(n < 0 || n > 255);
		
		System.out.println(binaryString(n));
	}
	

}
