package fr.eni.tp;

import java.util.Scanner;

public class MaxCompare {
	
	public static int typeNum(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public static int compare(int a, int b) {
		if (a == b) {
			return 0;
		}
		else if (a > b) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int a = typeNum("Saisissez un entier: ");
		int b = typeNum("Saissez un autre entier: ");
		int comp = compare(a, b);
		int max = max(a, b);
		switch(comp) {
			case 0:
				System.out.println(a + " et " + b + " sont égaux");
				break;
			default:
				System.out.println("Le plus grand nombre est: " + max);
				break;
		}
	}

}
