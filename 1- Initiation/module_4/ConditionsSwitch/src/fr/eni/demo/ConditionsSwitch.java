/**
 * Asks for a number and tells if it is odd or even
 * */

package fr.eni.demo;

import java.util.Scanner;

public class ConditionsSwitch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type an number: ");

		int input = scanner.nextInt();

		switch(input%2) {
			case 0:
				System.out.println("The number is even");
				break;
			case 1:
				System.out.println("The number is odd");
				break;
			default:
				System.out.println("Error");
				break;
		}

	}

}
