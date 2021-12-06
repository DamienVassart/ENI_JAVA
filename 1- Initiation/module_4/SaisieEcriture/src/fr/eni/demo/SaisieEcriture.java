package fr.eni.demo;

import java.util.Scanner;

public class SaisieEcriture {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Type an int: ");
		int firstInt = scanner.nextInt();

		System.out.println("Type another int: ");
		int secondInt = scanner.nextInt();

		int sum = firstInt + secondInt;

		System.out.println("The sum is equal to: " + sum);

	}

}
